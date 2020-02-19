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
                Socket socket = s.accept();
                System.out.println("client connected");
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String echo = input.readLine();
                if(echo.equals("exit")){
                    break;
                }
                output.println("Echo from server: " + echo );

            }

        } catch (IOException e) {
            System.out.println("servre exception");
            e.printStackTrace();
        }
    }
}
