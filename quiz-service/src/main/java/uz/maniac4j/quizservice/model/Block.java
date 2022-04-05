package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Block extends EntityLong{
    private String name;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToMany
    @ToString.Exclude
    private Set<Quiz> quizzes;

    @Enumerated(EnumType.STRING)
    private BlockType type;

    private boolean active=false;


    // Seconds
    private long limit;

    private Long organization_id;


    @Builder
    public Block(Long id, Timestamp createdAt, boolean deleted, String name, String description, Set<Quiz> quizzes, BlockType type, boolean active, long limit, Long organization_id) {
        super(id, createdAt, deleted);
        this.name = name;
        this.description = description;
        this.quizzes = quizzes;
        this.type = type;
        this.active = active;
        this.limit = limit;
        this.organization_id = organization_id;
    }

    public Block(String name, String description, Set<Quiz> quizzes, BlockType type, boolean active, long limit, Long organization_id) {
        this.name = name;
        this.description = description;
        this.quizzes = quizzes;
        this.type = type;
        this.active = active;
        this.limit = limit;
        this.organization_id = organization_id;
    }

    public void edit(Block block){
        name = block.name;
        description = block.description;
        quizzes = block.quizzes;
    }
}
