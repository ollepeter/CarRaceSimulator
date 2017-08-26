package hu.po;


class Motorcycle {
    static int nameNumber;
    String name;
    int speed;
    int distanceTraveled;


    // The constructor
    Motorcycle() {
        this.name = String.format("Motorcycle %d", nameNumber + 1);
        this.speed = 100;
        this.distanceTraveled = 0;
    }


    void setSpeed(boolean isRaining) {
        if (isRaining) {
            speed -= Main.getRandom(5, 50);
        } else {
            speed = 100;
        }
    }


    void moveForAnHour () {
        distanceTraveled += speed;
    }








}
