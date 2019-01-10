package com.lyl.springintegrationbase;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

@SpringBootApplication
@ImportResource(locations = "classpath:integration/helloWorldDemo.xml")
public class SpringIntegrationBaseApplication {

    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/integration/helloWorldDemo.xml", SpringIntegrationBaseApplication.class);
        MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
        inputChannel.send(new GenericMessage<String>("World"));
          System.out.println("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
        context.close();
    }





}

