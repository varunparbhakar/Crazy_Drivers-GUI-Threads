package model;

import java.util.ArrayList;
import java.util.Map;

public class Human extends AbstractVehicle{


    public Human(int myX, int myY, Direction myDir ) {
        super(myX, myY, myDir);
        imageLocation = "human.gif";
        straightDriver = 35;

    }


    /**
     * Returns whether this object may move onto the given type of
     * terrain, when the streetlights are the given color.
     *
     * @param theTerrain The terrain.
     * @param theLight   The light color.
     * @return whether this object may move onto the given type of
     * terrain when the streetlights are the given color.
     */
    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if(theTerrain.equals(Terrain.GRASS) || theTerrain.equals(Terrain.CROSSWALK) || theTerrain.equals(Terrain.TRAIL)) {
            if((theTerrain.equals(Terrain.CROSSWALK) && !theLight.equals(Light.RED))) {
                return false;
            }
            return true;
            }

        return false;

    }

    /**
     * Returns the direction this object would like to move, based on the given
     * map of the neighboring terrain.
     *
     * @param theNeighbors The map of neighboring terrain.
     * @return the direction this object would like to move.
     */
    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        Direction myHeadingDirection = myDirection;
        Terrain myTerrain;
        ArrayList<Direction> possibleDirections = new ArrayList<>();
        ArrayList<Direction> possibleTrails = new ArrayList<>();


        //North
        myTerrain = theNeighbors.get(Direction.NORTH);
        if (myTerrain.equals(Terrain.CROSSWALK) || myTerrain.equals(Terrain.TRAIL) || myTerrain.equals(Terrain.GRASS)) {
            possibleDirections.add(Direction.NORTH);
            if (myTerrain.equals(Terrain.CROSSWALK)) {
                possibleTrails.add(Direction.NORTH);
            }

        }
        //East
        myTerrain = theNeighbors.get(Direction.EAST);
        if (myTerrain.equals(Terrain.CROSSWALK) || myTerrain.equals(Terrain.TRAIL) || myTerrain.equals(Terrain.GRASS)) {
            possibleDirections.add(Direction.EAST);
            if (myTerrain.equals(Terrain.CROSSWALK)) {
                possibleTrails.add(Direction.EAST);
            }

        }
        //South
        myTerrain = theNeighbors.get(Direction.SOUTH);
        if (myTerrain.equals(Terrain.CROSSWALK) || myTerrain.equals(Terrain.TRAIL) || myTerrain.equals(Terrain.GRASS)) {
            possibleDirections.add(Direction.SOUTH);
            if (myTerrain.equals(Terrain.CROSSWALK)) {
                possibleTrails.add(Direction.SOUTH);
            }

        }
        //West
        myTerrain = theNeighbors.get(Direction.WEST);
        if (myTerrain.equals(Terrain.CROSSWALK) || myTerrain.equals(Terrain.TRAIL) || myTerrain.equals(Terrain.GRASS)) {
            possibleDirections.add(Direction.WEST);
            if (myTerrain.equals(Terrain.CROSSWALK)) {
                possibleTrails.add(Direction.WEST);
            }

        }
        int randomDirection = this.myRandom.nextInt(possibleDirections.size());
        if (possibleDirections.contains(myDirection)) {
            if (possibleTrails.size() >= 1) {
                if (possibleTrails.get(0).equals(myDirection.reverse())) {
                    return possibleDirections.get(randomDirection);
                } else {
                    return possibleTrails.get(0);
                }
            } else {
                return possibleDirections.get(randomDirection);
            }
        } else {
            if (myRandom.nextInt(10) >= 5) {
                if (canPass(theNeighbors.get(myDirection.left()), Light.GREEN)) {
                    myHeadingDirection = myDirection.left();
                }
                return myHeadingDirection;
            } else {
                if (canPass(theNeighbors.get(myDirection.right()), Light.GREEN)) {
                    myHeadingDirection = myDirection.right();
                }
                return myHeadingDirection;

            }
        }
    }

    /**
     * Called when this Vehicle collides with the specified other Vehicle.
     *
     * @param theOther The other object.
     */
    @Override
    public void collide(Vehicle theOther) {
        if (theOther.isAlive()) {
            imageLocation = "human_dead.gif";
            myRevivalTime = 10;
            alive = false;
        }
    }

    /**
     * Returns the number of updates between this vehicle's death and when it
     * should be revived.
     *
     * @return the number of updates.
     */
    @Override
    public int getDeathTime() {
        return myRevivalTime;
    }

    /**
     * Returns the file name of the image for this Vehicle object, such as
     * "car.gif".
     *
     * @return the file name.
     */
    @Override
    public String getImageFileName() {
        return imageLocation;
    }

    /**
     * Returns this Vehicle object's direction.
     *
     * @return the direction.
     */
    @Override
    public Direction getDirection() {
        return myDirection;
    }

    /**
     * Returns this Vehicle object's x-coordinate.
     *
     * @return the x-coordinate.
     */
    @Override
    public int getX() {
        return myCurrentLocationX;
    }

    /**
     * Returns this Vehicle object's y-coordinate.
     *
     * @return the y-coordinate.
     */
    @Override
    public int getY() {
        return myCurrentLocationY;
    }

    /**
     * Returns whether this Vehicle object is alive and should move on the map.
     *
     * @return true if the object is alive, false otherwise.
     */
    @Override
    public boolean isAlive() {
        return alive;
    }

    /**
     * Called by the UI to notify a dead vehicle that 1 movement round has
     * passed, so that it will become 1 move closer to revival.
     */
    @Override
    public void poke() {
        if (myRevivalTime == 0 && !isAlive()) {
            imageLocation = "human.gif";
            alive = true;
        }
        myRevivalTime--;

    }

    /**
     * Moves this vehicle back to its original position.
     */
    @Override
    public void reset() {
        resetLocation();

    }

    /**
     * Sets this object's facing direction to the given value.
     *
     * @param theDir The new direction.
     */
    @Override
    public void setDirection(Direction theDir) {
        myDirection = theDir;

    }

    /**
     * Sets this object's x-coordinate to the given value.
     *
     * @param theX The new x-coordinate.
     */
    @Override
    public void setX(int theX) {
        myCurrentLocationX = theX;
    }

    /**
     * Sets this object's y-coordinate to the given value.
     *
     * @param theY The new y-coordinate.
     */
    @Override
    public void setY(int theY) {
        myCurrentLocationY = theY;

    }
}
