package com.revature.NovelCharacters.novel.DTO.response;

import com.revature.NovelCharacters.novel.Novel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class NovelResponse {
    private int id;
    private String novelName;
    private String novelGenre;

    public NovelResponse(Novel novel) {
        id = novel.getId();
        novelName = novel.getNovelName();
        novelGenre = novel.getNovelGenre();
    }
}
