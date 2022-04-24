package uz.maniac4j.data.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.maniac4j.data.entity.Quiz;

@Service
public class QuizService {

    private final QuizRepository repository;

    @Autowired
    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public Optional<Quiz> get(UUID id) {
        return repository.findById(id);
    }

    public Quiz update(Quiz entity) {
        return repository.save(entity);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public Page<Quiz> list(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public int count() {
        return (int) repository.count();
    }

}
