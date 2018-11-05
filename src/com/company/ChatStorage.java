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

    public String getMessagesForUser(String user) {
        ArrayList<String> messagesForCurrentUser = new ArrayList<>();
        for (Message carrentMessage : messages) {
            if (carrentMessage.getTo().equalsIgnoreCase(user)) {
                messagesForCurrentUser.add(carrentMessage.getFrom() + ":" + carrentMessage.getMessage());
            }
        }
        String list = String.join("\n", messagesForCurrentUser);
        return list;
    }

    public boolean isUserExists(String name) {
        boolean isUserExists = false;
        for (User carrentUser : users) {
            if (carrentUser.getName().equalsIgnoreCase(name)) {
                isUserExists = true;
            }
        }
        return isUserExists;
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

