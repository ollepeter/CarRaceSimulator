

package hu.po;


import java.util.Random;

public class Main {
    public static boolean isRaining = false;

    public static void main(String[] args) {


        System.out.println("This is the main method\n");

        createVehicle();
        simulateRace();
        printRaceResult();
    }



    private static void createVehicle() {
        System.out.println("This is createVehicle\n");

    }



    private static void simulateRace() {
        System.out.println("This is simulateRace");
        isRaining = getRandom(0, 100) <= 30; // "30" is the predefined probability"
        System.out.println("Is raining -> " + isRaining + "\n");
    }



    private static void printRaceResult() {
        System.out.println("This is printRaceResult\n");
    }


    public static int getRandom(int low, int high) {
        int randNum;
        Random rand = new Random();
        randNum = rand.nextInt((high + 1) - low) + low;
        return randNum;
    }

}






