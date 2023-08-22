package com.dekapx.apps.consumer;

import com.dekapx.apps.model.MessageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;

import java.util.function.Consumer;

@Slf4j
@Component
public class KafkaMessageConsumer {
    @Bean
    public Consumer<byte[]> consumer() {
        return message -> {
            log.info("Message Received - {}", convertToMessageModel(message));
        };
    }

    private MessageModel convertToMessageModel(byte[] bytes){
        return (MessageModel) SerializationUtils.deserialize(bytes);
    }
}
