package com.company;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
//        ArrayList<String> messagesForUser = new ArrayList<>();
//        for (Message carrentMessage : messages) {
//            if (carrentMessage.getTo().equalsIgnoreCase(user)) {
//                messagesForUser.add(carrentMessage.getFrom() + ":" + carrentMessage.getMessage());
//            }
//        }
//        String list = String.join("\n", messagesForUser);
        return messages.stream()
                .filter(message -> message.getTo().equalsIgnoreCase(user))
                .map(message -> message.getFrom() + ":" + message.getMessage())
                .collect(Collectors.joining("\n"));
    }

    public boolean isUserExists(String name) {
//        boolean isUserExists = false;
//        for (User carrentUser : users) {
//            if (carrentUser.getName().equalsIgnoreCase(name)) {
//                isUserExists = true;
//            }
//        }
        return users.stream().anyMatch(user -> user.getName().equalsIgnoreCase(name));
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

