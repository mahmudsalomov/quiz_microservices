package uz.maniac4j.participantservice.security;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.participant.ParticipantRepository;


@Service
@NoArgsConstructor
public class AuthService implements UserDetailsService {

    ParticipantRepository participantRepository;
    JwtTokenProvider jwtTokenProvider;
    AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(ParticipantRepository participantRepository, JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.participantRepository = participantRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return participantRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }

    public Participant loadByUserId(Long userId) {
        return participantRepository.findById(userId).orElseThrow(() -> new IllegalStateException("user not found"));

    }

    public ResToken signIn(SignIn signIn) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(signIn.getUsername(), signIn.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Participant principal = (Participant) authentication.getPrincipal();
            String jwt = jwtTokenProvider.generateToken(principal);
            return new ResToken(jwt);
        } catch (Exception e) {
            return null;
        }
    }

}
