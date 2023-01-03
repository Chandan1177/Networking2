package com.Chat;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;

public class server2{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            Socket s=new Socket();
            ServerSocket ss=new ServerSocket(8081);
            System.out.println("server running...");
            s=ss.accept();
            System.out.println("connected");

            Scanner sc1=new Scanner(s.getInputStream());
            int st = sc1.nextInt();
            System.out.println(st);
            String optput;

            if(st%2==0){optput="sum";}
            else{optput="odd";}

            PrintStream ps=new PrintStream(s.getOutputStream());
            ps.println(optput);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
