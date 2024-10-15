package ws;

import java.util.*;

public class ShoppingCart {
    
    // Define List<String> to hold items in cart
    private static List<String> cart;

    // Declare constructor
    public ShoppingCart() {
        // Initialise cart variable as new ArrayList<> - can expand ShoppingCart as you add items
        cart = new ArrayList<>();
    }

    // Declare list() method
    public void list() {
        // Checks if cart is empty
        if (cart.isEmpty()) {
            // Prints empty cart message
            System.out.println("The cart is empty.");
        } else {
            // If cart not empty, iterate through cart
            for (int i = 0; i < cart.size(); i++) {
                // Print each item at corresponding index
                System.out.println((i + 1) + ". " + cart.get(i));
            }
        }
    }
    // Declare add() method
    public void add(String items) {
        // Split String into array, split by ",""
        String[] newItems = items.split(",");
        // Iterate through items
        for (String item : newItems) {
            // Trim whitespace from each item
            item = item.trim();
            // Check if cart does not already have item
            if (!cart.contains(item)) {
                // If cart does not have item, add it to cart
                cart.add(item);
            } else { // If cart has item
                // Print item already present message
                System.out.println(item + " is already in the cart.");
            }
        }
    }

    // Declare delete() method
    public void delete(int itemNum) {
        // Check if index is out of bounds
        if (itemNum < 1 || itemNum > cart.size()) {
            // Print error message
            System.err.println("Error: Invalid index.");
        } else {
            // If index within bounds, remove index -1 (following list number)
            cart.remove(itemNum - 1);
            // Print delete message
            System.out.println("Item removed from the cart.");
        }
    }

}
