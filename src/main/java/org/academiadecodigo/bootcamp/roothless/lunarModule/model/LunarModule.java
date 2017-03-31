package org.academiadecodigo.bootcamp.roothless.lunarModule.model;

import org.academiadecodigo.bootcamp.roothless.lunarModule.service.Service;

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
    private Service service;


    public LunarModule(String name, int port, Service service) {
        this.service = service;
        this.name = "localhost";
        this.port = 9999;
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

                    parser(messageIn);

                    //console.setText(messageIn);

                    //console.setvisible(true);

                }
                houstonSocket.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void parser(String messageReceived) {
            System.out.println("this is message Received " + messageReceived);
            String direction = messageReceived.split(" ")[0].toLowerCase();
            double thrust = Double.parseDouble(messageReceived.split(" ")[1]);

            switch (direction) {
                case "up":
                    service.thrustUp(thrust);
                    break;
                case "right":
                    service.thrustRight(thrust);
                    break;
                case "left":
                    service.thrustLeft(thrust);
                    break;

            }

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


    public void setService(Service service) {
        this.service = service;
    }
}

