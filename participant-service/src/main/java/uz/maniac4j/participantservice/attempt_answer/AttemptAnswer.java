package uz.maniac4j.participantservice.attempt_answer;

import lombok.*;
import uz.maniac4j.participantservice.attempt.Attempt;
import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.template.EntityLong;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class AttemptAnswer extends EntityLong {



    @ManyToOne
    private Attempt attempt;


    private Long quizId;
    private Long answerId;


}
