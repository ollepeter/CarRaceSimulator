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
        speed = 100;
        if (isRaining) {
            speed -= Main.getRandom(5, 50);
        }
    }

    // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!
    void moveForAnHour () {
        distanceTraveled += speed;
    }
}
