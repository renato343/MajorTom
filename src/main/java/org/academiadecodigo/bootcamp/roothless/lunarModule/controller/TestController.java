package org.academiadecodigo.bootcamp.roothless.lunarModule.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.academiadecodigo.bootcamp.roothless.Navigation;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.LunarModule;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by codecadet on 31/03/2017.
 */

public class TestController implements Initializable {

    private DynSpaceShip dynSpaceShip;
    private Navigation navigation;
    private String message;

    private LunarModule lunarModule;

    /*  @FXML
      private ResourceBundle resources;

      @FXML
      private URL location;

      @FXML
      private ImageView lua;

      @FXML
      private ImageView back;

      @FXML
      private ProgressBar posVerProgressBar;

      @FXML
      private Label velHorValueLabel;

      @FXML
      private Label velVertValueLabel;

      @FXML
      private TextArea consoleTextArea;

      @FXML
      private Button send;

      @FXML
      private Label timeLabel;

      @FXML
      private Label scoreValueLabel;

      @FXML
      private ProgressBar posHorProgressBar;

      @FXML
      private Label posHorValueLabel;

      @FXML
      private ProgressBar fuelProgressBar;

      @FXML
      private Label fuelValueLabel;

      @FXML
      private Label posVerValueLabel;


  */
/*
    @FXML
    private ImageView lua;
    @FXML
    private Label scoreValueLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label velHorValueLabel;

    @FXML
    private Label velVertValueLabel;

    @FXML
    private Button sendtoHouston;

    @FXML
    private ProgressBar posVerProgressBar;

    @FXML
    private Label posVertValueLabel;

    @FXML
    private ProgressBar posHorProgressBar;

    @FXML
    private Label posHorValueLabel;

    @FXML
    private ProgressBar fuelProgressBar;

    @FXML
    private ImageView exo;

    @FXML
    private Label fuelValueLabel;

    @FXML
    private Label youLost;

    @FXML
    private Label youWon;

    @FXML
    private TextField consoleTextField;

    @FXML
    private ImageView hansSolo;

    @FXML
    private ImageView spock;





*/


    @FXML
    private ImageView lua;

    @FXML
    private ImageView back;

    @FXML
    private ProgressBar posVerProgressBar;

    @FXML
    private Label velHorValueLabel;

    @FXML
    private Label velVertValueLabel;

    @FXML
    private TextArea consoleTextArea;

    @FXML
    private Button send;

    @FXML
    private ProgressBar posHorProgressBar;

    @FXML
    private Label posVerValueLabel;

    @FXML
    private Label youLost;

    @FXML
    private ImageView exo;

    @FXML
    private ImageView hansSolo;

    @FXML
    private ImageView spock;

    @FXML
    private Label posHorValueLevel;

    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        spock.setVisible(false);
        hansSolo.setVisible(false);
        exo.setVisible(false);
        youLost.setVisible(false);


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

            if (dynSpaceShip.isGameOverCrash()) {
                youLost.setText("YOU CRASHED!!!!");
                youLost.setVisible(true);
                return;

            }

            if (dynSpaceShip.isGameOverSpace()) {
                youLost.setText("YOU ARE LOST IN SPACE!");
                youLost.setVisible(true);
                return;

            }

            if (dynSpaceShip.isWinGame()) {
                youLost.setText("YOU HAVE TOUCHED THE GROUND SAFE AND SOUND");
                youLost.setVisible(true);
                return;

            }
            exo.setVisible(false);

            if (randomStuff() < 0.05) {
                exo.setVisible(true);
            }
            hansSolo.setVisible(false);
            if (randomStuff() > 0.95) {
                hansSolo.setVisible(true);
            }

            spock.setVisible(false);
            if (randomStuff() >= 0.35 && randomStuff() <= 0.4) {
                spock.setVisible(true);
            }

            System.out.println("atualizando");

            System.out.println("X POSITION AT MAIN " + dynSpaceShip.getxPosition());
            System.out.println("Y POSITION AT MAIN " + dynSpaceShip.getyPosition());


            imageView.setViewport(new Rectangle2D(1950 + (dynSpaceShip.getxPosition()), 1200 + (dynSpaceShip.getyPosition()), 1024, 768));

            velHorValueLabel.setText(Double.toString(dynSpaceShip.getxVelocity()));
            velVertValueLabel.setText(Double.toString(dynSpaceShip.getyVelocity()));

            posHorValueLevel.setText(Double.toString(dynSpaceShip.getxPosition()));
            posVerValueLabel.setText(Double.toString(dynSpaceShip.getyPosition()));

            posVerProgressBar.setProgress(dynSpaceShip.getyPosition() / 180);
            posHorProgressBar.setProgress(Math.abs(dynSpaceShip.getxPosition() / 300));


        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void setDynSpaceShip(DynSpaceShip dynSpaceShip) {
        this.dynSpaceShip = dynSpaceShip;
    }

    public void sendButton() {
        System.out.println("------------------------------------------------------------------------------------------>entrei no send button no testcontrolle");
        message = consoleTextArea.getText();
        lunarModule.sendCommand(message);
        consoleTextArea.setText("");


    }

    public String getMessage() {
        return message;
    }

    public void setLunarModule(LunarModule lunarModule) {
        this.lunarModule = lunarModule;
    }


    public double randomStuff() {
        return Math.random();
    }
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



