package uz.maniac4j.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.maniac4j.quizservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
