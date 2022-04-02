package uz.maniac4j.organizationservice.participant;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.organizationservice.config.ServiceNames;
import uz.maniac4j.organizationservice.payload.ApiResponseObject;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

import java.util.Optional;

@Service
public class ParticipantService {
    private final UserRepository userRepository;
    private final RestTemplate template;
    private final ServiceNames serviceNames;

    public ParticipantService(UserRepository userRepository, RestTemplate template, ServiceNames serviceNames) {
        this.userRepository = userRepository;
        this.template = template;
        this.serviceNames = serviceNames;
    }


    public Response<?> createNewParticipant(ParticipantDto dto,User user){

        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.badRequest();
        user=optionalUser.get();
        dto.setOrganizationId(user.getOrganization().getId());
        ParticipantDto participantDto = template.postForObject(serviceNames.getParticipant() + "/api/participant/create", dto, ParticipantDto.class);
        System.out.println(participantDto);
        return Payload.ok(participantDto);
    }


    public String test(){
        String object = template.getForObject(serviceNames.getParticipant() + "/api/participant/test", String.class);
        System.out.println(object);
        return object;
    }


}
