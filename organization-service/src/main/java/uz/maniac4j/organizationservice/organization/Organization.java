package uz.maniac4j.organizationservice.organization;


import lombok.*;
import uz.maniac4j.organizationservice.template.EntityLong;
import uz.maniac4j.organizationservice.user.User;

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
public class Organization extends EntityLong {
    private String name;
    private String description;
    private Long ownerId;
}
