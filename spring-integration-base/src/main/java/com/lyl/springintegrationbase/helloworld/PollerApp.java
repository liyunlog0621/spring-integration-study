package com.lyl.springintegrationbase.helloworld;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName PollerApp
 * Author liyunlong
 * Data 下午 4:15
 * Version 1.0
 **/
public class PollerApp {
    @SuppressWarnings("resource")
    public static void main(String[] args) throws Exception{
        new ClassPathXmlApplicationContext("META-INF/spring/integration/delay.xml");
    }


}
