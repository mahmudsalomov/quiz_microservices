package uz.maniac4j.participantservice.participant;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

public class Role implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "PARTICIPANT";
    }
}
