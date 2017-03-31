package org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.academiadecodigo.bootcamp.roothless.Navigation;
import org.academiadecodigo.bootcamp.roothless.lunarModule.controller.TestController;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.LunarModule;
import org.academiadecodigo.bootcamp.roothless.lunarModule.service.GameLoop;
import org.academiadecodigo.bootcamp.roothless.lunarModule.service.Service;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by codecadet on 31/03/2017.
 */
public class Test extends Application {

    String name = "localhost";
    int port = 9999;

    Socket houstonSocket = null;

    private DynSpaceShip dynSpaceShip = new DynSpaceShip();
    private double xPosition;
    private double yPosition;


    public static void main(String[] args) {


        launch(args);


    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Navigation navigation = Navigation.getInstance();
        navigation.setStage(primaryStage);
        navigation.loadScreen("Landingpage2");
        //navigation.loadScreen("Landingpage2");

       /* try {
            LunarModule lunarModule = new LunarModule("localhost", 9999);


            houstonSocket = new Socket(name, port);

            LunarListener sender = new LunarListener(houstonSocket);
            LunarSender listener = new LunarSender(houstonSocket);

            Thread senderThread = new Thread(sender);
            Thread Listenerthread = new Thread(listener);

            senderThread.start();
            Listenerthread.start();
            lunarModule.start();


        } catch (IOException e) {

            e.printStackTrace();
        }*/


        //  Parent root = FXMLLoader.load(getClass().getResource("/view/Untitled.fxml"));


        System.out.println("----------------------------------------");

        GameLoop gameLoop = new GameLoop();
        Service service = new Service();
        service.setDynSpaceShip(dynSpaceShip);
        dynSpaceShip.start(gameLoop);
        gameLoop.setDynSpaceShip(dynSpaceShip);
        TestController controller = (TestController) navigation.getController("Landingpage2");
        controller.setDynSpaceShip(dynSpaceShip);

        LunarModule lunarModule = new LunarModule("localhost", 8080, service);
        lunarModule.start();

        controller.setLunarModule(lunarModule);


      /*  service.thrustUp(200);*/

      /*  Image image = new Image("LuaMax.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        imageView.setFitWidth(1000);
        imageView.setPreserveRatio(true);
        imageView.setCache(true);

       Pane pane = new Pane();
        Scene scene = new Scene(root, 1024, 728);
       pane.getChildren().add(imageView);

        primaryStage.setTitle("Major Tom");
        primaryStage.setWidth(900);
        primaryStage.setHeight(400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();

        primaryStage.show();
        moveView(imageView);*/


    }



    private int random(int i) {
        return new Random().nextInt((30 - 10) + 10);
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxPosition() {
        return xPosition;
    }

    public double getyPosition() {
        return yPosition;
    }


}
