package com.lyl.springbatchintegration.edabatch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchRequest;
import org.springframework.batch.integration.launch.JobLaunchingGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static org.springframework.integration.file.FileHeaders.ORIGINAL_FILE;

/**
 * ClassName EtlFolwConfiguration
 * Author liyunlong
 * Data 下午 3:36
 * Version 1.0
 * <p>
 * 主流程 以固定的速率监视一个目录 并将每个事件转换成jobLaunchRequest
 **/
@Configuration
public class EtlFolwConfiguration {


    @Bean
    IntegrationFlow etlFlow(
            @Value("${input-directory}") File directory,
            BatchChannels channels,
            JobLauncher launcher,
            Job job) {
        StandardIntegrationFlow standardIntegrationFlow = IntegrationFlows
                // 配置一个Spring Integration 入站适配器 file,告诉它如何消费传入的消息，以及轮询器应该以多少毫秒的速率扫描目录
                .from(Files.inboundAdapter(directory).autoCreateDirectory(true), cs -> cs.poller(p -> p.fixedRate(1000)))
                //该方法宣布已经收到一个文件,然后转发有效载荷
                .handle(File.class, (file, headers) -> {
                    String absolutePath = file.getAbsolutePath();
                    System.out.println(file.getPath());
                    System.out.println(absolutePath);
                    //使用JobParametersBuilder为SpringBatch作业设置JobParameters
                    JobParameters params = new JobParametersBuilder()
                            .addString("file", absolutePath)
                            .addString("time", "最后执行时间：" + LocalDateTime.now(ZoneOffset.of("+8")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss")))
                            .toJobParameters();
                    return MessageBuilder
                            .withPayload(new JobLaunchRequest(job, params))
                            .setHeader(ORIGINAL_FILE, absolutePath)
                            .copyHeadersIfAbsent(headers)
                            .build();
                })
                // 将作业和作业的相关参数发送给JobLaunchingGateway
                .handle(new JobLaunchingGateway(launcher))
                //通过检查JobExecution来测试作业是否正常退出
                .routeToRecipients(
                        //检查Job的ExitStatus并确定输入文件应该移动到那个目录，如果成功则被路由到completed通道
                        //如果出现错误终止了作业，他将被路由到invalid通道
                        spec -> spec
                                .recipient(channels.invalid(), "")
                                .recipient(channels.completed()))
                .get();
        // @formatter:off
        return standardIntegrationFlow;


        // @formatter:on
    }

    private boolean finished(Message<?> msg) {
//        Object payload = msg.getPayload();
//        return JobExecution.class.cast(payload).getExitStatus()
//                .equals(ExitStatus.COMPLETED);
        return true;
    }

    private boolean notFinished(Message<?> msg) {
        return !this.finished(msg);
    }
}
