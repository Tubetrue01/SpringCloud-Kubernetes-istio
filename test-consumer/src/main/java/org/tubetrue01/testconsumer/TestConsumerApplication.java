package org.tubetrue01.testconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TestConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestConsumerApplication.class, args);
    }

}
