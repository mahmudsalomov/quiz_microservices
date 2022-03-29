package uz.maniac4j.organizationservice.user;

import org.springframework.stereotype.Service;
import uz.maniac4j.organizationservice.email.EmailService;
import uz.maniac4j.organizationservice.payload.Payload;
import uz.maniac4j.organizationservice.payload.Response;
import uz.maniac4j.organizationservice.utils.CodeGenerator;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final EmailService emailService;


    public UserService(RoleRepository roleRepository, UserRepository userRepository, EmailService emailService) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public Response register(User user){
        try {
            user.setCode(CodeGenerator.generate());
            user.setActive(false);

            Optional<Role> optionalRole = roleRepository.findByRoleName(RoleName.ORGANIZATION_ADMIN);

            if (optionalRole.isPresent()){
                user.setRoles(Collections.singleton(optionalRole.get()));
            }else {
                Role roleOrganizationAdmin = roleRepository.save(Role.builder().roleName(RoleName.ORGANIZATION_ADMIN).build());
                user.setRoles(Collections.singleton(roleOrganizationAdmin));
            }
            user=userRepository.save(user);
            boolean b = emailService.sendCode(user);

            return b?Payload.ok("Confirmation code has been sent to your email",user):Payload.conflict();
        }catch (Exception e){
            e.printStackTrace();
            return Payload.conflict();
        }
    }

    public Response activate(String email,String code){
        try {
            Optional<User> optionalUser = userRepository.findByUsername(email);
            if (optionalUser.isPresent()){
                if (code.equals(optionalUser.get().getCode())){
                    optionalUser.get().setActive(true);
                    User save = userRepository.save(optionalUser.get());
                    return Payload.ok("Successfully confirmed!",save);
                }
                return Payload.badRequest("Wrong code!");
            }return Payload.notFound("User not found!");
        }catch (Exception e){
            e.printStackTrace();
            return Payload.conflict();
        }
    }


}
