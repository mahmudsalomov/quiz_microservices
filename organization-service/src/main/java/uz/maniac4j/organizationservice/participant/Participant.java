package uz.maniac4j.organizationservice.participant;

import lombok.*;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.template.EntityLong;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Participant extends EntityLong {

    @NotNull
    private String fullName;
    @NotNull
    private String email;
    private boolean active=false;

    @ManyToMany
    @ToString.Exclude
    private Set<Organization> organizations;
}
