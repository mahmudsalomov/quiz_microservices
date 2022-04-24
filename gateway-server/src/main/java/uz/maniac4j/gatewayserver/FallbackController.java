package uz.maniac4j.gatewayserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {
    @GetMapping("/organizationFallback")
    public Mono<String> organizationFallBack(){
        return Mono.just("Please, try again later! Organization service is down");
    }

    @GetMapping("/quizFallback")
    public Mono<String> quizFallBack(){
        return Mono.just("Please, try again later! Quiz service is down");
    }

    @GetMapping("/participantFallback")
    public Mono<String> participantFallBack(){
        return Mono.just("Please, try again later! Participant service is down");
    }
}
