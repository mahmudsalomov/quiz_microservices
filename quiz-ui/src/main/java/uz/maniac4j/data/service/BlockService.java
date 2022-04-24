package uz.maniac4j.data.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.maniac4j.data.entity.Block;

@Service
public class BlockService {

    private final BlockRepository repository;

    @Autowired
    public BlockService(BlockRepository repository) {
        this.repository = repository;
    }

    public Optional<Block> get(UUID id) {
        return repository.findById(id);
    }

    public Block update(Block entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Block> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
