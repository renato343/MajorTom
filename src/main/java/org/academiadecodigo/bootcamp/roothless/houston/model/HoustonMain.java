package org.academiadecodigo.bootcamp.roothless.houston.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.roothless.houston.controller.HoustonController;
import org.academiadecodigo.bootcamp.roothless.houston.sound.Sound;

import java.io.IOException;

/**
 * Created by codecadet on 31/03/17.
 */
public class HoustonMain extends Application {

    private Stage stage;

    public void loadScreen() {

        try {

            FXMLLoader fxmlLoader;

            fxmlLoader = new FXMLLoader(getClass().getResource("/view/HoustonView.fxml"));


            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            setScene(scene);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setScene(Scene scene) {

        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public void start(Stage primaryStage) throws Exception {

        this.stage = primaryStage;
        loadScreen();

        Sound backSOund = new Sound(" major.wav");

        backSOund.play();

    }


    public static void main(String[] args) {
        launch(args);

    }
}
