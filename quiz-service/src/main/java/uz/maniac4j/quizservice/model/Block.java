package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@Entity
public class Block extends EntityLong{
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private Long organization_id;

    @ManyToMany
    @ToString.Exclude
    private Set<Quiz> quizzes;

    public Block(Long id, Timestamp createdAt, boolean deleted, String name, String description, Long organization_id, Set<Quiz> quizzes) {
        super(id, createdAt, deleted);
        this.name = name;
        this.description = description;
        this.organization_id = organization_id;
        this.quizzes = quizzes;
    }

    public Block(String name, String description, Long organization_id, Set<Quiz> quizzes) {
        this.name = name;
        this.description = description;
        this.organization_id = organization_id;
        this.quizzes = quizzes;
    }

    public void edit(Block block){
        name = block.name;
        description = block.description;
        organization_id = block.organization_id;
        quizzes = block.quizzes;
    }
}
