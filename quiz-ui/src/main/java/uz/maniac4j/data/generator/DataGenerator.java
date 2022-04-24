package uz.maniac4j.data.generator;

import com.vaadin.exampledata.DataType;
import com.vaadin.exampledata.ExampleDataGenerator;
import com.vaadin.flow.spring.annotation.SpringComponent;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import uz.maniac4j.data.entity.Block;
import uz.maniac4j.data.entity.Category;
import uz.maniac4j.data.entity.Participant;
import uz.maniac4j.data.entity.ParticipantBlock;
import uz.maniac4j.data.entity.Quiz;
import uz.maniac4j.data.service.BlockRepository;
import uz.maniac4j.data.service.CategoryRepository;
import uz.maniac4j.data.service.ParticipantBlockRepository;
import uz.maniac4j.data.service.ParticipantRepository;
import uz.maniac4j.data.service.QuizRepository;

@SpringComponent
public class DataGenerator {

    @Bean
    public CommandLineRunner loadData(CategoryRepository categoryRepository, QuizRepository quizRepository,
            BlockRepository blockRepository, ParticipantRepository participantRepository,
            ParticipantBlockRepository participantBlockRepository) {
        return args -> {
            Logger logger = LoggerFactory.getLogger(getClass());
            if (categoryRepository.count() != 0L) {
                logger.info("Using existing database");
                return;
            }
            int seed = 123;

            logger.info("Generating demo data");

            logger.info("... generating 100 Category entities...");
            ExampleDataGenerator<Category> categoryRepositoryGenerator = new ExampleDataGenerator<>(Category.class,
                    LocalDateTime.of(2022, 4, 23, 0, 0, 0));
            categoryRepositoryGenerator.setData(Category::setName, DataType.WORD);
            categoryRepositoryGenerator.setData(Category::setDescription, DataType.WORD);
            categoryRepositoryGenerator.setData(Category::setOrganization, DataType.WORD);
            categoryRepository.saveAll(categoryRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Quiz entities...");
            ExampleDataGenerator<Quiz> quizRepositoryGenerator = new ExampleDataGenerator<>(Quiz.class,
                    LocalDateTime.of(2022, 4, 23, 0, 0, 0));
            quizRepositoryGenerator.setData(Quiz::setText, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setAnswerFirst, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setAnswerSecond, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setAnswerThird, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setAnswerFourth, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setRate, DataType.NUMBER_UP_TO_100);
            quizRepositoryGenerator.setData(Quiz::setRightAnswer, DataType.WORD);
            quizRepositoryGenerator.setData(Quiz::setCategory, DataType.WORD);
            quizRepository.saveAll(quizRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Block entities...");
            ExampleDataGenerator<Block> blockRepositoryGenerator = new ExampleDataGenerator<>(Block.class,
                    LocalDateTime.of(2022, 4, 23, 0, 0, 0));
            blockRepositoryGenerator.setData(Block::setName, DataType.WORD);
            blockRepositoryGenerator.setData(Block::setDescription, DataType.WORD);
            blockRepositoryGenerator.setData(Block::setType, DataType.WORD);
            blockRepositoryGenerator.setData(Block::setTimeLimit, DataType.WORD);
            blockRepositoryGenerator.setData(Block::setActive, DataType.BOOLEAN_50_50);
            blockRepository.saveAll(blockRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Participant entities...");
            ExampleDataGenerator<Participant> participantRepositoryGenerator = new ExampleDataGenerator<>(
                    Participant.class, LocalDateTime.of(2022, 4, 23, 0, 0, 0));
            participantRepositoryGenerator.setData(Participant::setFirstName, DataType.FIRST_NAME);
            participantRepositoryGenerator.setData(Participant::setLastName, DataType.LAST_NAME);
            participantRepositoryGenerator.setData(Participant::setEmail, DataType.EMAIL);
            participantRepositoryGenerator.setData(Participant::setPhone, DataType.PHONE_NUMBER);
            participantRepositoryGenerator.setData(Participant::setDateOfBirth, DataType.DATE_OF_BIRTH);
            participantRepositoryGenerator.setData(Participant::setUsername, DataType.OCCUPATION);
            participantRepositoryGenerator.setData(Participant::setPassword, DataType.TWO_WORDS);
            participantRepositoryGenerator.setData(Participant::setActive, DataType.BOOLEAN_50_50);
            participantRepository.saveAll(participantRepositoryGenerator.create(100, seed));

            logger.info("... generating 100 Participant Block entities...");
            ExampleDataGenerator<ParticipantBlock> participantBlockRepositoryGenerator = new ExampleDataGenerator<>(
                    ParticipantBlock.class, LocalDateTime.of(2022, 4, 23, 0, 0, 0));
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setDescription, DataType.WORD);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setBlock, DataType.WORD);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setStartDate,
                    DataType.DATETIME_LAST_10_YEARS);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setEndDate, DataType.DATETIME_LAST_10_YEARS);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setStatus, DataType.WORD);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setResult, DataType.WORD);
            participantBlockRepositoryGenerator.setData(ParticipantBlock::setAccess, DataType.BOOLEAN_50_50);
            participantBlockRepository.saveAll(participantBlockRepositoryGenerator.create(100, seed));

            logger.info("Generated demo data");
        };
    }

}