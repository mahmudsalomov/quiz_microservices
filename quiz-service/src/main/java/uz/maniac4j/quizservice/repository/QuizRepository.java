package uz.maniac4j.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.maniac4j.quizservice.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
