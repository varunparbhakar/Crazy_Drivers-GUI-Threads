package model;

import java.awt.Image;
import java.util.Map;
import java.util.Random;

abstract class AbstractVehicle implements Vehicle {
    private Image myVehicleImage;
    protected int myX;
    protected int myY;
    protected boolean alive;
    protected Random myRandom = new Random();
    protected Direction myDirection;
    protected int myRevivalTime;
    AbstractVehicle() {
        alive = true;
        myDirection = Direction.random();
        myRevivalTime = 0;

    }


    //////

}