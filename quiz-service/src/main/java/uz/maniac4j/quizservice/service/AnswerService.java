package uz.maniac4j.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.maniac4j.quizservice.model.Answer;
import uz.maniac4j.quizservice.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer one(Long id){
        return answerRepository.getById(id);
    }

    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    public Answer add(Answer answer){
        if (answer.getQuiz() == null) return null;
        System.out.println(answer);
        Answer save = answerRepository.save(answer);
        System.out.println(save);
        return save;
    }

    public void delete(Long id){
         answerRepository.deleteById(id);
    }
    public Answer edit(Answer answer){
        if (answer.getId() == null) return null;
        Optional<Answer> update = answerRepository.findById(answer.getId());
        if (update.isPresent()){
            Answer answers = update.get();
            answer.edited(answer);
            return answerRepository.save(answers);
        }
        return null;
    }

}
