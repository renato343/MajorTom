package org.academiadecodigo.bootcamp.roothless.lunarModule.model;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 30/03/17.
 */
public class LunarModule {

    String name;
    int port;

    Socket houstonSocket = null;


    public LunarModule(String name, int port) {
        this.name = "localhost";
        this.port = 8080;
    }

    public void start() {

        try {

            houstonSocket = new Socket(name, port);

            LunarListener sender = new LunarListener(houstonSocket);
            LunarSender listener = new LunarSender(houstonSocket);

            Thread senderThread = new Thread(sender);
            Thread Listenerthread = new Thread(listener);

            senderThread.start();
            Listenerthread.start();


        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private class LunarListener implements Runnable {

        String messageIn;

        public LunarListener(Socket houston) {

            houstonSocket = houston;
        }

        public synchronized void run() {

            receiveMessage();

        }

        public void receiveMessage() {

            try {


                DataInputStream in = new DataInputStream(houstonSocket.getInputStream());

                while (!houstonSocket.isClosed()) {

                    //console.setvisible(false);

                    System.out.println("waiting Houston to write");

                    messageIn = in.readLine();

                    parserThrust(messageIn);
                    parserDirection(messageIn);

                    //console.setText(messageIn);

                    //console.setvisible(true);

                }
                houstonSocket.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void parserDirection(String messageReceived) {

            System.out.println("this is message Received " + messageReceived);
            String direction = messageReceived.split(" ")[0];


        }

        public void parserThrust(String messageReceived) {

            System.out.println("this is message Received  in Thrust Parser" + messageReceived);
            Double thrust = Double.parseDouble(messageReceived.split(" ")[1]);

        }
    }

    private class LunarSender implements Runnable {


        private LunarSender(Socket houston) {
            houstonSocket = houston;
        }

        public synchronized void run() {

            sendCommand();

        }

        public void sendCommand() {

            try {

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(houstonSocket.getOutputStream()));

                while (!houstonSocket.isClosed()) {

                    System.out.println("in send command of lunarmodule");
                    String message = readMyConsole();
                    out.write(message);
                    out.newLine();
                    out.flush();
                }
                houstonSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readMyConsole() {

            System.out.println("wait for server to write");
            Scanner reader = new Scanner(System.in);
            return reader.nextLine();

        }
    }

    public static void main(String[] args) {

        LunarModule lunarModule = new LunarModule("localhost", 8080);

        lunarModule.start();

    }


}

