package com.company;

import java.util.LinkedList;

public class ChatStorage {

    private LinkedList<User> users = new LinkedList<>();
    private LinkedList<Message> messages =  new LinkedList<>();

    public LinkedList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
      this.users.add(user);
    }

    public LinkedList<Message> getMessages() {
        return messages;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public static ChatStorage getInstance() {
        return INSTANCE;
    }

    final static private ChatStorage INSTANCE = new ChatStorage();

    private ChatStorage(){}

}

