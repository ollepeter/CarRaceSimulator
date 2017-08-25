

package hu.po;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {

    private static Car[] listOfCars;
    static final int NUMRACERS = 3;
    private static final int RACELENGTH = 5;

    private static boolean isRaining;


    public static void main(String[] args) {


        System.out.println("This is the main method\n");

        createVehicle(NUMRACERS);
        simulateRace();
        //printRaceResult();

    }


    /** Create vehicles */
    private static void createVehicle(int NUMRACERS) {
        listOfCars = new Car[NUMRACERS];
        for (int i = 0; i < NUMRACERS; i++) {
            listOfCars[i] = new Car();
            Car.racerNumber++;
        }
    }



    private static void simulateRace() {
        //System.out.println("Is raining -> " + isRaining + "\n");
        for (int hour = 1; hour <= RACELENGTH; hour++) {
            isRaining = getRandom(0, 100) <= 30; // "30" is the predefined probability"

            System.out.printf("Hours: %s \n", hour);
            for (Car car : listOfCars) {
                car.setSpeed();
                car.moveForAnHour();


            }
            printRaceResult();
            System.out.println();
        }

    }



    private static void printRaceResult() {
        //System.out.printf("Name: %s -> Distance: %d \n", Car.name, Car.distanceTraveled);
        for (Car vehicle : listOfCars) {

            System.out.printf("Name: %s -> Speed: %d -> Distance: %d \n", vehicle.name,
                    vehicle.normalSpeed,
                    vehicle.distanceTraveled);
        }
    }


    static int getRandom(int low, int high) {
        int randNum;
        Random rand = new Random();
        randNum = rand.nextInt((high + 1) - low) + low;
        return randNum;
    }


    private static Set<Integer> getUniqueTruckNames(int size, int low, int high) {
        Set<Integer> uniqueTruckNames = new HashSet<>();
        while (uniqueTruckNames.size() < size) {
            uniqueTruckNames.add(getRandom(low, high));
        }
        return uniqueTruckNames;
    }





}






