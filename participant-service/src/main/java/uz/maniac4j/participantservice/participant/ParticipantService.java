package uz.maniac4j.participantservice.participant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.maniac4j.participantservice.payload.Payload;
import uz.maniac4j.participantservice.payload.Response;
import uz.maniac4j.participantservice.utils.Converter;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final PasswordEncoder passwordEncoder;

    public ParticipantService(ParticipantRepository participantRepository, PasswordEncoder passwordEncoder) {
        this.participantRepository = participantRepository;
        this.passwordEncoder = passwordEncoder;
    }



    // Add new participant
    public ParticipantDto create(ParticipantDto dto){
        if (participantRepository.existsByUsername(dto.getUsername())) return null;
        Participant participant = Converter.toParticipant(dto);
        participant.setPassword(passwordEncoder.encode(dto.getPassword()));
        participant=participantRepository.save(participant);
        return Converter.toParticipantDto(participant);
    }


    // Activate participant
    public Response<?> activate(Long participantId){
        Optional<Participant> byId = participantRepository.findById(participantId);
        if (byId.isPresent()){
            byId.get().setActive(true);
            return Payload.ok(participantRepository.save(byId.get()));
        }
        return Payload.notFound();
    }

    // Deactivate participant
    public Response<?> deactivate(Long participantId){
        Optional<Participant> byId = participantRepository.findById(participantId);
        if (byId.isPresent()){
            byId.get().setActive(false);
            return Payload.ok(participantRepository.save(byId.get()));
        }
        return Payload.notFound();
    }

    // Get all participant by Organization id
    public Response<?> getAllByOrganizationId(Long organizationId){
        if (organizationId==null) return Payload.badRequest("Organization id is null!");
        List<Participant> participants = participantRepository.findAllByOrganizationIdOrderByIdDesc(organizationId);
        return Payload.ok(participants);
    }



}
