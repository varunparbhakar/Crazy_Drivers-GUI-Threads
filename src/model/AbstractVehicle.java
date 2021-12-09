package model;

import java.awt.Image;
import java.util.Random;


abstract class AbstractVehicle implements Vehicle {
    protected String imageLocation;
    protected Random myRandom = new Random();
    protected int myCurrentLocationX;
    protected int myCurrentLocationY;
    protected int myDefaultLocationX;
    protected int myDefaultLocationY;
    protected boolean alive;
    protected Direction myDirection;
    protected int myRevivalTime;
    //The higher the number the more straight it drives
    protected int straightDriver;

    AbstractVehicle(int myX, int myY, Direction theDir ) {
        myDefaultLocationX  = myX;
        myDefaultLocationY = myY;
        myCurrentLocationX = myDefaultLocationX;
        myCurrentLocationY = myDefaultLocationY;
        myDirection = theDir;
        alive = true;



    }
    protected void resetLocation(){
        myCurrentLocationX = myDefaultLocationX;
        myCurrentLocationY = myDefaultLocationY;
    }
    protected void crashed() {
        alive = false;
    }
}