package com.company;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.LinkedList;

public class ChatStorage {

    private LinkedList<User> users = new LinkedList<>();
    private LinkedList<Message> messages = new LinkedList<>();

    public LinkedList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public String getMessagesForCurrentUser(String carrentUser) {
        ArrayList<String> messagesForCurrentUser = new ArrayList<>();
        for (Message carrentMessage : messages) {
            if (carrentMessage.getTo().equalsIgnoreCase(carrentUser)) {
                messagesForCurrentUser.add(carrentMessage.getMessage());
            }
        }
        String list = String.join("\n", messagesForCurrentUser);
        return list;
    }

    public boolean isThisUserHere(String name) {
        boolean isThisUserHere = false;
        for (User carrentUser : users) {
            if (carrentUser.getName().equalsIgnoreCase(name)) {
                isThisUserHere = true;
            }
        }
        return isThisUserHere;
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

    private ChatStorage() {
    }

}

