package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Category extends EntityLong{
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    private Long organization_id;
}
