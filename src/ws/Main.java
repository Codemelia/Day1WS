package ws;

import java.io.*;

// For main functions of ShoppingCart
public class Main extends ShoppingCart {

    public static void main(String[] args) {
        // Define instance of ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Console to read input
        Console cons = System.console();

        // Prompt line
        System.out.print("Enter command (list, add, delete, exit): ");

        // Runs loop while condition is true
        while (true) {
            // Prints > for cmd, trims whitespace
            String cmd = cons.readLine("> ").trim();

            // If cmd = exit, break out of loop
            if (cmd.equals("exit")) {
                break;

            // If cmd = list, use list method from ShoppingCart
            } else if (cmd.equals("list")) {
                shoppingCart.list();

            // If cmd = add, use add method from ShoppingCart
            } else if (cmd.startsWith("add ")) {
                shoppingCart.add(cmd.substring(4)); // Entry starts after index 4

            // If cmd = delete
            } else if (cmd.startsWith("delete ")) {
                // Define itemNum - parseInt converts int into string
                int itemNum = Integer.parseInt(cmd.substring(7));
                // Use delete method from ShoppingCart
                shoppingCart.delete(itemNum);
            // If all conditions not met, print unknown cmd message
            } else {
                System.out.println("Unknown command.");
            }
        
        }

    }

}

