package com.revature.NovelCharacters.fictionalcharacter;

import com.revature.NovelCharacters.novel.Novel;
import com.revature.NovelCharacters.fictionalcharacter.dto.requests.NewFictionalCharacterRequest;
import com.revature.NovelCharacters.fictionalcharacter.dto.response.FictionalCharacterResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fictional_character")
public class FictionalCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(name = "character_name")
    private String name;

    @Column(name = "character_gender")
    private String gender;

    @Column(name = "character_age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "novel_id", nullable = false)
    private Novel novel;

    public FictionalCharacter(NewFictionalCharacterRequest newGameDetailsRequest, Novel novel) {
        this.name = newGameDetailsRequest.getName();
        this.gender = newGameDetailsRequest.getGender();
        this.age = newGameDetailsRequest.getAge();
        this.novel = novel;
    }
}
