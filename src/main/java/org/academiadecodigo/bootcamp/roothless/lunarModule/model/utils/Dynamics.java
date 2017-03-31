package org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;

/**
 * dd
 * Created by codecadet on 30/03/17.
 */
public class Dynamics {


    private static float initialTime = System.currentTimeMillis();


    public static double yPosition(DynSpaceShip position, double thrust, float elapsedTime) {

        return position.getyPosition() + (position.getyVelocity() * elapsedTime +
                (((position.getPlanet().getAcceleration() - thrust)
                        * elapsedTime * elapsedTime) / 2));

    }

    public static double xPosition(DynSpaceShip position, double thrust, float elapsedTime) {

        return position.getxPosition() + position.getxVelocity() * elapsedTime + (thrust * elapsedTime * elapsedTime) / 2;
    }

    public static double yVelocity(DynSpaceShip velocity, double thrust, float elapsedTime) {

        return velocity.getyVelocity() + (velocity.getPlanet().getAcceleration() - thrust) * elapsedTime;

    }

    public static double xVelocity(DynSpaceShip velocity, double thrust, float elapsedtime) {

        return velocity.getxVelocity() + thrust*elapsedtime;

    }
}
