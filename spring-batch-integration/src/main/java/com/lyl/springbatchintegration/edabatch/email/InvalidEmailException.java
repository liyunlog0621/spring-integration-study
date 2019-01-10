package com.lyl.springbatchintegration.edabatch.email;

/**
 * ClassName InvalidEmailException
 * Author liyunlong
 * Data 下午 2:26
 * Version 1.0
 **/
public class InvalidEmailException extends Exception {
    public InvalidEmailException(String email) {
        super(String.format("the email %s isn't valid", email));
    }
}
