package uz.maniac4j.organizationservice.template;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

// Short entity template
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@MappedSuperclass
public abstract class EntityShort implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @OrderBy
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EntityShort that = (EntityShort) o;
        return Objects.equals(id, that.id);
    }

    private boolean deleted=false;

    @Override
    public int hashCode() {
        return 0;
    }
}
