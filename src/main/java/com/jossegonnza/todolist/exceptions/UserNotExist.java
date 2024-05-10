package com.jossegonnza.todolist.exceptions;

public class UserNotExist extends RuntimeException {

    public UserNotExist(String message) {
        super(message);
    }
}
