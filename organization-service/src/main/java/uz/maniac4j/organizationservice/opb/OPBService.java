package uz.maniac4j.organizationservice.opb;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.organizationservice.config.ServiceNames;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

import java.util.Optional;

@Service
public class OPBService {
    private final OPBRepository opbRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final RestTemplate template;
    private final ServiceNames serviceNames;

    public OPBService(OPBRepository opbRepository, UserRepository userRepository, OrganizationRepository organizationRepository, RestTemplate template, ServiceNames serviceNames) {
        this.opbRepository = opbRepository;
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
        this.template = template;
        this.serviceNames = serviceNames;
    }




    // Create OPB
    public Response<?> createOPB(OPBDto dto, User user){
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.notFound("User not found!");
        user=optionalUser.get();
        boolean check1 = Boolean.TRUE.equals(template.getForObject(serviceNames.getQuiz() + "/api/block/existsByBlockAndOrganization/" + dto.getBlockId() + "/" + user.getOrganization().getId(), Boolean.class));
        boolean check2 = Boolean.TRUE.equals(template.getForObject(serviceNames.getParticipant() + "/api/participant/existsByParticipantAndOrganization/" + dto.getParticipantId() + "/" + user.getOrganization().getId(), Boolean.class));
        if (!(check1&&check2)) return Payload.badRequest();
        OPB opb = OPB.builder().access(dto.isAccess()).organization(user.getOrganization()).blockId(dto.getBlockId()).participantId(dto.getParticipantId()).build();
        opb=opbRepository.save(opb);
        return Payload.ok(opb);
    }


    // Change access OPB
    public Response<?> access(long opb_id,User user){
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isEmpty()) return Payload.notFound("User not found!");
        user=optionalUser.get();
        Optional<OPB> optionalOPB = opbRepository.findById(opb_id);
        if (optionalOPB.isEmpty()) return Payload.notFound();
        if (!optionalOPB.get().getOrganization().equals(user.getOrganization())) return Payload.badRequest();
        optionalOPB.get().setAccess(!optionalOPB.get().isAccess());
        OPB opb = opbRepository.save(optionalOPB.get());
        System.out.println(opb);
        return Payload.ok(opb);
    }

}
