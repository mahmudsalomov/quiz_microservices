package uz.maniac4j.participantservice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.participantservice.participant.Participant;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody SignIn signIn){
        ResToken resToken=authService.signIn(signIn);
        return ResponseEntity.status(resToken!=null?200:401).body(resToken);
    }



    @GetMapping("/me")
    public HttpEntity<?> me(@CurrentUser Participant participant){
        System.out.println(participant);
        if (participant!=null){
            return ResponseEntity.ok(participant.getFio());
        }else return null;
//        return ResponseEntity.ok(true);
    }

}
