package uz.maniac4j.organizationservice.opb;

import lombok.*;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.template.EntityLong;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
// Organization participant block
public class OPB extends EntityLong {
    private Long blockId;
    private Long participantId;

    @ManyToOne
    private Organization organization;

    private boolean access;
}
