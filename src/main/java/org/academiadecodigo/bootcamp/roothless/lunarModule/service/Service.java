package org.academiadecodigo.bootcamp.roothless.lunarModule.service;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;
import org.academiadecodigo.bootcamp.roothless.lunarModule.model.Movement;

/**
 * Created by codecadet on 31/03/2017.
 */
public class Service {

    private DynSpaceShip dynSpaceShip;
    private String direction;
    private int thrust;



    public void thrustUp(int power) {
        dynSpaceShip.setThrustUpValue(power/5);
        dynSpaceShip.setCountThrustUp(0);
    }

    public void thrustLeft(int power) {
        dynSpaceShip.setThrustHorizontal(-power);
        dynSpaceShip.setCountThrustHor(0);
    }

    public void thrustRight(int power) {
        dynSpaceShip.setThrustHorizontal(power);
        dynSpaceShip.setCountThrustHor(0);
    }

    public void setDynSpaceShip(DynSpaceShip dynSpaceShip) {
        this.dynSpaceShip = dynSpaceShip;
    }
}
