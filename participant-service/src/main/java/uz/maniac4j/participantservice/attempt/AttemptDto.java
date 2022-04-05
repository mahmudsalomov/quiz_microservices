package uz.maniac4j.participantservice.attempt;

import lombok.*;
import uz.maniac4j.participantservice.attempt_answer.AttemptAnswerDto;
import uz.maniac4j.participantservice.participant.ParticipantDto;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttemptDto {
    private Long opb_id;
    private ParticipantDto participant;
    private boolean start;
    private Timestamp startDate;
    private Timestamp endDate;
    private List<AttemptAnswerDto> answers=new ArrayList<>();
}
