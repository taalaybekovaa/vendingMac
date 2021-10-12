package com.techtorial;

import java.util.Arrays;
import java.util.Scanner;

public class Products {
    /*
     * Please add more vending machine features
     * - Buy a product
     * - Search for a product
     * - Get list of products
     */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};

    public static void getListOfProducts(){
        System.out.println(Arrays.toString(products));
    }
    public static String[] getAllPrices() {
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] + ": $" + prices[j]);
        }
        return products;
    }

    public static int getProductPrice(String productName) {
        int index = 0;
        for (String s : products) {
            if (productName.equalsIgnoreCase(s)) {
                return prices[index];
            }
            index++;
        }
        System.out.println("Sorry the product you entered is not available");
        return -1;
    }

    public static void selectProduct(String productName) {
        //loop over the product list to find out if it is available in our vending machine
        int inventoryNumber = isAvailable(productName);

        if(inventoryNumber > 0) {
            //if yes find the price (tip: call a specific method), print price of the product
            int price = getProductPrice(productName);
            System.out.println("The price of the " + productName + ": $" + price);
            //ask if customer wants to buy it -> if yes call another method to buy a product
//                               -> if no call method to cancel it
            System.out.println("Do you want to buy the " + productName + "?");
        }

    }

    public static void buyAProduct(String productName) {

        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */
        int inventoryNumber = isAvailable(productName);

        if(inventoryNumber <= 0) {
            System.out.println("The " + productName + " is out of stock.");
            return;
        }
        int price = getProductPrice(productName);
        System.out.println("The price of the product: $" + price);
        System.out.println("Enter the amount of money to buy the " + productName);
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        do {
            amount += scanner.nextInt();
            if (amount == price) {
                System.out.println("Your " + productName + " is on the way. Thank you for shopping with us");
                break;
            } else if (amount < price) {
                System.out.println("The " + amount + " is not enough.Please enter " + (price - amount) + " more");
            } else {
                System.out.println("Your item is on the way. Please take your change " + (amount - price));
                break;
            }
        } while (amount < price);

        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(productName)) {
                inventory[i]--;
                break;
            }
        }
    }

    public static int isAvailable(String productName){
        int inventoryNumber = 0;
        for(int i=0;i<products.length;i++){
            if(products[i].equalsIgnoreCase(productName)){
                if(inventory[i] != 0){
                    inventoryNumber = inventory[i];
                    break;
                }
            }
        }
        return inventoryNumber;
    }

    public static void exit(){
        System.out.println("Thank you for choosing our vending machine");
        System.exit(0);
    }

    public static void setRange(int initial, int last){
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            if(prices[j] > initial && prices[j] < last) {
                System.out.println(products[j] + ": $" + prices[j]);
            }
        }
    }
}
