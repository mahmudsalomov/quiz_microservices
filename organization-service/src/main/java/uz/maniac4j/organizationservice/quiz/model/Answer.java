package uz.maniac4j.organizationservice.quiz.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
public class Answer extends EntityLong{
    private String text;
    private Quiz quiz;
    public Answer(Long id, Timestamp createdAt, boolean deleted, String text, Quiz quiz) {
        super(id, createdAt, deleted);
        this.text = text;
        this.quiz = quiz;
    }

    public Answer(String text, Quiz quiz) {
        this.text = text;
        this.quiz = quiz;
    }

    public void edited(Answer answer){
        text = answer.text;
        quiz = answer.quiz;
    }
}
