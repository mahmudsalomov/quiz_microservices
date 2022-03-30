package uz.maniac4j.participantservice.attempt;

import org.springframework.stereotype.Service;

@Service
public class AttemptService {
    private final AttemptRepository attemptRepository;

    public AttemptService(AttemptRepository attemptRepository) {
        this.attemptRepository = attemptRepository;
    }
}
