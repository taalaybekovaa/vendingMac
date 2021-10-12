package com.techtorial;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import static com.techtorial.Instructions.getInstructions;

/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 */


/*
 * This is your main page where the vending machine application is going to be triggered and
 * all inputs being accepted.
 * Vending machine options are:
 * 1 - List all items/products, names of products
 * 2 - Get item/product info (details, availability), price and inventory number
 * 3 - Select a product
 * 4 - Get item/product price
 * 5 - List all prices
 * 6 - Set price range
 * 7 - Exit
 * 8 - Buy an item
 */
public class WelcomePage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Techtorial sponsored vending machine!");
        System.out.println("What is your name?");

        String name = scanner.next();
        System.out.println("Nice to meet you, " + name);
        System.out.println("Please press 0 for available options...");

        int allOptions = getIntegerInput(scanner, new Integer[] {0});
        getInstructions(allOptions);

        scanner = new Scanner(System.in);

        do {
            System.out.println("Enter what you want to do: ");
            switch (getIntegerInput(scanner, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8})) {
                case 1:
                    Products.getListOfProducts();
                    break;
                case 2:
                    System.out.println("What product you want to see details?");
                    String productName = scanner.next().trim();
                    int price = Products.getProductPrice(productName);
                    System.out.println(productName + " price: " +price);
                    int inventoryNumber = Products.isAvailable(productName);
                    if(inventoryNumber != 0){
                        System.out.println("The product is available.We have this " + inventoryNumber + " " + productName);
                    }else
                        System.out.println("Sorry, the "+ productName + " is sold out.");
                    break;
                case 3:
                    System.out.println("What product do you select?");
                    String productN = scanner.next().trim();
                    Products.selectProduct(productN);
                    String answer = scanner.next();
                    if(answer.equalsIgnoreCase("yes")){
                        Products.buyAProduct(productN);
                    }else {
                        Products.exit();
                    }
                    break;
                case 4:
                    System.out.println("What product you want to see details?");
                    String productNm = scanner.next().trim();
                    int price1 = Products.getProductPrice(productNm);
                    System.out.println(productNm + " price: " +price1);
                    break;
                case 5:
                    Products.getAllPrices();
                    break;
                case 6:
                    System.out.println("Enter your price range: ");
                    int initial = scanner.nextInt();
                    int last = scanner.nextInt();
                    Products.setRange(initial,last);
                    break;
                case 7:
                    Products.exit();
                    break;
                case 8:
                    System.out.println("Enter a product name:");
                    String productName1 = scanner.next().trim();
                    Products.buyAProduct(productName1);
                    break;
            }
            System.out.println("Do you want to continue?");

        }while(scanner.next().equalsIgnoreCase("Yes"));


        System.out.println("Thanks for shopping with us");

    }

    private static int getIntegerInput(Scanner scanner, Integer[] expected) {
        int allOptions = -1;
        for (int i = 1; i <= 3; i++) {
            scanner = new Scanner(System.in);
            int input;
            try {
                input = scanner.nextInt();

                if (!Arrays.asList(expected).contains(input)) {
                    throw new IOException();
                }
            } catch (Exception e) {
                if (i < 3) {
                    System.out.println("Please enter 0");
                    System.out.printf("You have %d more retries", 3 - i);
                    System.out.println();
                } else {
                    System.out.println("Sorry, try next time");
                    System.exit(1);
                }
                continue;
            }
            allOptions = input;
            break;
        }
        return allOptions;
    }
}
