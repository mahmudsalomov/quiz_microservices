package uz.maniac4j.organizationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("service")
public class ServiceNames {
    private String participantService;
    private String quizService;

    public String getParticipantService() {
        return "http://"+participantService;
    }

    public void setParticipantService(String participantService) {
        this.participantService = participantService;
    }

    public String getQuizService() {
        return "http://"+quizService;
    }

    public void setQuizService(String quizService) {
        this.quizService = quizService;
    }
}
