package uz.maniac4j.organizationservice.quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.maniac4j.quizservice.model.BlockType;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockDto {
    private String name;
    private String description;
    private List<QuizDto> quizList=new ArrayList<>();
    private BlockType type;
    private boolean active;
    private long limit;
}
