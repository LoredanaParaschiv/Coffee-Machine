package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);

    private int water;
    private int milk;
    private int cofBeans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int cofBeans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.cofBeans = cofBeans;
        this.cups = cups;
        this.money = money;
    }

    public void printState() {
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(cofBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void makeCoffee(CoffeeType type) {
        if (hasEnoughResource(type)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= type.waterNeeded;
            cups -= type.cupsNeeded;
            milk -= type.milkNeeded;
            cofBeans -= type.cofBeansNeeded;
            money += type.cost;
        }
    }

    public boolean hasEnoughResource(CoffeeType type) {
        if (cups < type.cupsNeeded) {
            System.out.println("Sorry, not enough cups!");
            return false;
        }
        if (water < type.waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk < type.milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (cofBeans < type.cofBeansNeeded) {
            System.out.println("Sorry, not enough beans!");
            return false;
        }
        return true;
    }

    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        cofBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();
    }

    public void takeMoney() {
        System.out.println("I gave you " + money + "$");
        money = 0;
    }














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