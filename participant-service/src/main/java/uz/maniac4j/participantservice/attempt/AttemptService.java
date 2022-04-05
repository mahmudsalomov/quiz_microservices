package uz.maniac4j.participantservice.attempt;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.participantservice.attempt_answer.AttemptAnswerRepository;
import uz.maniac4j.participantservice.config.ServiceNames;
import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.participant.ParticipantRepository;
import uz.maniac4j.participantservice.payload.Payload;
import uz.maniac4j.participantservice.payload.Response;
import uz.maniac4j.participantservice.security.CurrentUser;

import java.util.Optional;

@Service
public class AttemptService {
    private final AttemptRepository attemptRepository;
    private final ParticipantRepository participantRepository;
    private final AttemptAnswerRepository attemptAnswerRepository;
    private final ServiceNames serviceNames;
    private final RestTemplate template;

    public AttemptService(AttemptRepository attemptRepository, ParticipantRepository participantRepository, AttemptAnswerRepository attemptAnswerRepository, ServiceNames serviceNames, RestTemplate template) {
        this.attemptRepository = attemptRepository;
        this.participantRepository = participantRepository;
        this.attemptAnswerRepository = attemptAnswerRepository;
        this.serviceNames = serviceNames;
        this.template = template;
    }

//    public Response<?> start(long opb_id, @CurrentUser Participant participant){
//        Optional<Participant> optionalParticipant = participantRepository.findByUsername(participant.getUsername());
//        if (optionalParticipant.isEmpty()) return Payload.notFound();
//
//    }
}
