package uz.maniac4j.organizationservice.participant;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.organizationservice.config.ServiceNames;
import uz.maniac4j.organizationservice.payload.ApiResponseObject;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

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
        dto.setOrganizationId(user.getOrganization().getId());
        Response<?> response = template.postForObject(serviceNames.getParticipantService(), dto, Response.class);
        System.out.println(response);
        return response;
    }


}
