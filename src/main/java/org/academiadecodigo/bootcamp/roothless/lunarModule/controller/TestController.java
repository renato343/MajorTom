package org.academiadecodigo.bootcamp.roothless.lunarModule.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.academiadecodigo.bootcamp.roothless.Navigation;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 31/03/2017.
 */

public class TestController implements Initializable {

    private DynSpaceShip dynSpaceShip;
    private Navigation navigation;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea consoleTextArea;

    @FXML
    private ProgressBar fuelProgressBar;

    @FXML
    private ProgressBar posVerProgressBar;

    @FXML
    private ProgressBar posHorProgressBar;

    @FXML
    private Label velHorValueLabel;

    @FXML
    private Label velVertValueLabel;

    @FXML
    private Label posVertValueLabel;

    @FXML
    private Label fuelValueLabel;

    @FXML
    private Label posHorValueLabel;

    @FXML
    private Label scoreValueLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView image;

    @FXML
    private ImageView lua;


    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //navigation.loadScreen("Landingpage");

//        Image imageLoad = new Image("LuaMax.jpg");
        //      image.setImage(imageLoad);

//        moveView(image);


        System.out.println("CONTROLLER!!!!!!");
        moveView(lua);
    }

  /*  public void init() {
        moveView(lua, "up");
    }*/

    private void moveView(ImageView imageView) {

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(100), ev -> {
            System.out.println("atualizando");

            System.out.println("X POSITION AT MAIN " + dynSpaceShip.getxPosition());
            System.out.println("Y POSITION AT MAIN " + dynSpaceShip.getyPosition());


            imageView.setViewport(new Rectangle2D(1950 + dynSpaceShip.getxPosition() , 1200 + dynSpaceShip.getyPosition() , 1024, 768));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setDynSpaceShip(DynSpaceShip dynSpaceShip) {
        this.dynSpaceShip = dynSpaceShip;
    }

 /*   public void up(ActionEvent actionEvent) {
        moveView(lua);
    }

    public void right(ActionEvent actionEvent) {
        moveView(lua, "right");
    }

    public void left(ActionEvent actionEvent) {
        moveView(lua, "left");
    }*/

}

