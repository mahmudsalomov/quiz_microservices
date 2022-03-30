package uz.maniac4j.participantservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ParticipantServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParticipantServiceApplication.class, args);
    }

}
