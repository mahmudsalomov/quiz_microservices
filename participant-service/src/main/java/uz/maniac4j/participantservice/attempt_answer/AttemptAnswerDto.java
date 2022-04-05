package uz.maniac4j.participantservice.attempt_answer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttemptAnswerDto {
    private Long id;
    private Long quizId;
    private Long answerId;
}
