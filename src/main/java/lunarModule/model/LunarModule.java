package lunarModule.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by codecadet on 30/03/17.
 */
public class LunarModule {

    String name;
    int port;

    ServerSocket mySocket = null;
    Socket houstonSocket = null;


    public LunarModule(String name, int port) {
        this.name = "192.168.1.13";
        this.port = 8080;
    }

    public void start() {

        try {

            mySocket = new ServerSocket(port);

            System.out.println("waiting for client");

            houstonSocket = mySocket.accept();

            System.out.println("got client");

            ClientSender sender = new ClientSender(houstonSocket);
            ClientListener listener = new ClientListener(houstonSocket);

            Thread senderThread = new Thread(sender);
            Thread Listenerthread = new Thread(listener);

            senderThread.start();
            Listenerthread.start();


        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    private class ClientSender implements Runnable {

        private final Socket clientSocket;

        public ClientSender(Socket clientSocket) {

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


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ClientListener implements Runnable {

        private final Socket senderSocket;

        private ClientListener(Socket senderSocket) {
            this.senderSocket = senderSocket;
        }

        public synchronized void run() {

            while (!houstonSocket.isClosed()) {
                sendCommand();
            }

        }

        public void sendCommand() {

            try {


                DataOutputStream out;

                out = new DataOutputStream(houstonSocket.getOutputStream());

                while (!houstonSocket.isClosed()) {

                    String message = readServerMessage();
                    out.writeBytes(message);
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

        LunarModule lunarModule = new LunarModule("localhost",8080);

        lunarModule.start();

    }


}

