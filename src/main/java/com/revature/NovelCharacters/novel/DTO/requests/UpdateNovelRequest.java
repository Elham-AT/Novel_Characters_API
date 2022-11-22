package com.revature.NovelCharacters.novel.DTO.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNovelRequest {

    @Positive(message = "Novel id may not be zero!")
    private int novelId;

    @NotBlank(message = "Novel name may not be blank!")
    @NotNull(message = "Novel name may not be blank!")
    private String novelName;

    @NotBlank(message = "Novel genre may not be blank!")
    @NotNull(message = "Novel genre may not be blank!")
    private String novelGenre;
}
