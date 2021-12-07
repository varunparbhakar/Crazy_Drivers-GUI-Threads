package model;


public class tester {
    public static void main(String[] args) {
        Vehicle myTruck = new Truck();
        System.out.println(myTruck.getDirection());
        Terrain terrain = Terrain.WALL;
        Light theLight = Light.GREEN;
        System.out.println(myTruck.canPass(terrain, theLight));

    }
}
