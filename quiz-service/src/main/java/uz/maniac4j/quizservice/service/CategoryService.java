package uz.maniac4j.quizservice.service;

import org.springframework.stereotype.Service;
import uz.maniac4j.quizservice.model.Category;
import uz.maniac4j.quizservice.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category one(Long id){
        if (id == null) return null;
        return categoryRepository.getById(id);
    }

    public List<Category> all(){
        return categoryRepository.findAll();
    }

    public Category add(Category category){
        if (category.getName()==null) return null;
        return categoryRepository.save(category);
    }

    public Category edit(Category category){
        if (category.getName() == null) return null;
        Optional<Category> update = categoryRepository.findById(category.getId());
        if (update.isPresent()){
            Category categorys = update.get();
            category.editer(category);
            return categoryRepository.save(category);
        }
        return null;
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }

}
