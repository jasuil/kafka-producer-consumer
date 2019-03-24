package com.kafka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
class Produce {

    private static final Logger LOG = LoggerFactory.getLogger(Produce.class);

    @Autowired
    private KafkaTemplate<String, ConsumMap> kafkaTemplate;

    @Value("${app.topic.example}")
    private String topic;

    public void send(ConsumMap data){
        LOG.info("sending data='{}' to topic='{}'", data, topic);

        Message<ConsumMap> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }

}
