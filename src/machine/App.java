package machine;

import java.security.cert.CertificateParsingException;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            String action = scanner.next();
            if (action.equals("exit")) break;
            switch (action) {
                case "buy":
                    CoffeeType type = resolveOption();
                    if (type != null) {
                        coffeeMachine.makeCoffee(type);
                    }
                    break;
                case "fill":
                    coffeeMachine.fill();
                    break;
                case "take":
                    coffeeMachine.takeMoney();
                    break;
                case "remaining":
                    coffeeMachine.printState();
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        }
    }

    public static CoffeeType resolveOption() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String option = scanner.next();
        switch (option) {
            case "1":
                return CoffeeType.ESPRESSO;
            case "2":
                return CoffeeType.LATTE;
            case "3":
                return CoffeeType.CAPPUCCINO;
            default:
                System.out.println("Type not found");
                return null;
        }
    }


}
