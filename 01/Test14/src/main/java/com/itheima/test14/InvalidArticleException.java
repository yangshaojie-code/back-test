package com.itheima.test14;

public class InvalidArticleException extends Exception {
    public InvalidArticleException() {
    }
    public InvalidArticleException(String message) {
        super(message);
    }
}
