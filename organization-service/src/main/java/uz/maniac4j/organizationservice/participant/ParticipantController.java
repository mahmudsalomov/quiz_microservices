package uz.maniac4j.organizationservice.participant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
import uz.maniac4j.organizationservice.user.UserRepository;

@RequestMapping("api/organization/participant")
@RestController
public class ParticipantController {

    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;


    public ParticipantController(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }


}
