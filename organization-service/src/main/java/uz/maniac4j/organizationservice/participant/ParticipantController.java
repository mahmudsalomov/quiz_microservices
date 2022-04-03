package uz.maniac4j.organizationservice.participant;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.security.CurrentUser;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

@RequestMapping("api/organization/participant")
@RestController
public class ParticipantController {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final ParticipantService participantService;


    public ParticipantController(OrganizationRepository organizationRepository, UserRepository userRepository, ParticipantService participantService) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.participantService = participantService;
    }

    @PostMapping("/create")
    public HttpEntity<?> create(@RequestBody ParticipantDto dto, @CurrentUser User user){
        return participantService.createNewParticipant(dto, user).response();
    }

    @PostMapping("/edit")
    public HttpEntity<?> edit(@RequestBody ParticipantDto dto, @CurrentUser User user){
        return participantService.editParticipant(dto, user).response();
    }

    @GetMapping("/test")
    public String test(){
        return participantService.test();
    }

    @GetMapping("/all")
    public Response<?> all(@CurrentUser User user){
        return participantService.getAllByOrganization(user);
    }

}
