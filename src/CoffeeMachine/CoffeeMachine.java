import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;

        int maxCupsWater = availableWater / waterPerCup;
        int maxCupsMilk = availableMilk / milkPerCup;
        int maxCupsCoffeeBeans = availableCoffeeBeans / coffeeBeansPerCup;

        int maxCups = Math.min(Math.min(maxCupsWater, maxCupsMilk), maxCupsCoffeeBeans);

        if (maxCups >= cupsNeeded) {
            if (maxCups > cupsNeeded) {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cupsNeeded) + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }
}


