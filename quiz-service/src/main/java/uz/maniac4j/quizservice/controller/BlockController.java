package uz.maniac4j.quizservice.controller;

import org.springframework.web.bind.annotation.*;
import uz.maniac4j.quizservice.dto.BlockDto;
import uz.maniac4j.quizservice.model.Block;
import uz.maniac4j.quizservice.service.BlockService;

import java.util.List;

@RestController
@RequestMapping("api/quiz/block")
public class BlockController {

    private final BlockService service;

    public BlockController(BlockService service) {
        this.service = service;
    }

    @GetMapping("/one/{id}")
    public Block one(@PathVariable("id") Long id){
        return service.one(id);
    }

    @GetMapping("/all")
    public List<Block> findAll(){
        return service.all();
    }

    @PostMapping("/add")
    public Block addBlock(@RequestBody Block block){
        return service.add(block);
    }


    @PostMapping("/add/custom")
    public Block addBlockCustom(@RequestBody BlockDto dto){
        return service.add(dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteBlock(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PutMapping("/edit")
    public Block editBlock(@RequestBody Block block){
        return service.edit(block);
    }


    @GetMapping("/existsByBlockAndOrganization/{block_id}/{organization_id}")
    public Boolean existsByBlockAndOrganization(@PathVariable long block_id, @PathVariable long organization_id){
        return service.existsByBlockAndOrganization(block_id, organization_id);
    }
}
