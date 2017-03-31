package org.academiadecodigo.bootcamp.roothless.lunarModule.service;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.Movement;

/**
 * Created by codecadet on 31/03/2017.
 */
public class Service {

    private DynSpaceShip dynSpaceShip;
    private String direction;
    private double thrust;



    public void thrustUp(double power) {
        dynSpaceShip.setThrustUpValue(power/5);
        dynSpaceShip.setCountThrustUp(0);
    }

    public void thrustLeft(double power) {
        dynSpaceShip.setThrustHorizontal((power)*-1);
        dynSpaceShip.setCountThrustHor(0);
    }

    public void thrustRight(double power) {
        dynSpaceShip.setThrustHorizontal(power);
        dynSpaceShip.setCountThrustHor(0);
    }

    public void setDynSpaceShip(DynSpaceShip dynSpaceShip) {
        this.dynSpaceShip = dynSpaceShip;
    }
}
