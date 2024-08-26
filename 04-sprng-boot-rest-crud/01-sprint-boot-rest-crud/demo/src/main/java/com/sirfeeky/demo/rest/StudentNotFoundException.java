package com.sirfeeky.demo.rest;

public class StudentNotFoundException extends  RuntimeException{
    StudentNotFoundException(String message){
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
