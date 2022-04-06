package uz.maniac4j.participantservice.quiz.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AnswerDtoImpl extends AnswerDto{

    @Builder
    public AnswerDtoImpl(Long id, String text, boolean right) {
        super(id, text);
        this.right = right;
    }

    public AnswerDtoImpl(boolean right) {
        this.right = right;
    }

    private boolean right;
}
