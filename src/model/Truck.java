package model;

import java.util.Map;

public class Truck extends AbstractVehicle{



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
        if(theTerrain.equals(Terrain.STREET) || theTerrain.equals(Terrain.LIGHT) || theTerrain.equals(Terrain.CROSSWALK)) {
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
        System.out.println(theNeighbors.values());
        return null;
    }

    /**
     * Called when this Vehicle collides with the specified other Vehicle.
     *
     * @param theOther The other object.
     */
    @Override
    public void collide(Vehicle theOther) {

    }

    /**
     * Returns the number of updates between this vehicle's death and when it
     * should be revived.
     *
     * @return the number of updates.
     */
    @Override
    public int getDeathTime() {
        return 0;
    }

    /**
     * Returns the file name of the image for this Vehicle object, such as
     * "car.gif".
     *
     * @return the file name.
     */
    @Override
    public String getImageFileName() {
        return null;
    }

    /**
     * Returns this Vehicle object's direction.
     *
     * @return the direction.
     */
    @Override
    public Direction getDirection() {
        return this.myDirection;
    }

    /**
     * Returns this Vehicle object's x-coordinate.
     *
     * @return the x-coordinate.
     */
    @Override
    public int getX() {
        return this.myX;
    }

    /**
     * Returns this Vehicle object's y-coordinate.
     *
     * @return the y-coordinate.
     */
    @Override
    public int getY() {
        return this.myY;
    }

    /**
     * Returns whether this Vehicle object is alive and should move on the map.
     *
     * @return true if the object is alive, false otherwise.
     */
    @Override
    public boolean isAlive() {
        return this.alive;
    }

    /**
     * Called by the UI to notify a dead vehicle that 1 movement round has
     * passed, so that it will become 1 move closer to revival.
     */
    @Override
    public void poke() {
        this.myRevivalTime--;

    }

    /**
     * Moves this vehicle back to its original position.
     */
    @Override
    public void reset() {
        this.setX(0);
        this.setY(0);

    }

    /**
     * Sets this object's facing direction to the given value.
     *
     * @param theDir The new direction.
     */
    @Override
    public void setDirection(Direction theDir) {
        this.myDirection = theDir;

    }

    /**
     * Sets this object's x-coordinate to the given value.
     *
     * @param theX The new x-coordinate.
     */
    @Override
    public void setX(int theX) {
        this.myX = theX;
    }

    /**
     * Sets this object's y-coordinate to the given value.
     *
     * @param theY The new y-coordinate.
     */
    @Override
    public void setY(int theY) {
        this.myY = theY;

    }
}
