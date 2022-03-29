package uz.maniac4j.organizationservice.email;

import org.springframework.stereotype.Service;
import uz.maniac4j.organizationservice.user.User;

@Service
public class EmailService {



    public boolean sendCode(User user){
        try {
            System.out.println(user.getCode());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


}
