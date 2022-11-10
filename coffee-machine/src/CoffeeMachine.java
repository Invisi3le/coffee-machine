import java.util.Scanner;

public class CoffeeMachine {
    public enum CoffeeType {
        ESPRESSO, LATTE, CAPPUCCINO, BACK
    }
    private int water, coffee, milk, cups, money;
    public CoffeeMachine() {
        this.water = 400;
        this.coffee = 120;
        this.milk = 540;
        this.cups = 9;
        this.money = 550;
    }

    public static void start(CoffeeMachine machine) {
        machine.menu();
    }

    public void menu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "buy" -> buy();
            case "fill" -> fill();
            case "take" -> take();
            case "remaining" -> remaining();
            case "exit" -> System.exit(0);
            default -> System.out.println("Unknown action");
        }
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        menu();
    }

    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
        menu();
    }

    public void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
        menu();
    }
    public void buy () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy?  Espresso, latte, Cappuccino, Back - to main menu:");
        String coffeeType = scanner.nextLine();
        CoffeeType type = CoffeeType.valueOf(coffeeType.toUpperCase());

            switch (type) {
                case ESPRESSO -> {
                    water -= 250;
                    coffee -= 16;
                    money += 4;
                }
                case LATTE -> {
                    water -= 350;
                    milk -= 75;
                    coffee -= 20;
                    money += 7;
                }
                case CAPPUCCINO -> {
                    water -= 200;
                    milk -= 100;
                    coffee -= 12;
                    money += 6;
                }
                case BACK -> menu();
            }
            cups--;
            menu();
        }



}
