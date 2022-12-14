package com.revature.NovelCharacters.novel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NovelRepository extends CrudRepository<Novel, Integer> { }
