package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@Entity
public class Category extends EntityLong{
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private Long organization_id;

    public Category(Long id, Timestamp createdAt, boolean deleted, String name, String description, Long organization_id) {
        super(id, createdAt, deleted);
        this.name = name;
        this.description = description;
        this.organization_id = organization_id;
    }

    public Category(String name, String description, Long organization_id) {
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
