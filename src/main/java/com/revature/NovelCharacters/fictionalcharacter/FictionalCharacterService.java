package com.revature.NovelCharacters.fictionalcharacter;

import com.revature.NovelCharacters.novel.Novel;
import com.revature.NovelCharacters.novel.NovelService;
import com.revature.NovelCharacters.fictionalcharacter.dto.requests.UpdateFictionalCharacterRequest;
import com.revature.NovelCharacters.fictionalcharacter.dto.requests.NewFictionalCharacterRequest;
import com.revature.NovelCharacters.fictionalcharacter.dto.response.FictionalCharacterResponse;
import com.revature.NovelCharacters.util.exceptions.InvalidUserInputException;
import com.revature.NovelCharacters.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FictionalCharacterService {

    private final FictionalCharacterRepository fictionalCharacterRepository;
    private final NovelService novelService;

    @Autowired
    public FictionalCharacterService(FictionalCharacterRepository fictionalCharacterRepository, NovelService novelService) {
        this.fictionalCharacterRepository = fictionalCharacterRepository;
        this.novelService = novelService;
    }



    @Transactional(readOnly = true)
    public FictionalCharacterResponse findById(int id) {
        FictionalCharacter fictionalCharacter = fictionalCharacterRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        FictionalCharacterResponse fictionalCharacterResponse = new FictionalCharacterResponse(fictionalCharacter);
        return fictionalCharacterResponse;
    }


    @Transactional(readOnly = true)
    public List<FictionalCharacterResponse> allCharacters() {
        return ((Collection<FictionalCharacter>) fictionalCharacterRepository.findAll())
                .stream()
                .map(FictionalCharacterResponse::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<FictionalCharacterResponse> allCharactersByNovelId(int novelId) {
        return   allCharacters()
                .stream()
                .filter(c -> c.getNovel().getId() == novelId)
                .collect(Collectors.toList());
    }

    @Transactional
    public FictionalCharacterResponse createNovelCharacter(NewFictionalCharacterRequest newFictionalCharacterRequest) throws Exception {
        Novel novel = novelService.findById(newFictionalCharacterRequest.getNovelId());
        List<FictionalCharacterResponse> all = allCharactersByNovelId(novel.getId());
        if(all.size() > 2)
            throw new Exception("A novel cannot have more than 3 characters");
        FictionalCharacter fictionalCharacter = new FictionalCharacter(newFictionalCharacterRequest, novel);
        FictionalCharacterResponse fictionalCharacterResponse = new FictionalCharacterResponse(fictionalCharacterRepository.save(fictionalCharacter));
        return fictionalCharacterResponse;
    }

    @Transactional
    public void update(UpdateFictionalCharacterRequest request) throws Exception {
        FictionalCharacter foundFictionalCharacter = fictionalCharacterRepository.findById(request.getCharacterId()).orElseThrow(ResourceNotFoundException::new);
        foundFictionalCharacter.setName(request.getName());
        foundFictionalCharacter.setGender(request.getGender());
        foundFictionalCharacter.setAge(request.getAge());
        Novel novel = novelService.findById(request.getNovelId());
        List<FictionalCharacterResponse> all = allCharactersByNovelId(novel.getId());

        if(all.size() > 2 && foundFictionalCharacter.getNovel().getId() != novel.getId())
            throw new Exception("A novel cannot have more than 3 characters");
        foundFictionalCharacter.setNovel(novel);
    }

    @Transactional
    public void delete(int id){
        fictionalCharacterRepository.deleteById(id);
    }

}
