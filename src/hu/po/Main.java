

package hu.po;


import java.util.ArrayList;
import java.util.Random;


public class Main {
    static final int NUMRACERS = 1;
    private static final int RACELENGTH = 100;
    private static final int SPEEDLIMIT = 70;

    private static Car[] listOfCars;
    private static Motorcycle[] listOfMotorcycles;
    private static Truck[] listOfTrucks;

    private static ArrayList<ArrayList<String>> resultList = new ArrayList<>();


    public static void main(String[] args) {
        createVehicle(NUMRACERS);
        simulateRace();
        printRaceResult();
    }


    /** Create vehicles */
    private static void createVehicle(int NUMRACERS) {
        listOfCars = new Car[NUMRACERS];
        listOfMotorcycles = new Motorcycle[NUMRACERS];
        listOfTrucks = new Truck[NUMRACERS];
        for (int i = 0; i < NUMRACERS; i++) {
            listOfCars[i] = new Car();
            Car.racerNumber++;
            listOfMotorcycles[i] = new Motorcycle();
            Motorcycle.nameNumber++;
            listOfTrucks[i] = new Truck();
            Truck.racerNumber++;
        }
    }



    private static void simulateRace() {
        for (int hour = 1; hour <= RACELENGTH; hour++) {
            boolean isRaining = getRandom(0, 100) <= 30; // "30" is the predefined probability"

            for (Car car : listOfCars) {
                car.setSpeedLimit(isRaining, SPEEDLIMIT);
                car.moveForAnHour();
            }

            for (Motorcycle motorcycle : listOfMotorcycles) {
                motorcycle.setSpeed(isRaining);
                motorcycle.moveForAnHour();
            }

            for (Truck truck : listOfTrucks) {
                truck.setSpeed();
                truck.moveForAnHour();
            }
            printActualRaceResult(hour, isRaining);
            System.out.println();
        }

    }


    private static void printActualRaceResult(int hour, boolean isRaining) {
        String roadCondition;
        String carSpeedLimit;
        String motorcycleSpeedLimit;
        System.out.printf("Hours: %s \n", hour);
        if (isRaining) {
            roadCondition = "WET";
            carSpeedLimit = "70 km/h";
            motorcycleSpeedLimit = "Reduced speed by 5-50 km/h";
        } else {
            roadCondition = "DRY";
            carSpeedLimit = motorcycleSpeedLimit = "NO Limit";
        }
        System.out.printf("Road condition          -> %s \n", roadCondition);
        System.out.printf("CARs Speed limit        -> %s \n", carSpeedLimit);
        System.out.printf("MOTORCYCLEs Speed limit -> %s \n\n", motorcycleSpeedLimit);
        System.out.println("CARS:");
        for (Car car : listOfCars) {
            System.out.printf("%-22s %3d %-8s %4d %-2s\n",
                    car.name,
                    car.normalSpeed,
                    "km/h",
                    car.distanceTraveled,
                    "km");
        }
        System.out.println();

        System.out.println("MOTORCYCLES:");
        for (Motorcycle motorcycle : listOfMotorcycles) {
            System.out.printf("%-22s %3d %-8s %4d %-2s\n",
                    motorcycle.name,
                    motorcycle.speed,
                    "km/h",
                    motorcycle.distanceTraveled,
                    "km");
        }
        System.out.println();

        System.out.println("TRUCKS:");
        for (Truck truck : listOfTrucks) {
            System.out.printf("%-22s %3d %-8s %4d %-2s\n",
                    truck.name,
                    truck.normalSpeed,
                    "km/h",
                    truck.distanceTraveled,
                    "km");
        }
        System.out.println();
    }


    private static void printRaceResult() {
        System.out.println("!!! END OF RACE !!!\n");

        for (Car car : listOfCars) {
            ArrayList<String> vehicleProperties = new ArrayList<>();
            vehicleProperties.add(String.valueOf(car.distanceTraveled));
            vehicleProperties.add(car.name);
            vehicleProperties.add("CAR");
            resultList.add(vehicleProperties);
        }
        for (Motorcycle motorcycle : listOfMotorcycles) {
            ArrayList<String> motorcycleProperties = new ArrayList<>();
            motorcycleProperties.add(String.valueOf(motorcycle.distanceTraveled));
            motorcycleProperties.add(motorcycle.name);
            motorcycleProperties.add("MOTORCYCLE");
            resultList.add(motorcycleProperties);
        }
        for (Truck truck : listOfTrucks) {
            ArrayList<String> truckProperties = new ArrayList<>();
            truckProperties.add(String.valueOf(truck.distanceTraveled));
            truckProperties.add(truck.name);
            truckProperties.add("TRUCK");
            resultList.add(truckProperties);
        }
        resultList = bubbleSort(resultList); //Sort result list

        System.out.println("OVERALL RESULTS\n");
        System.out.printf("%-5s %-25s %-10s %-8s", "Pos.", "Name", "Distance", "Vehicle\n");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < resultList.size(); i++) {
            System.out.printf("%-5d %-25s %-10s %-10s\n", i + 1, resultList.get(i).get(1), resultList.get(i).get(0) + " km", resultList.get(i).get(2));
            if (i == 2) {
                System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -");
            }
        }
    }


    /**Get a random integer in the given range*/
    static int getRandom(int low, int high) {
        int randNum;
        Random rand = new Random();
        randNum = rand.nextInt((high + 1) - low) + low;
        return randNum;
    }


    /**Bubble reversed sort List*/
    private static ArrayList<ArrayList<String>> bubbleSort (ArrayList<ArrayList<String>> resultList) {
        for (int i = 0; i < resultList.size() - 1; i++) {
            for (int k = i + 1; k < resultList.size(); k++) {
                if (Integer.parseInt(resultList.get(i).get(0)) < (Integer.parseInt(resultList.get(k).get(0)))) {
                    ArrayList<String> temp = resultList.get(i);
                    resultList.set(i, resultList.get(k));
                    resultList.set(k, temp);
                }
            }
        }
        return resultList;
    }
}







