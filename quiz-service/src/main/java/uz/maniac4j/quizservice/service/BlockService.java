package uz.maniac4j.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.maniac4j.quizservice.dto.BlockDto;
import uz.maniac4j.quizservice.dto.QuizDto;
import uz.maniac4j.quizservice.model.Block;
import uz.maniac4j.quizservice.model.BlockType;
import uz.maniac4j.quizservice.model.Quiz;
import uz.maniac4j.quizservice.repository.AnswerRepository;
import uz.maniac4j.quizservice.repository.BlocksRepository;
import uz.maniac4j.quizservice.repository.CategoryRepository;
import uz.maniac4j.quizservice.repository.QuizRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BlockService {

    private final BlocksRepository blocksRepository;
    private final QuizRepository quizRepository;
    private final CategoryRepository categoryRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public BlockService(BlocksRepository blocksRepository, QuizRepository quizRepository, CategoryRepository categoryRepository, AnswerRepository answerRepository) {
        this.blocksRepository = blocksRepository;
        this.quizRepository = quizRepository;
        this.categoryRepository = categoryRepository;
        this.answerRepository = answerRepository;
    }


    public List<Block> all(){
        return blocksRepository.findAll();
    }

    public Block one(Long id){
        return blocksRepository.getById(id);
    }


    public Block add(Block block){
        if (block.getId()== null) return null;
        return blocksRepository.save(block);
    }


    public Block add(BlockDto dto){
        Set<Quiz> quizzes=new HashSet<>();
        for (QuizDto quizDto:dto.getQuizList()) {
            Optional<Quiz> quiz = quizRepository.findById(quizDto.getId());
            if (quiz.isEmpty()) return null;
            quizzes.add(quiz.get());
        }
        Block block = Block
                .builder()
                .description(dto.getDescription())
                .name(dto.getName())
                .type(BlockType.CUSTOM)
                .quizzes(quizzes)
                .active(dto.isActive())
                .limit(dto.getLimit())
                .build();
        return blocksRepository.save(block);
    }





    public void delete(Long id){
        if (id != null) blocksRepository.deleteById(id);
    }

    public Block edit(Block block){
        if (block.getId() == null) return null;
            Optional<Block> update = blocksRepository.findById(block.getId());
        if (update.isPresent()){
            Block blocks = update.get();
            blocks.edit(block);
            return blocksRepository.save(block);
        }
        return null;
    }

}
