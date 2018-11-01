package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

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
        LinkedList<User> users = ChatStorage.getInstance().getUsers();
        ArrayList<String> usersName = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            usersName.add(users.get(i).getName());
        }
        String list = String.join(",", usersName);
        return list;
    }

    public void write(String username, String message) {

    }

    public void read() {
    }

    public void exit() {
    }
}