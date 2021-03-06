package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ChatHelper {


    public String help() {
        return "1.login %username%\n" +
                "2.list\n" +
                "3.write %username% %message%\n" +
                "4.read\n" +
                "5.exit";
    }

    public void login(String name) {
        User user = new User(name);
        user.setStatus(true);
        ChatStorage.getInstance().addUser(user);
    }

    public String list() {
//        LinkedList<User> users = ChatStorage.getInstance().getUsers();
//        ArrayList<String> usersName = new ArrayList<>();
//        for (User user : users) {
//            usersName.add(user.getName());
//        }
//        String list = String.join(",", usersName);
        return ChatStorage.getInstance().getUsers().stream()
                .map(user -> user.getName())
                .collect(Collectors.joining(","));
    }

    public void write(String message, String from, String to) {
        if (ChatStorage.getInstance().isUserExists(to)) {
            Message newMessage = new Message(message, from, to);
            ChatStorage.getInstance().addMessage(newMessage);
        }
    }

    public String read(String currentUser) {
        return ChatStorage.getInstance().getMessagesForUser(currentUser);
    }

    public void exit() {
    }
}
