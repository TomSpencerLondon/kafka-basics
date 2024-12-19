package org.example.processingservice;

import org.example.shared.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-name}", groupId = "${spring.kafka.group-id}")
    public void consume(Order order) {
        logger.info("Processing order: {}", order); // Uses the overridden toString method
    }
}
