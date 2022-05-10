package uz.maniac4j.quizservice.controller;

import org.springframework.web.bind.annotation.*;
import uz.maniac4j.quizservice.model.Category;
import uz.maniac4j.quizservice.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("api/quiz/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/one/{id}")
    public Category one(@PathVariable("id") Long id){
        return service.one(id);
    }

    @GetMapping("/all")
    public List<Category> getAll(){
        return service.all();
    }

    @PostMapping("/add")
    public Category addCat(@RequestBody Category category){
        return service.add(category);
    }

    @PutMapping("/edit")
    public Category editCat(@RequestBody Category category){
        return service.edit(category);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
