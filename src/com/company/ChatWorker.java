package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.SocketException;

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
                if (instruction.equalsIgnoreCase("help")) {
                    dataOutputStream.writeUTF(chatHelper.help());
                } else if (instruction.toLowerCase().startsWith("login")) {
                    String[] words = instruction.split(" ");
                    currentUser = words[1];
                    chatHelper.login(words[1]);
                    dataOutputStream.writeUTF(words[1] + ", добро пожаловать.");
                } else if (instruction.equalsIgnoreCase("list")) {
                    dataOutputStream.writeUTF(chatHelper.list());
                } else if (instruction.toLowerCase().startsWith("write")) {
                    int startTo = instruction.indexOf(" ") + 1;
                    int startMessage = instruction.indexOf(" ", startTo + 1) + 1;
                    String to = instruction.substring(startTo, startMessage - 1);
                    String message = instruction.substring(startMessage);
                    chatHelper.write(message, currentUser, to);
                    dataOutputStream.writeUTF("Сообщение отпревлено");
                } else if (instruction.equalsIgnoreCase("read")) {
                    dataOutputStream.writeUTF(chatHelper.read(currentUser));
                } else if (instruction.equalsIgnoreCase("exit")) {
                    currentUser = null;
                    dataOutputStream.writeUTF("Досвидания");
                    System.out.println("Клиент отключился");
                    return;
                } else {
                    dataOutputStream.writeUTF("Некорректная команда, вы можете увидеть список команд набрав Help");
                }
            }
//        } catch (SocketException s) {
//            System.out.println("Клиент отключился");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
