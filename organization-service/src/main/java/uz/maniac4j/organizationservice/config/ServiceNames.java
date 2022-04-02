package uz.maniac4j.organizationservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("service")
public class ServiceNames {
    private String quiz;
    private String participant;

    public String getQuiz() {
        return "http://"+quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getParticipant() {
        return "http://"+participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

}
