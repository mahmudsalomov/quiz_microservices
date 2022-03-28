package uz.maniac4j.quizservice.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Quiz extends EntityLong{

    private String title;
    @Column(columnDefinition = "text")
    private String text;
    private Long right_answer_id;
    private int rate;

    @ManyToOne
    private Category category;

    @ManyToMany
    @ToString.Exclude
    private Set<Block> blocks;





}
