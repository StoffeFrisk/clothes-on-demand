package com.frisk.UI;

import com.frisk.BusinessObjects.ClothingItem;
import com.frisk.Observer.CEO;
import com.frisk.Orders.Order;
import com.frisk.Orders.OrderManager;
import com.frisk.Users.Customer;
import com.frisk.Commands.ClothingFactory;
import com.frisk.Enums.*;
import com.frisk.Builders.ClothingBuilder;

import java.util.Scanner;

public class WebShop {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        startWebShop();
    }

    private static void startWebShop() {
        System.out.println("\nVälkommen till 'Clothes On Demand'! Vänligen registrera dig som kund för att lägga en order.");

        CEO ceo = new CEO();
        OrderManager.addObserver(ceo);

        Customer customer = registerCustomer();
        Order order = createOrder(customer);

        if (order != null) {
            System.out.println("Din order har blivit skapad. Ordernummer: " + order.getOrderId());
            System.out.println("Tack för din beställning!");

            System.out.println("\n🛠 Bygger kläderna...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            OrderManager.notifyOrderCompleted(order);
        } else {
            System.out.println("Ingen order skapades.");
        }
    }

    private static Customer registerCustomer() {
        System.out.print("Namn: ");
        String name = scanner.nextLine();
        System.out.print("Adress: ");
        String address = scanner.nextLine();
        System.out.print("E-post: ");
        String email = scanner.nextLine();
        System.out.print("Telefon: ");
        String telephone = scanner.nextLine();

        Customer customer = new Customer(name, address, email, telephone);
        System.out.println("Registrering utförd");

        return customer;
    }

    private static Order createOrder(Customer customer) {
        System.out.println("\nVälj vilka plagg du vill beställa!");

        Order order = new Order(customer);

        while (true) {
            System.out.println("\n1. Kjol");
            System.out.println("2. Byxor");
            System.out.println("3. T-shirt");
            System.out.println("4. Lägg ordern.");
            System.out.println("5. Avbryt beställning.");
            System.out.print("Välj en av alternativen: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) {
                if (order.getItems().isEmpty()) {
                    System.out.println("Inga plagg finns i ordern.");
                } else {
                    OrderManager.addOrder(order);
                    System.out.println("\nOrder lagd! Order-ID: " + order.getOrderId());
                    return order;
                }
                continue;
            }

            if (choice == 5) {
                System.out.println("Beställningen avbruten. Ingen order sparades.");
                return null;
            }

            ClothingItem item = null;
            switch (choice) {
                case 1 -> item = createSkirt();
                case 2 -> item = createPants();
                case 3 -> item = createTShirt();
                default -> System.out.println("Otillåtet val. Försök igen.");
            }

            if (item != null) {
                order.addItem(item);
                System.out.println(item.getName() + " tillagd i ordern.");
            }
        }
    }

    private static ClothingItem createSkirt() {
        System.out.println("Skapa en kjol:");
        Size size = askForSize();
        Material material = askForMaterial();
        Colour colour = askForColour();
        Waist waist = askForWaist();
        Pattern pattern = askForPattern();

        ClothingBuilder builder = new ClothingBuilder()
                .setId(1001)
                .setName("Skirt")
                .setPrice(299.95)
                .setSize(size)
                .setMaterial(material)
                .setColour(colour);

        return ClothingFactory.createSkirt(builder, waist, pattern);
    }

    private static ClothingItem createPants() {
        System.out.println("Skapa ett par byxor:");
        Size size = askForSize();
        Material material = askForMaterial();
        Colour colour = askForColour();
        Fit fit = askForFit();
        Length length = askForLength();

        ClothingBuilder builder = new ClothingBuilder()
                .setId(1003)
                .setName("Pants")
                .setPrice(599.50)
                .setSize(size)
                .setMaterial(material)
                .setColour(colour);

        return ClothingFactory.createPants(builder, fit, length);
    }

    private static ClothingItem createTShirt() {
        System.out.println("Skapa en T-shirt:");
        Size size = askForSize();
        Material material = askForMaterial();
        Colour colour = askForColour();
        Sleeve sleeve = askForSleeve();
        Neck neck = askForNeck();

        ClothingBuilder builder = new ClothingBuilder()
                .setId(1002)
                .setName("T-Shirt")
                .setPrice(399.90)
                .setSize(size)
                .setMaterial(material)
                .setColour(colour);

        return ClothingFactory.createTShirt(builder, sleeve, neck);
    }

    private static String formatEnumInput(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private static Colour askForColour() {
        return askForEnum("Välj färg (Blue, Red, Green, Grey, Beige): ", Colour.class);
    }

    private static Size askForSize() {
        return askForEnum("Välj storlek (Smal, Medium, Large): ", Size.class);
    }

    private static Material askForMaterial() {
        return askForEnum("Välj material (Cotton, Denim, Polyester, Silk): ", Material.class);
    }

    private static Waist askForWaist() {
        while (true) {
            System.out.print("Välj midjemått (80, 90, 100): ");
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                for (Waist waist : Waist.values()) {
                    if (waist.getValue() == value) {
                        return waist;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning! Kan endast välja mellan 80, 90 eller 100.");
            }
        }
    }

    private static Pattern askForPattern() {
        return askForEnum("Välj mönster (Rutigt, Randigt, Prickigt): ", Pattern.class);
    }

    private static Fit askForFit() {
        return askForEnum("Välj passform (Slimfit, Regular): ", Fit.class);
    }

    private static Length askForLength() {
        while (true) {
            System.out.print("Välj längd (100, 110, 120): ");
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                for (Length length : Length.values()) {
                    if (length.getValue() == value) {
                        return length;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Felaktig inmatning! Skriv endast 100, 110 eller 120.");
            }
        }
    }

    private static Sleeve askForSleeve() {
        while (true) {
            System.out.print("Välj ärmlängd (Long, Short): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("long")) {
                return Sleeve.Long_Sleeve;
            } else if (input.equals("short")) {
                return Sleeve.Short_Sleeve;
            } else {
                System.out.println("Felaktig inmatning! Skriv 'Long' eller 'Short'.");
            }
        }
    }

    private static Neck askForNeck() {
        while (true) {
            System.out.print("Välj halsringning (V för V-neck, Regular för vanlig): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("v")) {
                return Neck.V_neck;
            } else if (input.equals("regular")) {
                return Neck.Regular;
            } else {
                System.out.println("Felaktig inmatning! Skriv 'V' för V-neck eller 'Regular' för vanlig.");
            }
        }
    }

    private static <T extends Enum<T>> T askForEnum(String prompt, Class<T> enumType) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Enum.valueOf(enumType, formatEnumInput(input));
            } catch (IllegalArgumentException e) {
                System.out.println("Felaktig inmatning! Försök igen.");
            }
        }
    }
}