package com.revature.NovelCharacters.util.aspects;


import com.revature.NovelCharacters.util.exceptions.InvalidUserInputException;
import com.revature.NovelCharacters.util.exceptions.ResourceNotFoundException;
import com.revature.NovelCharacters.util.exceptions.ResourcePersistanceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionAspect {

    @ExceptionHandler({ResourcePersistanceException.class, InvalidUserInputException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String exceptionHandling(Exception ex){
        return "Exception was thrown... " + ex.getClass().getName() + " " + ex.getMessage();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String resourceNotFound(ResourceNotFoundException rnf){
        return "Exception was thrown... " + rnf.getClass().getName() + " " + rnf.getMessage();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody String exception(Exception ex){
        return "Error has occurred in our program, please check logs" + ex.getClass().getName() + " with message: " + ex.getMessage();
    }

}
