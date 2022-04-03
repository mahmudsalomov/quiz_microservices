package uz.maniac4j.participantservice.participant;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.participantservice.payload.Response;

import java.util.ArrayList;

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


    @PostMapping("/edit")
    public Response<?> edit(@RequestBody ParticipantDto dto){
        System.out.println(dto);
        return participantService.edit(dto);
    }

    @GetMapping("/test")
    public String create(){
        return "Ishladi";
    }

    @GetMapping("/all/{id}")
    public ArrayList<ParticipantDto> get(@PathVariable Long id){
        return participantService.getAllByOrganizationId(id);
    }

    @GetMapping("/activate/{id}")
    public Boolean activate(@PathVariable Long id){
        return participantService.activate(id);
    }

    @GetMapping("/deactivate/{id}")
    public Boolean deactivate(@PathVariable Long id){
        return participantService.deactivate(id);
    }
}
