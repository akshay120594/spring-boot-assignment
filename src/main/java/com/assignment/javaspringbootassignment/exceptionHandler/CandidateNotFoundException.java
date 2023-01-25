package com.assignment.javaspringbootassignment.exceptionHandler;

public class CandidateNotFoundException extends RuntimeException{
    public CandidateNotFoundException(String msg){
        super(msg);
    }

}
