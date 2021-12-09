package model;


import java.util.ArrayList;
import java.util.Random;

public class tester {
    public static void main(String[] args) {
        Random random = new Random();
//        Vehicle myTruck = new Truck();
//        System.out.println(myTruck.getDirection());
//        Terrain terrain = Terrain.WALL;
//        Light theLight = Light.GREEN;
//        System.out.println(myTruck.canPass(terrain, theLight));
        ArrayList<Direction> possibleDirections = new ArrayList<>();
        possibleDirections.add(Direction.NORTH);
        possibleDirections.add(Direction.EAST);
        possibleDirections.add(Direction.WEST);

        System.out.println("Size of the array: " + possibleDirections.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(possibleDirections.size()));
        }
        System.out.println();

    }
}
