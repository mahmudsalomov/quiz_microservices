package uz.maniac4j.participantservice.attempt;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttemptRepository extends JpaRepository<Attempt,Long> {
    Optional<Attempt> findByOpbId(long id);
}
