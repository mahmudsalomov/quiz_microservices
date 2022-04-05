package uz.maniac4j.participantservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("service")
public class ServiceNames {
    private String quiz;
    private String organization;

    public String getQuiz() {
        return "http://"+quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
    }

    public String getOrganization() {
        return "http://"+organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

}
