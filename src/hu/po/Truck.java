package hu.po;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Truck {
    static int racerNumber;
    String name;
    int normalSpeed;
    int distanceTraveled;

    // The constructor
    Truck() {
        this.name = String.valueOf(Main.getRandom(0, 1000));
        this.normalSpeed = 100;
        this.distanceTraveled = 0;
    }


    void setSpeedLimit(boolean isRaining, int speedLimit ) {
        if (isRaining) {
            normalSpeed = 80;
        } else {
            normalSpeed = 100;
        }
    }



    void moveForAnHour () {
        distanceTraveled += normalSpeed;
    }





}
