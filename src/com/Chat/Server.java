package com.Chat;
import java.io.IOException;
import java.io.PrintStream;
import java.net.*;
import java.util.HashMap;
import java.util.Scanner;

public class Server{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String, Socket> map = new HashMap<>();
            try {
                Socket s=new Socket();
                ServerSocket ss=new ServerSocket(8080);
                System.out.println("server running...");
                while(true) {
                    s = ss.accept();
                    System.out.println("connected");

                    //get ip in string formate
                    InetSocketAddress ip = (InetSocketAddress) s.getRemoteSocketAddress();
                    String cip = (ip.getAddress() + "").replace("/", "");
                    System.out.println(cip);

                    //store ip and socket in hasmape
                    map.put(cip, s);
                    System.out.println(map.size());
                    if (map.size() >= 2) {
                        //ask ip from user of who preson that hi want to connect
                        Scanner scip = new Scanner(s.getInputStream());
                        String st = scip.nextLine();
                        System.out.println("clinet 2 enter ip is "+st);

                        //connect to other client
                        Socket client2 = map.get(st);
                        PrintStream psc1 = new PrintStream(s.getOutputStream());
                        PrintStream psc2 = new PrintStream(client2.getOutputStream());

                        String by = "";
                        if (!by.equals("Byy")) {
                            for (int i = 0; i >= 0; i++) {
                                System.out.println("loop");
                                Scanner sc2 = new Scanner(client2.getInputStream());
                                String st2 = sc2.nextLine();
                                System.out.println("i am reached here and st2 is "+st2);
                                System.out.println(st2);
                                psc1.println(st2);

                                Scanner sc1 = new Scanner(s.getInputStream());
                                String str1 = sc1.nextLine();
                                System.out.println(str1);
                                psc2.println(str1);
                                by = st;
                            }
                        } else {
                            s.close();
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}
