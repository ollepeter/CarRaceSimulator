

package hu.po;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static final String[] CARNAMES = {"Dragon",
                                             "Dawn",
                                             "Silver",
                                             "Vagabond",
                                             "Tigress",
                                             "Quicksilver",
                                             "Centurion",
                                             "Desire",
                                             "Eos",
                                             "Intro",
                                            };

    public static final int NUMRACERS = 10;
    public static final int RACELENGTH = 50;

    public static boolean isRaining = false;


    public static void main(String[] args) {


        System.out.println("This is the main method\n");

        createVehicle();
        simulateRace();
        printRaceResult();

        System.out.println("The picked TruckNames are: \n" + getUniqueTruckNames(10, 1, 20));
        System.out.println("The picked CarNames are: \n" + getUniqueCarNames(10));
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


    public static Set<Integer> getUniqueTruckNames(int size, int low, int high) {
        Set<Integer> uniqueTruckNames = new HashSet<>();
        while (uniqueTruckNames.size() < size) {
            uniqueTruckNames.add(getRandom(low, high));
        }
        return uniqueTruckNames;
    }


    public static Set<String> getUniqueCarNames(int size) {
        Set<String> uniqueCarNames = new HashSet<>();
        int index1;
        int index2;
        String fullCarName;

        while (uniqueCarNames.size() < size) {
            index1 = getRandom(0, (CARNAMES.length - 1));
            // minVal = (a < b) ? a : b;
            index2 = getRandom(1, (CARNAMES.length - 1));
            index2 = index1 != index2 ? index2 : (index2 - 1);
            System.out.println("Index1: " + index1);
            System.out.println("Index1: " + index2);
            fullCarName = CARNAMES[index1] + " " + CARNAMES[index2];
            uniqueCarNames.add(fullCarName);
            // System.out.println("Index: " + (possibleNames.length -1));
        }
        return uniqueCarNames;
    }


}






