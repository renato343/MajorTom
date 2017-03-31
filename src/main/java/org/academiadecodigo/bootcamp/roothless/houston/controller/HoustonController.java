
/**
 * Created by codecadet on 31/03/17.
 */
/**
 /**
 * Sample Skeleton for 'HoustonView.fxml' Controller Class
 */

package org.academiadecodigo.bootcamp.roothless.houston.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import org.academiadecodigo.bootcamp.roothless.houston.model.Houston;

public class HoustonController implements Initializable {



    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="upButton"
    private Button upButton; // Value injected by FXMLLoader

    @FXML // fx:id="leftButton"
    private Button leftButton; // Value injected by FXMLLoader

    @FXML // fx:id="rightButton"
    private Button rightButton; // Value injected by FXMLLoader

    @FXML // fx:id="potencyBar"
    private Slider potencyBar; // Value injected by FXMLLoader

    @FXML // fx:id="sendButton"
    private Button sendButton; // Value injected by FXMLLoader

    @FXML
    public TextField consoleHouston;

    private String direction;

    private double thrust;

    private Houston houston = new Houston("localhost", 9999);

    public void setHouston(Houston houston) {
        this.houston = houston;
    }

    public String getDirection() {
        return direction;
    }

    public double getThrust() {
        return thrust;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setThrustPotency(double thrust) {
        this.thrust = thrust;
    }

    @FXML
    public void sendToLunar() {

        System.out.println("estou no sendind message");

        String messageToSend = getDirection() + " " + getThrust();

        System.out.println("sending to houston from controller " + messageToSend);

        houston.sendToLunarModule(messageToSend);
    }

    @FXML
    void setDIrectioUp(ActionEvent event) {
        System.out.println("estou no up");
        setDirection("up");

    }

    @FXML
    void setDIrectionLeft(ActionEvent event) {
        System.out.println("estou no left");
        setDirection("left");
    }

    @FXML
    void setDIrectionRight(ActionEvent event) {
        System.out.println("estou no right");
        setDirection("right");
    }

    @FXML
    void setThrust() {
        System.out.println("estou no thrust");
        //setThrustPotency(potencyBar.getValue());
        setThrustPotency(50);

    }

   public void setConsoleHouston(String messageToConsole){

       System.out.println("enter set console in controller");
        consoleHouston.setText(messageToConsole);

    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("FUNCKING CONTROLLER");

          Thread houstonServer = new Thread(houston);

          houstonServer.start();
          houston.setHoustonController(this);
    }
}
