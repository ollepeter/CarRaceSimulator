package hu.po;


class Truck {
    static int racerNumber;
    String name;
    int normalSpeed;
    private int breakdownTurnsLeft;
    int distanceTraveled;
    private boolean isBreakDown = false;

    // The constructor
    Truck() {
        this.name = String.valueOf(Main.getRandom(0, 1000));
        this.normalSpeed = 100;
        this.distanceTraveled = 0;
        this.isBreakDown = false;
    }


    void setSpeed() {
        int breakdownSpeed = 0;
        if (breakdownTurnsLeft == 1) {
                normalSpeed = breakdownSpeed;
                breakdownTurnsLeft--;
        } else {
            isBreakDown = Main.getRandom(0, 100) <= 5; // "5" is the predefined probability"
            if (isBreakDown) {
                normalSpeed = breakdownSpeed;
                breakdownTurnsLeft = 1;
            } else {
                normalSpeed = 100;
                breakdownTurnsLeft = 0;
            }
        }
    }


    // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
    void moveForAnHour () {
        distanceTraveled += normalSpeed;
    }





}
