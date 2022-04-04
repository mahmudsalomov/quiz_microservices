package uz.maniac4j.organizationservice.quiz.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Quiz extends EntityLong{

    private String title;
    private String text;
    private Long right_answer_id;
    private int rate;
    private Category category;

    private Set<Block> blocks;

    @Builder
    public Quiz(Long id, Timestamp createdAt, boolean deleted, String title, String text, Long right_answer_id, int rate, Category category, Set<Block> blocks) {
        super(id, createdAt, deleted);
        this.title = title;
        this.text = text;
        this.right_answer_id = right_answer_id;
        this.rate = rate;
        this.category = category;
        this.blocks = blocks;
    }


    public void editing(Quiz quiz){
        title = quiz.title;
        text = quiz.text;
        right_answer_id = quiz.right_answer_id;
        rate = quiz.rate;
        category = quiz.category;
        blocks = quiz.blocks;

    }
}
