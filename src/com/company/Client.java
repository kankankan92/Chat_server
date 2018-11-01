package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 2092);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        System.out.println("Введите команду HELP");

        while (true) {
            Scanner scan = new Scanner(System.in);
            String string = scan.nextLine();
            dataOutputStream.writeUTF(string);
            System.out.println(dataInputStream.readUTF());
        }
    }
}

