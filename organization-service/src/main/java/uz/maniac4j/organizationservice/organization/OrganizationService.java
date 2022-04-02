package uz.maniac4j.organizationservice.organization;

import org.springframework.stereotype.Service;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.user.User;
import uz.maniac4j.organizationservice.user.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;


    public OrganizationService(OrganizationRepository organizationRepository, UserRepository userRepository) {
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
    }

    public Response<?> getByOwnerUser(User user){
        Optional<Organization> optionalOrganization = organizationRepository.findByOwnerId(user.getId());
        return optionalOrganization.map(Payload::ok).orElseGet(Payload::notFound);
    }

    // Create Organization
    public Response<?> create(Organization organization, User user){
        try {
            System.out.println("ORGANIZATION");
            organization.setOwnerId(user.getId());
            System.out.println(organization);
            System.out.println(user);
            organization = organizationRepository.save(organization);
            return Payload.ok("Organization created!",organization);
        }catch (Exception e){
            e.printStackTrace();
            return Payload.conflict();
        }
    }

}
