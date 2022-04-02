package uz.maniac4j.organizationservice.participant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantDto {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String fio;
    private boolean active=false;
    private Long organizationId;

}
