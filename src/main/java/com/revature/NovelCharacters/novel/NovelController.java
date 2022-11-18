package com.revature.NovelCharacters.novel;

import com.revature.NovelCharacters.novel.DTO.requests.NewNovelRequest;
import com.revature.NovelCharacters.novel.DTO.response.NovelResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/novel")
public class NovelController {
    private final NovelService novelService;
    public NovelController(NovelService novelService) {
        this.novelService = novelService;
    }
    @GetMapping("/{id}")
    public NovelResponse findById(@PathVariable int id) {
        return new NovelResponse(novelService.findById(id));
    }
    @GetMapping
    public List<NovelResponse> getNovels() {
        return novelService.allNovels();
    }

    @PostMapping
    public NovelResponse create(@RequestBody @Valid NewNovelRequest newNovelRequest){
        return novelService.registerNovel(newNovelRequest);
    }
}
