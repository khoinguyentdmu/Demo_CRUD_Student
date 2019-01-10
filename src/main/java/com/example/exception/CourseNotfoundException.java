package com.example.exception;

public class CourseNotfoundException extends RuntimeException {
    public CourseNotfoundException(Integer id){
        super("Could not find course " + id);
    }
}
