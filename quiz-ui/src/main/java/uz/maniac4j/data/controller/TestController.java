package uz.maniac4j.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uz.maniac4j.utils.AppConstants;

@RestController
@RequestMapping("api/test")
public class TestController {
    @Autowired
    private RestTemplate template;

    @Autowired
    private AppConstants constants;

    @GetMapping("/hello")
    public String hello(){

        ResponseEntity<String> object= template.exchange(constants.BASE_URL_ORGANIZATION() + "/test", HttpMethod.GET,constants.getHeader(), String.class);
        return object.getBody();
    }
}
