package com.revature.NovelCharacters.fictionalcharacter.dto.requests;

import com.revature.NovelCharacters.novel.Novel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@NotNull
public class NewFictionalCharacterRequest {
    @NotBlank(message = "Novel name may not be blank!")
    @NotNull(message = "Novel name may not be blank!")
    private String name;

    @NotBlank(message = "Novel genre may not be blank!")
    @NotNull(message = "Novel genre may not be blank!")
    private String gender;

    @Positive(message = "Age have to be a positive number!")
    private int age;

    @Positive(message = "Novel id may not be zero!")
    private int novelId;
}
