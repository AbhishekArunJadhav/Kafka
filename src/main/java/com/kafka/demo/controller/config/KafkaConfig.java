package com.kafka.demo.controller.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("Spring_created_Topic",5,(short)1);
    }
}