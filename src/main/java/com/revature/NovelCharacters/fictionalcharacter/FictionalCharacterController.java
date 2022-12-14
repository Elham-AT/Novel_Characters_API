package com.revature.NovelCharacters.fictionalcharacter;

import com.revature.NovelCharacters.fictionalcharacter.dto.requests.NewFictionalCharacterRequest;
import com.revature.NovelCharacters.fictionalcharacter.dto.requests.UpdateFictionalCharacterRequest;
import com.revature.NovelCharacters.fictionalcharacter.dto.response.FictionalCharacterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fictional_character")
public class FictionalCharacterController {

    private final FictionalCharacterService fictionalCharacterService;

    @Autowired
    public FictionalCharacterController(FictionalCharacterService fictionalCharacterService) {
        this.fictionalCharacterService = fictionalCharacterService;
    }
    @GetMapping("/{id}")
    public FictionalCharacterResponse findById(@PathVariable int id){
        return fictionalCharacterService.findById(id);
    }

    @GetMapping
    public List<FictionalCharacterResponse> getCharacters() {
        return fictionalCharacterService.allCharacters();
    }

    @GetMapping("/novel/{novelId}")
    public List<FictionalCharacterResponse> getCharactersByNovelId(@PathVariable int novelId) {
        return fictionalCharacterService.allCharactersByNovelId(novelId);
    }

    @PostMapping
    public FictionalCharacterResponse create(@RequestBody @Valid NewFictionalCharacterRequest request) throws Exception {
        return fictionalCharacterService.createNovelCharacter(request);
    }

    @PutMapping
    public void updateCharacter(@RequestBody UpdateFictionalCharacterRequest updateFictionalCharacterRequest) throws Exception {
        fictionalCharacterService.update(updateFictionalCharacterRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        fictionalCharacterService.delete(Integer.parseInt(id));
    }



}
