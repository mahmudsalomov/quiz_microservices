package uz.maniac4j.quizservice.controller;

import org.springframework.web.bind.annotation.*;
import uz.maniac4j.quizservice.model.Quiz;
import uz.maniac4j.quizservice.service.QuizService;

import java.util.List;

@RestController
@RequestMapping("api/quiz")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Quiz> findAll(){
        return service.all();
    }

    @GetMapping("/one{id}")
    public Quiz one(@PathVariable("id") Long id){
        return service.one(id);
    }

    @PostMapping("/add")
    public Quiz addQuiz(@RequestBody Quiz quiz){
        return service.add(quiz);
    }

    @PostMapping("/delete{id}")
    public void deleteQuiz(@PathVariable("id") Long id){
         service.delete(id);
    }

    @PutMapping("/edit")
    public Quiz editQuiz(@RequestBody Quiz quiz){
        return service.edit(quiz);
    }
}
