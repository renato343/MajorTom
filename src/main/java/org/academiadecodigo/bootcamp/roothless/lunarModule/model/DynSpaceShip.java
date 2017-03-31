package org.academiadecodigo.bootcamp.roothless.lunarModule.model;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils.Planet;
import org.academiadecodigo.bootcamp.roothless.lunarModule.service.GameLoop;

/**
 * Created by codecadet on 30/03/17.
 */
public class DynSpaceShip {

    private double xPosition = 100;
    private double yPosition = 100;
    private double xVelocity;
    private double yVelocity;
    private float initialTime;
    private Planet planet = Planet.MOON;
    private double thrustUpValue = 0;
    private double thrustHorizontal = 0;
    private double countThrustUp;
    private double countThrustHor;



    public void update() {

        float nowTime = System.nanoTime();

        System.out.println("NOW TIME " + nowTime + ", INITIAL TIME " + initialTime);

        float elapsedTime = 0.1f;

        System.out.println("ELAPSED TIME: " + elapsedTime);

        initialTime = nowTime;

        double yPosition0 = yPosition;
        double xPosition0 = xPosition;
        double xVelocity0 = xVelocity;
        double yVelocity0 = yVelocity;

        yPosition = yPosition0 + yVelocity0 * elapsedTime + ((planet.getAcceleration() - thrustUpValue) * elapsedTime * elapsedTime) / 2;
        xPosition = xPosition0 + xVelocity0 * elapsedTime + (thrustHorizontal * elapsedTime * elapsedTime) / 2;
        yVelocity = yVelocity0 + (planet.getAcceleration() - thrustUpValue) * elapsedTime;
        xVelocity = xVelocity0 + thrustHorizontal * elapsedTime;

        System.out.println("Y POSITION " + yPosition);
        System.out.println("X POSITION " + xPosition);
        System.out.println("Y VElocity " + yVelocity);
        System.out.println("X velocity " + xVelocity);

    }


    public double getThrustUpValue() {
        return thrustUpValue;
    }

    public void setThrustUpValue(double thrustUpValue) {
        this.thrustUpValue = thrustUpValue;
    }

    public void start(GameLoop gameloop) {
        Thread thread = new Thread(gameloop);
        thread.start();
    }


    public double getxPosition() {
        System.out.println((int) xPosition);
        return (int) xPosition;
    }

    public void setxPosition(double xPosition) {
        this.xPosition = xPosition;
    }

    public double getyPosition() {
        System.out.println((int) yPosition);
        return (int) yPosition;
    }

    public void setyPosition(double yPosition) {
        this.yPosition = yPosition;
    }

    public double getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(double xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public Planet getPlanet() {
        return planet;
    }

    public double getThrustHorizontal() {
        return thrustHorizontal;
    }

    public void setThrustHorizontal(double thrustHorizontal) {
        this.thrustHorizontal = thrustHorizontal;
    }

    public double getCountThrustUp() {
        return countThrustUp;
    }

    public void setCountThrustUp(double countThrustUp) {
        this.countThrustUp = countThrustUp;
    }

    public double getCountThrustHor() {
        return countThrustHor;
    }

    public void setCountThrustHor(double countThrustHor) {
        this.countThrustHor = countThrustHor;
    }
}
