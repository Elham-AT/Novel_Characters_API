package com.revature.NovelCharacters.fictionalcharacter.dto.response;

import com.revature.NovelCharacters.fictionalcharacter.FictionalCharacter;
import com.revature.NovelCharacters.novel.Novel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FictionalCharacterResponse {
    private int id;
    private String name;
    private String gender;
    private int age;
    private Novel novel;
    public FictionalCharacterResponse(FictionalCharacter fictionalCharacter) {
        this.id = fictionalCharacter.getId();
        this.name = fictionalCharacter.getName();
        this.gender = fictionalCharacter.getGender();
        this.age = fictionalCharacter.getAge();
        this.novel = fictionalCharacter.getNovel();
    }
}
