package ws;

import java.io.*;

// For main functions of ShoppingCart
public class Main extends ShoppingCart {

    public static void main(String[] args) {
        // Define instance of ShoppingCart
        ShoppingCart shoppingCart = new ShoppingCart();

        Console cons = System.console();

        System.out.print("Enter command (list, add, delete, exit): ");

        while (true) {
            String cmd = cons.readLine("> ").trim();

            if (cmd.equals("exit")) {
                break;

            } else if (cmd.equals("list")) {
                shoppingCart.list();

            } else if (cmd.startsWith("add ")) {
                shoppingCart.add(cmd.substring(4));

            } else if (cmd.startsWith("delete ")) {
                int itemNum = Integer.parseInt(cmd.substring(7));
                shoppingCart.delete(itemNum);

            } else {
                System.out.println("Unknown command.");
            }
        
        }

    }

}

