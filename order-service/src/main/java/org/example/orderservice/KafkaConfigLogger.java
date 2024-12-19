package org.example.orderservice;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class KafkaConfigLogger {

    private static final Logger logger = LoggerFactory.getLogger(KafkaConfigLogger.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @PostConstruct
    public void logKafkaConfig() {
        logger.info("Kafka Bootstrap Servers: {}", bootstrapServers);
    }
}

