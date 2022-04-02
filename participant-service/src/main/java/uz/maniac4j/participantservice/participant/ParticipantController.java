package uz.maniac4j.participantservice.participant;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/participant")
public class ParticipantController {

    private final ParticipantService participantService;


    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/create")
    public ParticipantDto create(@RequestBody ParticipantDto dto){
        System.out.println(dto);
        return participantService.create(dto);
    }

    @GetMapping("/test")
    public String create(){
        return "Ishladi";
    }
}
