package ws;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

// For main functions of ShoppingCart, ShoppingCartDB
public class Main {

    private static String cartDirectory = "db";
    private static String currentUser = null;
    private static ShoppingCartDB shoppingCartDB;

    public static void main(String[] args) throws NumberFormatException {
        // Checks command-line args to set cartDirectory
        if (args.length > 0) {
            cartDirectory = args[0];
        }

        shoppingCartDB = new ShoppingCartDB(cartDirectory); // Initialises ShoppingCartDB with specified directory

        // Define instance of ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

        // Console to read input
        Console cons = System.console();

        // Prompt line
        System.out.print("Enter command (list, add, delete, exit, login, save, users): ");

        // Runs loop while condition is true
        while (true) {

            // Prints > for cmd, trims whitespace
            String cmd = cons.readLine("> ").trim();

            // If cmd = exit, break out of loop
            if (cmd.equals("exit")) {
                break;

            // If cmd = list, use list method from ShoppingCart
            } else if (cmd.equals("list")) {
                ShoppingCart.list();

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

            } else if (cmd.startsWith("login ")) {
                String user = cmd.substring(6);
                shoppingCartDB.loadUser(user);

            } else if (cmd.startsWith("save ")) {
                String userFile = cmd.substring(5);
                shoppingCartDB.saveUser(userFile, ShoppingCart.cart);

            } else if (cmd.equals("users")) {
                shoppingCartDB.listUsers();

            } else {
                System.out.println("Unknown command.");
            }
        
        }

    }

}

