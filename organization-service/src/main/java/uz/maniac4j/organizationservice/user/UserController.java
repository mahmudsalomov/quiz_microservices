package uz.maniac4j.organizationservice.user;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public HttpEntity<?> register(@RequestBody User user){
        return userService.register(user).response();
    }


    @PostMapping("/activate")
    public HttpEntity<?> activate(@RequestParam String email,@RequestParam String code){
        return userService.activate(email,code).response();
    }

}
