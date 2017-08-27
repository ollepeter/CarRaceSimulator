package hu.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Car {
    private static final String[] CARNAMES = {"Dragon", "Dawn", "Silver", "Vagabond", "Tigress",
                                      "Quicksilver", "Centurion", "Desire", "Eos", "Intro",
                                      "Whirlpool", "Harmony", "Bliss", "Viper", "Pulse",
                                      "Mystery", "Legacy", "Astral", "Flux", "Scorpion"};
    static int racerNumber;
    String name;
    int normalSpeed;
    int distanceTraveled;
    private static List<String> uniqueCarNames = new ArrayList<>(getUniqueCarNames(Main.NUMRACERS));

    // The constructor
    Car() {
        this.name = uniqueCarNames.get(racerNumber);
        this.normalSpeed = Main.getRandom(80, 110);
        this.distanceTraveled = 0;
    }


    void setSpeedLimit(boolean isRaining, int speedLimit) {
        if (isRaining) {
            normalSpeed = speedLimit;
        } else {
            normalSpeed = Main.getRandom(80, 110);
        }
    }

    // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
    void moveForAnHour () {
        distanceTraveled += normalSpeed;
    }


    // Get a list with unique names for Cars
    private static List<String> getUniqueCarNames(int size) {
        String fullCarName;
        int index1;
        int index2;
        Set<String> uniqueCarNamesSet = new HashSet<>();
        List<String> uniqueCarNames;

        while (uniqueCarNamesSet.size() < size) {
            index1 = Main.getRandom(0, (CARNAMES.length - 1));
            index2 = Main.getRandom(1, (CARNAMES.length - 1));
            index2 = index1 != index2 ? index2 : (index2 - 1);
            fullCarName = CARNAMES[index1] + " " + CARNAMES[index2];
            uniqueCarNamesSet.add(fullCarName); // Ensure uniqueness
        }
        uniqueCarNames = new ArrayList<>(uniqueCarNamesSet); //Cast the Set to List
        return uniqueCarNames;
    }











}
