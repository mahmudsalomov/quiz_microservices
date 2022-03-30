package uz.maniac4j.participantservice.participant;

import lombok.*;

import javax.validation.constraints.NotNull;

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
