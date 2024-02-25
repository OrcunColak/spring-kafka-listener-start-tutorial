package com.colak.springkafkaembeddedtesttutorial;

import com.colak.springkafkaembeddedtesttutorial.service.KafkaConsumer;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;

@SpringBootApplication
public class SpringKafkaBatchListenerTutorialApplication {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    public static void main(String[] args) {
        SpringApplication.run(SpringKafkaBatchListenerTutorialApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onAppStartedEvent() {
        MessageListenerContainer listenerContainer = registry.getListenerContainer(KafkaConsumer.CONSUMER_ID);
        if (listenerContainer != null) {
            listenerContainer.resume();
        }
    }

}
