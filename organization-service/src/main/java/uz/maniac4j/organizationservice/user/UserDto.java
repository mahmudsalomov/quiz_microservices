package uz.maniac4j.organizationservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String phone;
    @NotNull
    @NotBlank
    private String fio;
}
