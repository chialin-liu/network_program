package com.charles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(ServerSocket s = new ServerSocket(5000)){
            while(true){

                new Echoer(s.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("servre exception");
            e.printStackTrace();
        }
    }
}
