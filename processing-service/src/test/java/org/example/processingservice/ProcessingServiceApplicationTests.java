package org.example.processingservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@EmbeddedKafka(partitions = 1, brokerProperties = {"log.dir=target/embedded-kafka-logs"})
@ActiveProfiles("test")
class ProcessingServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
