package org.academiadecodigo.bootcamp.roothless.lunarModule.service;

import org.academiadecodigo.bootcamp.roothless.lunarModule.model.DynSpaceShip;

/**
 * Created by codecadet on 30/03/2017.
 */
public class GameLoop implements Runnable {

    private DynSpaceShip dynSpaceShip;

    public GameLoop() {

    }

    public void run() {
        while (true) {

            System.out.println("------>dentro do while");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dentro do while loop a imprimir o tempo" + System.nanoTime());

            dynSpaceShip.setCountThrustUp(dynSpaceShip.getCountThrustUp() + 1);
            dynSpaceShip.setCountThrustHor(dynSpaceShip.getCountThrustHor() + 1);

            System.out.println("COUNTER UP ---->" + dynSpaceShip.getCountThrustUp());

            System.out.println("COUNTER HORIZONTAL ----> " + dynSpaceShip.getCountThrustHor());

            if (dynSpaceShip.getCountThrustUp() >= 10) {
                dynSpaceShip.setThrustUpValue(0);

            }

            if (dynSpaceShip.getCountThrustHor() >= 10) {
                dynSpaceShip.setThrustHorizontal(0);
            }

            dynSpaceShip.update();

        }

    }


    public void setDynSpaceShip(DynSpaceShip dynSpaceShip) {
        this.dynSpaceShip = dynSpaceShip;
    }
}
