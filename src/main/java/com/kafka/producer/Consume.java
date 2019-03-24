package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consume {

private static final Logger LOG = LoggerFactory.getLogger(Consume.class);

    @KafkaListener(topics = "${app.topic.example}" )
    public void receive(@Payload ConsumMap data,
                        @Headers MessageHeaders headers) {
        LOG.info("received data='{}'", data);

        headers.keySet().forEach(key -> {
            LOG.info("{}: {}", key, headers.get(key));
        });
    }

}
