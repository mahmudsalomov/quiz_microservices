package uz.maniac4j.quizservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.maniac4j.quizservice.model.Block;

public interface BlocksRepository extends JpaRepository<Block, Long> {
}
