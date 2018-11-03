package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChatWorker extends Thread {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private ChatHelper chatHelper = new ChatHelper();
    private String currentUser;

    ChatWorker(DataInputStream dataInputStream, DataOutputStream dataOutputStream) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String instruction;
                instruction = dataInputStream.readUTF();
                if (instruction.equalsIgnoreCase("HELP")) {
                    dataOutputStream.writeUTF(chatHelper.help());
                } else if (instruction.toLowerCase().startsWith("login")) {
                    String[] words = instruction.split(" ");
                    currentUser = words[1];
                    chatHelper.login(words[1]);
                    dataOutputStream.writeUTF(words[1] + ", добро пожаловать.");
                } else if (instruction.equalsIgnoreCase("list")) {
                    dataOutputStream.writeUTF(chatHelper.list());
                } else if (instruction.toLowerCase().startsWith("write")) {
                    String[] words = instruction.split(" ");
                    chatHelper.write(words[2], currentUser, words[1]);
                    dataOutputStream.writeUTF("Сообщение отпревлено");
                }else if (instruction.equalsIgnoreCase("read")){
                    dataOutputStream.writeUTF(chatHelper.read(currentUser));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
