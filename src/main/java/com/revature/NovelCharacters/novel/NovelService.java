package com.revature.NovelCharacters.novel;

import com.revature.NovelCharacters.fictionalcharacter.FictionalCharacter;
import com.revature.NovelCharacters.fictionalcharacter.dto.requests.UpdateFictionalCharacterRequest;
import com.revature.NovelCharacters.novel.DTO.requests.NewNovelRequest;
import com.revature.NovelCharacters.novel.DTO.requests.UpdateNovelRequest;
import com.revature.NovelCharacters.novel.DTO.response.NovelResponse;
import com.revature.NovelCharacters.util.exceptions.InvalidUserInputException;
import com.revature.NovelCharacters.util.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NovelService {
    private final NovelRepository novelRepository;
    @Autowired
    public NovelService(NovelRepository novelRepository) {
        this.novelRepository = novelRepository;
    }

    @Transactional(readOnly = true)
    public Novel findById(int id) {
        Novel novel = novelRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return novel;
    }
    @Transactional
    public NovelResponse registerNovel(NewNovelRequest newNovel) {
        Novel requestNovel = new Novel(newNovel);
        return new NovelResponse(novelRepository.save(requestNovel));
    }
    @Transactional(readOnly = true)
    public List<NovelResponse> allNovels() {
        return ((Collection<Novel>) novelRepository.findAll())
                                                   .stream()
                                                   .map(NovelResponse::new)
                                                   .collect(Collectors.toList());
    }

    @Transactional
    public void update(UpdateNovelRequest request) throws InvalidUserInputException {
        Novel novel = novelRepository.findById(request.getNovelId()).orElseThrow(ResourceNotFoundException::new);
        novel.setNovelName(request.getNovelName());
        novel.setNovelGenre(request.getNovelGenre());
    }

    @Transactional
    public void delete(int id){
        novelRepository.deleteById(id);
    }
}