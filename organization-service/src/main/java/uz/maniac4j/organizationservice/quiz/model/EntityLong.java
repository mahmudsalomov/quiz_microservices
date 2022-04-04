package uz.maniac4j.organizationservice.quiz.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
@AllArgsConstructor
public abstract class EntityLong implements Serializable {
    private Long id;
    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EntityLong that = (EntityLong) o;
        return Objects.equals(id, that.id);
    }

    private boolean deleted=false;

    @Override
    public int hashCode() {
        return 0;
    }
}
