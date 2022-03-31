package uz.maniac4j.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.maniac4j.quizservice.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {


}
