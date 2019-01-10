package com.lyl.springbatchintegration.edabatch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.file.FileHeaders;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.batch.runtime.JobExecution;
import java.io.File;
import java.util.List;

import static com.lyl.springbatchintegration.edabatch.Utils.mv;

/**
 * ClassName FinishedFileFlowConfiguration
 * Author liyunlong
 * Data 下午 3:50
 * Version 1.0
 * <p>
 * 监听completed通道上传入的消息，将传入的有效载荷移动到completed目录,然后查询写入数据的表
 **/
@Configuration
public class FinishedFileFlowConfiguration {

    private Log log = LogFactory.getLog(getClass());


    @Bean
    IntegrationFlow finishedJobsFlow(
            BatchChannels channels,
            @Value("${completed-directory}") File finished,
            JdbcTemplate jdbcTemplate) {
        StandardIntegrationFlow standardIntegrationFlow = IntegrationFlows
                .from(channels.completed())
                .handle(JobExecution.class,
                        (je, headers) -> {
                            String ogFileName = String.class.cast(headers
                                    .get(FileHeaders.ORIGINAL_FILE));
                            File file = new File(ogFileName);
                            List<Contact> contacts = jdbcTemplate.query(
                                    "select * from CONTACT",
                                    (rs, i) -> new Contact(
                                            rs.getString("full_name"),
                                            rs.getString("email"),
                                            rs.getBoolean("valid_email"),
                                            rs.getLong("id")
                                    ));
                            mv(file, finished);
                            contacts.forEach(log::info);
                            return null;
                        }).get();
        return standardIntegrationFlow;
    }

}
