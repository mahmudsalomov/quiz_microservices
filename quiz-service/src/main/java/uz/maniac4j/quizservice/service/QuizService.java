package uz.maniac4j.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.maniac4j.quizservice.model.Quiz;
import uz.maniac4j.quizservice.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz one(Long id){
        return quizRepository.getById(id);
    }

    public List<Quiz> all(){
        return quizRepository.findAll();
    }

    public Quiz add(Quiz quiz){
        if (quiz.getId() == null) return null;
        return quizRepository.save(quiz);
    }

    public void delete(Long id){
        if (id == null) return;
        quizRepository.deleteById(id);
    }

    public Quiz edit(Quiz quiz){
        if (quiz.getId() == null) return null;
        Optional<Quiz> update = quizRepository.findById(quiz.getId());
        if (update.isPresent()){
            Quiz quizies = update.get();
            quizies.editing(quizies);
            return quizRepository.save(quizies);
        }
        return null;
    }
}
