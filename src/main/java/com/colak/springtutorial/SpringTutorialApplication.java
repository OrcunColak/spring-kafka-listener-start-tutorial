package com.colak.springtutorial;

import com.colak.springtutorial.service.KafkaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;

@SpringBootApplication
public class SpringTutorialApplication {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    public static void main(String[] args) {
        SpringApplication.run(SpringTutorialApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onAppStartedEvent() {
        MessageListenerContainer listenerContainer = registry.getListenerContainer(KafkaListener.CONSUMER_ID);
        if (listenerContainer != null) {
            listenerContainer.resume();
        }
    }

}
