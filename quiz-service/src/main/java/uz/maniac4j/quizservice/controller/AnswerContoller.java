package uz.maniac4j.quizservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.maniac4j.quizservice.model.Answer;
import uz.maniac4j.quizservice.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerContoller{

    private final AnswerService service;

    public AnswerContoller(AnswerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Answer> findAll() {
        return service.findAll();
    }

    @GetMapping( "/one/{id}")
    public Answer one(@PathVariable("id") Long id) {
        return service.one(id);
    }

    @PostMapping("/add")
    public Answer addAnswer(@RequestBody Answer answer) {
        System.out.println(answer);
        return service.add(answer);
    }

    @PostMapping("/delete/{id}")
    public void deleteAnswer(@PathVariable("id") Long id){
         service.delete(id);
    }

    @PutMapping("/edit")
    public Answer edit(@RequestBody Answer answer){
        return service.edit(answer);
    }
}
