package uz.maniac4j.organizationservice.user;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.maniac4j.organizationservice.email.EmailService;
import uz.maniac4j.organizationservice.organization.Organization;
import uz.maniac4j.organizationservice.organization.OrganizationRepository;
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
    private final PasswordEncoder passwordEncoder;

    private final OrganizationRepository organizationRepository;


    public UserService(RoleRepository roleRepository, UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder, OrganizationRepository organizationRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.organizationRepository = organizationRepository;
    }

    public Response<?> register(RegistrationDto dto){
        User user = User
                .builder()
                .email(dto.getEmail())
                .fio(dto.getFio())
                .username(dto.getUsername())
                .password(dto.getUsername())
                .build();
        try {
            user.setCode(CodeGenerator.generate());
            user.setActive(true);

            user.setPassword(passwordEncoder.encode(user.getPassword()));

            Optional<Role> optionalRole = roleRepository.findByRoleName(RoleName.ORGANIZATION_ADMIN);

            if (optionalRole.isPresent()){
                user.setRoles(Collections.singleton(optionalRole.get()));
            }else {
                Role roleOrganizationAdmin = roleRepository.save(Role.builder().roleName(RoleName.ORGANIZATION_ADMIN).build());
                user.setRoles(Collections.singleton(roleOrganizationAdmin));
            }
            System.out.println(user);
            user=userRepository.save(user);
            boolean b = emailService.sendCode(user);

            Organization organization = Organization
                    .builder()
                    .name(dto.getOrganizationName())
                    .ownerId(user.getId())
                    .build();
            organization=organizationRepository.save(organization);

            return b?Payload.ok("Confirmation code has been sent to your email",user):Payload.conflict();
        }catch (Exception e){
            e.printStackTrace();
            return Payload.conflict();
        }
    }

    public Response<?> activate(String email,String code){
        try {
            Optional<User> optionalUser = userRepository.findByEmail(email);
            if (optionalUser.isPresent()){
                if (optionalUser.get().isActive()) return Payload.badRequest("Already confirmed!");
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


    public Response<?> edit(UserDto dto,User user){
        if (userRepository.existsByUsername(dto.getUsername())) return Payload.badRequest("This username already exists!");
        user.setUsername(dto.getUsername());
        user.setFio(dto.getFio());
        user.setPhone(dto.getPhone());
        user=userRepository.save(user);
        return Payload.ok(user);
    }


    public Response<?> changePassword(ChangePasswordDto dto,User user){
        if (!passwordEncoder.matches(dto.getOldPassword(), user.getPassword())) return Payload.badRequest("Wrong password!");
        if (!dto.getNewPassword().equals(dto.getRetypedNewPassword())) return Payload.badRequest("Don't match retyped password!");
        user.setPassword(passwordEncoder.encode(dto.getNewPassword()));
        user=userRepository.save(user);
        return Payload.ok("Successfully changed!",user);
    }


}
