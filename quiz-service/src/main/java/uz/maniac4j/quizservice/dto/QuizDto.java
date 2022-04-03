package uz.maniac4j.quizservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    private String title;
    private String text;
    private int rate;
    private List<AnswerDtoImpl> answers=new ArrayList<>();
    private CategoryDto category;
}
