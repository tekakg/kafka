
package com.example.kafka.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic getTopic(){
        return TopicBuilder.name("secondTopic")
                .build();
    }

    @Bean
    public NewTopic getJsonTopic(){
        return TopicBuilder.name("firstJsonTopic")
                .build();
    }

}