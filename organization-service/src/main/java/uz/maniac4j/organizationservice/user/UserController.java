package uz.maniac4j.organizationservice.user;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.organizationservice.security.CurrentUser;

@RestController
@RequestMapping("api/organization/user")
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

    @PostMapping("/edit")
    public HttpEntity<?> edit(@RequestBody UserDto dto, @CurrentUser User user){
        return userService.edit(dto,user).response();
    }

    @PostMapping("/changePassword")
    public HttpEntity<?> changePassword(@RequestBody ChangePasswordDto dto, @CurrentUser User user){
        return userService.changePassword(dto,user).response();
    }

}
