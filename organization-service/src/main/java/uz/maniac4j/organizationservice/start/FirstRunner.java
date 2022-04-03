package uz.maniac4j.organizationservice.start;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.maniac4j.organizationservice.user.*;

import java.util.Arrays;
import java.util.Collections;

@Component
@NoArgsConstructor
public class FirstRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByUsername("admin")&! roleRepository.existsByRoleName(RoleName.ADMIN)){

            Role roleAdmin = roleRepository.save(Role.builder().roleName(RoleName.ADMIN).build());

            User admin= User
                    .builder()
                    .active(true)
                    .fio("admin")
                    .roles(Collections.singleton(roleAdmin))
                    .email("admin@gmail.com")
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .build();
            userRepository.save(admin);
//            if (!roleRepository.existsByRoleName(RoleName.ORGANIZATION_ADMIN)){
//                Role roleOrganizationAdmin = roleRepository.save(Role.builder().roleName(RoleName.ORGANIZATION_ADMIN).build());
//            }
        }



        if (!userRepository.existsByUsername("user")&! roleRepository.existsByRoleName(RoleName.ORGANIZATION_ADMIN)){

            Role roleUser = roleRepository.save(Role.builder().roleName(RoleName.ORGANIZATION_ADMIN).build());

            User admin= User
                    .builder()
                    .active(true)
                    .fio("user")
                    .roles(Collections.singleton(roleUser))
                    .email("user@gmail.com")
                    .username("user")
                    .password(passwordEncoder.encode("user"))
                    .build();
            userRepository.save(admin);
//            if (!roleRepository.existsByRoleName(RoleName.ORGANIZATION_ADMIN)){
//                Role roleOrganizationAdmin = roleRepository.save(Role.builder().roleName(RoleName.ORGANIZATION_ADMIN).build());
//            }
        }
    }
}
