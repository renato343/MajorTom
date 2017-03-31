package org.academiadecodigo.bootcamp.roothless.houston.model;

import org.academiadecodigo.bootcamp.roothless.houston.controller.HoustonController;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codecadet on 30/03/17.
 */
public class Houston implements Runnable {

    private String name;
    private int port;

    LunarModule lunarModule;

    public void setHoustonController(HoustonController houstonController) {
        this.houstonController = houstonController;
    }

    HoustonController houstonController;

    ServerSocket mySocket = null;
    Socket houstonSocket = null;


    public Houston(String name, int port) {
        this.name = name;
        this.port = port;
    }

    public void run() {

        try {

            mySocket = new ServerSocket(port);

            System.out.println("waiting for client");

            ExecutorService pool = Executors.newFixedThreadPool(2);


            while (true) {

                houstonSocket = mySocket.accept();
                System.out.println("got client");
                lunarModule = new LunarModule(houstonSocket);
                pool.submit(lunarModule);

            }

        } catch (IOException e) {


            e.printStackTrace();
        }

    }

    public void sendToLunarModule(String messageToSend) {
        System.out.println("sending from Houston to Lunar module " + messageToSend);
        lunarModule.sendCommand(messageToSend);
    }

    public void sendToHoustonConsole(String s){

        System.out.println("enter send to console on houston " + s);

        houstonController.setConsoleHouston(s);
    }

    public class LunarModule implements Runnable {

        private final Socket clientSocket;

        public void sendCommand(String directionAndThrust) {

            try {

                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(houstonSocket.getOutputStream()));

                System.out.println("entered while of sendcommand");

                out.write(directionAndThrust);
                out.newLine();
                out.flush();


            } catch (
                    IOException e)

            {
                e.printStackTrace();
            }
        }

        public LunarModule(Socket clientSocket) {

            this.clientSocket = clientSocket;
        }

        public synchronized void run() {

            receiveMessage();



        }

        public String receiveMessage() {

            String messageIn= "";

            try {

                DataInputStream in;

                in = new DataInputStream(clientSocket.getInputStream());

                while (!clientSocket.isClosed()) {

                    //console.setvisible(false);

                    System.out.println("waiting client to write");

                    messageIn = in.readLine();

                    System.out.println(messageIn);

                    sendToHoustonConsole(messageIn);

                    messageIn = in.toString();


                }
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }return messageIn;
        }


    }


}
