//package com.lyl.springbatchintegration.eda;
//
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.dsl.MessageChannels;
//import org.springframework.integration.file.dsl.Files;
//import org.springframework.messaging.MessageChannel;
//
//import java.io.File;
//
///**
// * ClassName IntegrationConfiguration
// * Author liyunlong
// * Data 下午 3:07
// * Version 1.0
// **/
//
//@Configuration
//public class IntegrationConfiguration {
//
//    private final Log log = LogFactory.getLog(getClass());
//
//    @Bean
//    IntegrationFlow etFlow(@Value("${input-directory:${HOME}/Desktop/in}") File dir) {
//        return IntegrationFlows
//                //配置一个Spring Integration 入站适配器 file,告诉它如何消费传入的消息，以及轮询器应该以多少毫秒的速率扫描目录
//                .from(Files.inboundAdapter(dir).autoCreateDirectory(true)
//                        , consumer -> consumer.poller(spec -> spec.fixedRate(1000)))
//                //该方法宣布已经收到一个文件,然后转发有效载荷
//                .handle(File.class, (file, headers) -> {
//                    log.info("we noticed a new file, " + file);
//                    return file;
//                })
////                通过众所周知的MessageChannel实例，将请求路由到两个可能的集成流之一，这两个流来源于文件的扩展
//                .routeToRecipients(
//                        spec -> spec
//                                .recipient(csv(),
//                                        msg -> hasExt(msg.getPayload(), ".csv"))
//                                .recipient(txt(),
//                                        msg -> hasExt(msg.getPayload(), ".txt")))
//                .get();
//    }
//
//    private boolean hasExt(Object f, String ext) {
//        File file = File.class.cast(f);
//        boolean b = file.getName().toLowerCase().endsWith(ext.toLowerCase());
//        return b;
//
//    }
//
//    /**
//     * 扩展名为.txt的文件将通过该通道传输
//     *
//     * @return
//     */
//    @Bean
//    MessageChannel txt() {
//        return MessageChannels.direct().get();
//    }
//
//    /**
//     * 扩展名为.csv的文件将通过该通道传输
//     *
//     * @return
//     */
//    @Bean
//    MessageChannel csv() {
//        return MessageChannels.direct().get();
//    }
//
//    /**
//     * IntegrationFlow处理.txt文件
//     *
//     * @return
//     */
//    @Bean
//    IntegrationFlow txtFow() {
//        return IntegrationFlows.from(txt()).handle(File.class, (f, h) -> {
//            log.info("file is. txt!");
//            return null;
//        }).get();
//    }
//
//    /**
//     * IntegrationFlow处理.csv文件
//     *
//     * @return
//     */
//    @Bean
//    IntegrationFlow csvFlow() {
//        return IntegrationFlows.from(csv()).handle(File.class, (f, h) -> {
//            log.info("file is .csv!");
//            return null;
//        }).get();
//    }
//}
