package com.revature.NovelCharacters.novel;

import com.revature.NovelCharacters.novel.DTO.requests.NewNovelRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="novel")

public class Novel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="novel_id")
    private int id;
    @Column(name="novel_name", nullable = false)
    private String novelName;

    @Column(name = "novel_genre", nullable = false)
    private String novelGenre;

    public Novel(NewNovelRequest newNovelRequest) {
        this.novelName = newNovelRequest.getNovelName();
        this.novelGenre = newNovelRequest.getNovelGenre();
    }
}
