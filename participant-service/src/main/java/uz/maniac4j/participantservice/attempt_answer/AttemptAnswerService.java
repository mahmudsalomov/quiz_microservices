package uz.maniac4j.participantservice.attempt_answer;

import org.springframework.stereotype.Service;

@Service
public class AttemptAnswerService {
    private final AttemptAnswerRepository attemptAnswerRepository;

    public AttemptAnswerService(AttemptAnswerRepository attemptAnswerRepository) {
        this.attemptAnswerRepository = attemptAnswerRepository;
    }



}
