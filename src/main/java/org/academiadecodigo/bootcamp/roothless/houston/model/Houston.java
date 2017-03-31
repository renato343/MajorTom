package org.academiadecodigo.bootcamp.roothless.houston.model;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codecadet on 30/03/17.
 */
public class Houston {

    String name;
    int port;

    ServerSocket mySocket = null;
    Socket houstonSocket = null;


    public Houston(String name, int port) {
        this.name = "localhost";
        this.port = port;
    }

    public void start() {

        try {

            mySocket = new ServerSocket(port);

            System.out.println("waiting for client");



            System.out.println("got client");

            ExecutorService pool = Executors.newFixedThreadPool(10);


            while (true) {

                houstonSocket = mySocket.accept();

                LunarModuleReader sender = new LunarModuleReader(houstonSocket);
                LunarSender listener = new LunarSender(houstonSocket);

                pool.submit(sender);
                pool.submit(listener);

            }

        } catch (IOException e) {


            e.printStackTrace();
        }

    }

    private class LunarModuleReader implements Runnable {

        private final Socket clientSocket;

        public LunarModuleReader(Socket clientSocket) {

            this.clientSocket = clientSocket;
        }

        public synchronized void run() {

            receiveMessage();

        }

        public void receiveMessage() {

            try {

                DataInputStream in;

                in = new DataInputStream(clientSocket.getInputStream());

                while (!clientSocket.isClosed()) {

                    //console.setvisible(false);

                    System.out.println("waiting client to write");

                    String messageIn = in.readLine();

                    System.out.println(messageIn);

                    messageIn = in.toString();

                    //console.setText(messageIn);

                    //console.setvisible(true);

                }
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class LunarSender implements Runnable {

        private final Socket senderSocket;

        private LunarSender(Socket senderSocket) {
            this.senderSocket = senderSocket;
        }

        public synchronized void run() {

            while (!houstonSocket.isClosed()) {
                sendCommand();
            }
            try {
                houstonSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void sendCommand() {

            try {


                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(houstonSocket.getOutputStream()));



                while(!houstonSocket.isClosed()) {

                    String message = readServerMessage();
                    out.write(message);
                    out.newLine();
                    out.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readServerMessage() {

            System.out.println("wait for server to write");
            Scanner reader = new Scanner(System.in);
            return reader.nextLine();

        }
    }

    public static void main(String[] args) {

        Houston houston = new Houston("houston", 8080);
        houston.start();
    }


}
