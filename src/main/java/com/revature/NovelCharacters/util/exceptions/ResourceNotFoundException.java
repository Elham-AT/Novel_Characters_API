package com.revature.NovelCharacters.util.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
    }
    public ResourceNotFoundException(String message) {
        super(message);

    }
}
