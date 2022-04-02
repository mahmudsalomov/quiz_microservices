package uz.maniac4j.participantservice.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    boolean existsByUsername(String username);
    Optional<Participant> findByUsername(String username);
    List<Participant> findAllByOrganizationIdOrderByIdDesc(Long id);
}
