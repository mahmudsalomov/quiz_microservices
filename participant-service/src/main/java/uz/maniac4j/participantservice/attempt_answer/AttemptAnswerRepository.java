package uz.maniac4j.participantservice.attempt_answer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import uz.maniac4j.participantservice.attempt.Attempt;

public interface AttemptAnswerRepository extends JpaRepository<AttemptAnswer,Long> {

}
