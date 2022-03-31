package uz.maniac4j.quizservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import uz.maniac4j.quizservice.model.Block;
import uz.maniac4j.quizservice.repository.BlocksRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BlockService {

    private final BlocksRepository blocksRepository;

    @Autowired
    public BlockService(BlocksRepository blocksRepository) {
        this.blocksRepository = blocksRepository;
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
