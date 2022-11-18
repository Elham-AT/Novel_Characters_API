package com.revature.NovelCharacters.novel.DTO.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewNovelRequest {

    @NotBlank(message = "Novel name may not be blank!")
    @NotNull(message = "Novel name may not be blank!")
    private String novelName;

    @NotBlank(message = "Novel genre may not be blank!")
    @NotNull(message = "Novel genre may not be blank!")
    private String novelGenre;
}
