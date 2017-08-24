

package hu.po;


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
        isRaining = (int)(Math.random()*100) <= 30; // "30" is the predefined probability"
        System.out.println("Is raining -> " + isRaining + "\n");
    }



    private static void printRaceResult() {
        System.out.println("This is printRaceResult\n");
    }


}






