package uz.maniac4j.participantservice.attempt;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.participantservice.attempt_answer.AttemptAnswer;
import uz.maniac4j.participantservice.attempt_answer.AttemptAnswerRepository;
import uz.maniac4j.participantservice.config.ServiceNames;
import uz.maniac4j.participantservice.organization.opb.OPBDto;
import uz.maniac4j.participantservice.participant.Participant;
import uz.maniac4j.participantservice.participant.ParticipantRepository;
import uz.maniac4j.participantservice.payload.ApiResponseObject;
import uz.maniac4j.participantservice.payload.Payload;
import uz.maniac4j.participantservice.payload.Response;
import uz.maniac4j.participantservice.quiz.dto.BlockDto;
import uz.maniac4j.participantservice.quiz.dto.QuizDto;
import uz.maniac4j.participantservice.security.CurrentUser;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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


    // Start quiz attempt by Participant.
    public Response<?> start(long opbId, @CurrentUser Participant participant){
        Optional<Participant> optionalParticipant = participantRepository.findByUsername(participant.getUsername());
        if (optionalParticipant.isEmpty()) return Payload.notFound();
        participant=optionalParticipant.get();

        // Check participation permission using the Organization service
        ApiResponseObject<OPBDto> response = template.postForObject(serviceNames.getOrganization() + "/api/opb/check", OPBDto.builder().participantId(participant.getId()).id(opbId), ApiResponseObject.class);
        if (response==null||response.getObject()==null) return Payload.notFound();
        if (!response.isSuccess()) return response;

        // Get quizzes
        BlockDto dto = template.getForObject(serviceNames.getQuiz() + "/api/block/one", BlockDto.class);
        if (dto==null) return Payload.badRequest();

        List<QuizDto> list = dto.getQuizList();

        Set<AttemptAnswer> answers=new HashSet<>();


        Attempt attempt = Attempt
                .builder()
                .participant(participant)
                .opbId(opbId)
                .build();
        attempt=attemptRepository.save(attempt);

        for (QuizDto quiz:list){
            AttemptAnswer answer = AttemptAnswer
                    .builder()
                    .quizId(quiz.getId())
                    .attempt(attempt)
                    .build();
            attemptAnswerRepository.save(answer);
        }

        attempt.setStartDate(new Timestamp(System.currentTimeMillis()));
        attemptRepository.save(attempt);
        return Payload.ok("Started",dto);


    }



    public Response<?> stop(long opb_id, @CurrentUser Participant participant){
        Optional<Participant> optionalParticipant = participantRepository.findByUsername(participant.getUsername());
        if (optionalParticipant.isEmpty()) return Payload.notFound();




    }



    public boolean isEnd(long opbId){
        Optional<Attempt> optionalAttempt = attemptRepository.findByOpbId(opbId);
        if (optionalAttempt.isPresent()){
            optionalAttempt.
        }
    }
}
