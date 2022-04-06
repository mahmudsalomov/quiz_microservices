package uz.maniac4j.participantservice.organization.opb;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
