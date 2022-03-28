package uz.maniac4j.quizservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
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
}
