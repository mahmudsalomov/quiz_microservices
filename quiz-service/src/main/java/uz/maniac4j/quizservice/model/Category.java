package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
public class Category extends EntityLong{
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @NotNull
    @Column(unique = true)
    private Long organization_id;


    @Builder
    public Category(Long id, Timestamp createdAt, boolean deleted, String name, String description, Long organization_id) {
        super(id, createdAt, deleted);
        this.name = name;
        this.description = description;
        this.organization_id = organization_id;
    }


    public void editer(Category category){
        name = category.name;
        description = category.description;
        organization_id = category.organization_id;
    }
}
