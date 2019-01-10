package com.lyl.springbatchintegration.edabatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.file.FileHeaders;

import java.io.File;

import static com.lyl.springbatchintegration.edabatch.Utils.mv;

/**
 * ClassName InvalidFileFlowConfiguration
 * Author liyunlong
 * Data 下午 4:05
 * <p>
 * 监听invalid 通道上传入的消息，并将传入的有效载荷 移动到errors目录 ,然后终止流程
 * Version 1.0
 **/
@Configuration
public class InvalidFileFlowConfiguration {

    @Bean
    IntegrationFlow invalidFlows(BatchChannels channels,
                                 @Value("${error-directory}") File errors) {
        StandardIntegrationFlow standardIntegrationFlow = IntegrationFlows
                .from(channels.invalid())
                .handle(JobExecution.class,
                        (je, headers) -> {
                            String ogFileName = String.class.cast(headers.get(FileHeaders.ORIGINAL_FILE));
                            File file = new File(ogFileName);
                            mv(file, errors);
                            return null;
                        }).get();
        return standardIntegrationFlow;
    }

}
