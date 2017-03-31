package org.academiadecodigo.bootcamp.roothless.lunarModule.model.utils;

/**
 * Created by codecadet on 30/03/17.
 */
public enum Planet {
    MOON(1.62),
    MARS(3.73),
    EARTH(9.8);


    Planet(double acceleration) {
        this.acceleration = acceleration;

    }

    private double acceleration;

    public double getAcceleration() {
        return acceleration;
    }

}
