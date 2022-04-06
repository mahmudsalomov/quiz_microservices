package uz.maniac4j.participantservice.attempt;

import lombok.*;
import uz.maniac4j.participantservice.attempt_answer.AttemptAnswer;
import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.template.EntityLong;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Attempt extends EntityLong {

    @Column(unique = true)
    private Long opbId;

    @ManyToOne
    private Participant participant;

    private boolean start;
    private Timestamp startDate;
    private Timestamp endDate;

    @OneToMany(mappedBy="attempt")
    @ToString.Exclude
    private Set<AttemptAnswer> answers;

}
