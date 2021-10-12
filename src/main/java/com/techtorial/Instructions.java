package com.techtorial;

public class Instructions {


    public static void getInstructions(int input) {

        switch (input) {
            case 0:
                System.out.println("Press ");
                System.out.println("1 - List all items/products");
                System.out.println("2 - Get item/product info, price and inventory number");
                System.out.println("3 - Select a product");
                System.out.println("4 - Get item/product price");
                System.out.println("5 - List all prices");
                System.out.println("6 - Set price range");
                System.out.println("7 - Exit");
                System.out.println("8 - Buy an item");
                /*
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
            default:
                System.out.println("Please enter 0");
        }
    }


}
