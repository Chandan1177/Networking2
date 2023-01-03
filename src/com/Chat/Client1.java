package com.Chat;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Socket s;
        try {
            while(true) {
                s = new Socket("10.68.98.125", 8080);
                System.out.println("conneced");
                PrintStream ps=new PrintStream(s.getOutputStream());
                ps.println(sc.nextLine());
                Scanner sc1=new Scanner(s.getInputStream());
                while(true) {
                    String st = sc1.nextLine();
                    System.out.println(st);

                    String str= sc.nextLine();
                    ps.println(str);

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

