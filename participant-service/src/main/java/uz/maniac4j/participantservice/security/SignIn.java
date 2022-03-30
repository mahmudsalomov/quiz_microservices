package uz.maniac4j.participantservice.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignIn {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "{" +
                "\"username\":\"" + username + '\"' +
                ",\"password\":\"" + password + '\"' +
                '}';
    }
}
