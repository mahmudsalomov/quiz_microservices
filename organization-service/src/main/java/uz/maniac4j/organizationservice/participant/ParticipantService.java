package uz.maniac4j.organizationservice.participant;

import org.springframework.stereotype.Service;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.user.User;

import java.util.Collections;
import java.util.Optional;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public Response addParticipant(Organization organization, Participant participant, User user){

        if (organization.getMembers().contains(user)){
            Optional<Participant> optionalParticipant = participantRepository.findByEmail(participant.getEmail());
            if (optionalParticipant.isPresent()){
                optionalParticipant.get().getOrganizations().add(organization);
                participant=participantRepository.save(optionalParticipant.get());
            }else {
                participant.setOrganizations(Collections.singleton(organization));
                newParticipant(participant);
                participant=participantRepository.save(participant);
            }
            return Payload.ok("Successfully created!",participant);
        }
        return Payload.badRequest();

    }

    public void newParticipant(Participant participant){

    }


}
