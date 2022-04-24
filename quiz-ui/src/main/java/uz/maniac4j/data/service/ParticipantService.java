package uz.maniac4j.data.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.maniac4j.data.entity.Participant;

@Service
public class ParticipantService {

    private final ParticipantRepository repository;

    @Autowired
    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public Optional<Participant> get(UUID id) {
        return repository.findById(id);
    }

    public Participant update(Participant entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Participant> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
