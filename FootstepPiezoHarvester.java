import java.util.Random;
import java.util.Scanner;

public class FootstepPiezoHarvester {
    private static final int MAX_ENERGY = 100;
    private static final int ENERGY_PER_STEP_MIN = 3;
    private static final int ENERGY_PER_STEP_MAX = 7;

    private static int energyStored = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Footstep Piezoelectric Energy Harvesting Simulation");
        System.out.println("--------------------------------------------------");

        while (energyStored < MAX_ENERGY) {
            System.out.print("Press Enter to simulate a footstep...");
            scanner.nextLine();

            int energyFromStep = ENERGY_PER_STEP_MIN + random.nextInt(ENERGY_PER_STEP_MAX - ENERGY_PER_STEP_MIN + 1);
            energyStored += energyFromStep;

            System.out.println("Energy generated from step: " + energyFromStep + " units");
            System.out.println("Total energy stored: " + energyStored + "/" + MAX_ENERGY + " units");

            if (energyStored >= MAX_ENERGY) {
                System.out.println("Battery full! You can now use the stored energy.");
                break;
            } else if (energyStored >= 75) {
                System.out.println("Sufficient energy harvested. You can power small devices.\n");
            } else {
                System.out.println("Keep walking to harvest more energy!\n");
            }
        }

        scanner.close();
        System.out.println("Simulation complete.");
    }
}