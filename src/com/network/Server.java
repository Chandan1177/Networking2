package com.network;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            try {
                Socket s=new Socket();
                ServerSocket ss=new ServerSocket(1024);
                System.out.println("server running...");
                s=ss.accept();
                System.out.println("connected");
                while(true){
                    DataInputStream dis=new DataInputStream(s.getInputStream());
                    System.out.println(dis.readUTF());
                    DataOutputStream dos=new DataOutputStream(s.getOutputStream());
                    dos.writeUTF(sc.nextLine());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
