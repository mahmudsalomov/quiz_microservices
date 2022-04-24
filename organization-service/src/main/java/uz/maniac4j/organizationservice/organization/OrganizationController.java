package uz.maniac4j.organizationservice.organization;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.organizationservice.security.CurrentUser;
import uz.maniac4j.organizationservice.user.User;

@RequestMapping("api/organization")
@RestController
public class OrganizationController {

    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping("/create")
    public HttpEntity<?> create(@RequestBody Organization organization, @CurrentUser User user){
        return organizationService.create(organization,user).response();
    }

    @GetMapping("/test")
    public String test(){
        return "Salom";
    }
}
