package uz.maniac4j.data.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.maniac4j.data.entity.ParticipantBlock;

@Service
public class ParticipantBlockService {

    private final ParticipantBlockRepository repository;

    @Autowired
    public ParticipantBlockService(ParticipantBlockRepository repository) {
        this.repository = repository;
    }

    public Optional<ParticipantBlock> get(UUID id) {
        return repository.findById(id);
    }

    public ParticipantBlock update(ParticipantBlock entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<ParticipantBlock> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
