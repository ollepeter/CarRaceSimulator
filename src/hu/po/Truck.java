package hu.po;


class Truck {
    static int racerNumber;
    String name;
    int normalSpeed;
    private int breakdownTurnsLeft;
    private int breakdownSpeed = 0;
    int distanceTraveled;
    boolean isBreakDown = false;

    // The constructor
    Truck() {
        this.name = String.valueOf(Main.getRandom(0, 1000));
        this.normalSpeed = 100;
        this.distanceTraveled = 0;
        this.isBreakDown = false;
    }


    void setSpeed() {
        switch (breakdownTurnsLeft) {
            case 1:
                normalSpeed = breakdownSpeed;
                breakdownTurnsLeft--;
                break;
            default:
                isBreakDown = Main.getRandom(0, 100) <= 5; // "5" is the predefined probability"
                if (isBreakDown) {
                    normalSpeed = breakdownSpeed;
                    breakdownTurnsLeft = 1;
                } else {
                    normalSpeed = 100;
                    breakdownTurnsLeft = 0;
                }
                break;
        }

    }



    void moveForAnHour () {
        distanceTraveled += normalSpeed;
    }





}
