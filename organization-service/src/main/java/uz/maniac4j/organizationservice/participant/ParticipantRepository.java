package uz.maniac4j.organizationservice.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    boolean existsByEmail(String email);
    Optional<Participant> findByEmail(String email);
}
