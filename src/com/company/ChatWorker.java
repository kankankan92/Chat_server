package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ChatWorker extends Thread {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private ChatHelper chatHelper = new ChatHelper();

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
                    System.out.println(words[0]);
                    chatHelper.login(words[1]);
                    dataOutputStream.writeUTF(words[1] + ", добро пожаловать.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
