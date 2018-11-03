package com.company;

public class Message {

    private String message;
    private String from;
    private String to;

    Message(String message, String from, String to) {
        this.message = message;
        this.from = from;
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    public String getMessage() {
        return message;
    }
}
