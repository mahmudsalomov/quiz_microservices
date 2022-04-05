package uz.maniac4j.participantservice.participant;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.maniac4j.participantservice.payload.Payload;
import uz.maniac4j.participantservice.payload.Response;
import uz.maniac4j.participantservice.utils.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Boolean activate(Long participantId){
        Optional<Participant> byId = participantRepository.findById(participantId);
        if (byId.isPresent()){
            byId.get().setActive(true);
//            Response<Participant> response = Payload.ok(participantRepository.save(byId.get()));
            participantRepository.save(byId.get());
            return true;
        }
        return false;
    }

    // Deactivate participant
    public Boolean deactivate(Long participantId){
        Optional<Participant> byId = participantRepository.findById(participantId);
        if (byId.isPresent()){
            byId.get().setActive(false);
            participantRepository.save(byId.get());
            return true;
        }
        return false;
    }

    // Get all participant by Organization id
    public ArrayList<ParticipantDto> getAllByOrganizationId(Long organizationId){
//        if (organizationId==null) return Payload.badRequest("Organization id is null!");
        List<Participant> participants = participantRepository.findAllByOrganizationIdOrderByIdDesc(organizationId);
        List<ParticipantDto> list = participants.stream().map(Converter::toParticipantDto).toList();
        ArrayList<ParticipantDto> collect = new ArrayList<>(list);
        Response<List<ParticipantDto>> response = Payload.ok(collect);
        System.out.println(response);
        return collect;
    }



    // Edit Participant
    public Response<?> edit(ParticipantDto dto){
        Optional<Participant> optionalParticipant = participantRepository.findById(dto.getId());
        if (optionalParticipant.isEmpty())  return Payload.badRequest(null);
        if (participantRepository.existsByUsername(dto.getUsername())) return Payload.badRequest("Username already exists!",null);
        Participant participant = optionalParticipant.get();
        participant.setUsername(dto.getUsername());
        participant.setEmail(dto.getEmail());
        participant.setFio(dto.getFio());
        if (dto.getPassword()!=null&&dto.getPassword().length()>0) participant.setPassword(passwordEncoder.encode(dto.getPassword()));
        participant=participantRepository.save(participant);
        return Payload.ok(Converter.toParticipantDto(participant));
    }



    // check participant id and organization id is exists
    public boolean existsByParticipantAndOrganization(long participant_id, long organization_id){
        Optional<Participant> optionalParticipant = participantRepository.findById(participant_id);
        if (optionalParticipant.isEmpty()) return false;
        return optionalParticipant.get().getOrganizationId()==organization_id;
    }



}
