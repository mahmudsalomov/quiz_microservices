package uz.maniac4j.organizationservice.opb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.maniac4j.organizationservice.organization.Organization;

import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OPBDto {
    private Long id;
    private Long blockId;
    private Long participantId;
    private boolean access;
}
