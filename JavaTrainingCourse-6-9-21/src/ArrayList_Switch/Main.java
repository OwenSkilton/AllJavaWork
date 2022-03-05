package ArrayList_Switch;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> basket = new ArrayList<>();
        int userInput = 0;
        while (userInput != 4) {
            try {
                switch (userInput) {
                    case 0:
                        System.out.println("\nAdd new item (1)\nRemove Item (2)\nView items (3)\nQuit (4)");
                        System.out.println("\nWhat would you like to do: ");
                        userInput = stdin.nextInt();
                        break;
                    case 1:
                        System.out.println("Add item: ");
                        String itemAdded = stdin.nextLine();
                        basket.add(itemAdded);
                        userInput = 0;
                        break;
                    case 2:
                        System.out.println("Remove item: ");
                        String itemRemoved = stdin.nextLine();
                        basket.remove(itemRemoved);
                        userInput = 0;
                        break;
                    case 3:
                        for (String item : basket) {
                            if (item.equals(basket.get(basket.toArray().length - 1))) {
                                System.out.printf("%s\n", item);
                            } else {
                                System.out.printf("%s, ", item);
                            }
                            userInput = 0;
                        }
                        break;
                    default:
                        System.out.println("OI! Unknown input. Please select from the list below.");
                        userInput = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nUnknown input. Please select from the list below.\n");
                userInput = 0;
            }
        }
    }
}
