package uz.maniac4j.organizationservice.user;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegistrationDto {
    private String fio;
    private String email;
    private String organizationName;
    private String username;
    private String password;
}
