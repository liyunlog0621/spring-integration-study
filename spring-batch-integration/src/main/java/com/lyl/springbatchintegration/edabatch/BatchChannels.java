package com.lyl.springbatchintegration.edabatch;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

/**
 * ClassName BatchChannels
 * Author liyunlong
 * Data 下午 3:33
 * Version 1.0
 **/
@Configuration
public class BatchChannels {

    @Bean
    MessageChannel invalid() {
        return MessageChannels.direct().get();
    }

    @Bean
    MessageChannel completed() {
        return MessageChannels.direct().get();
    }

}
