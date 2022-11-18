package com.revature.NovelCharacters.fictionalcharacter.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class UpdateFictionalCharacterRequest {
    @Positive(message = "Character id may not be zero!")
    private int characterId;

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
