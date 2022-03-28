package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Answer extends EntityLong{
    @Column(columnDefinition = "text")
    private String text;
    @ManyToOne
    private Quiz quiz;
}
