package ws;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCartDB {

    private String directory;
    // Initialise directory
    public ShoppingCartDB(String directory) {
        this.directory = directory;
    }

    // loadUser method
    public void loadUser(String user) {
        // Creates new file with user's name
        File userFile = new File(directory, user + ".db");
        try {
            // Checks if userFile exists; if not, create new file
            if (!userFile.exists()) {
                userFile.createNewFile();
            // Prints user
            } System.out.println("Loaded user: " + user);
        } catch (IOException e) { // Throw IOException & print error message
            System.out.println("Error loading user: " + e.getMessage());
        }
    }

    // saveUser method
    public void saveUser(String user, List<String> items) {
        // Creates new file with user's name
        File userFile = new File(directory, user + ".db");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile))) {
            for (String item : items) {
                writer.write(item);
                writer.newLine();
            } System.out.println("Saved cart for user: " + user);

        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    public void listUsers() {
        File dir = new File(directory);
        String[] users = dir.list((d, name) -> name.endsWith(".db"));
        if (users != null) {
            System.out.println("Users:");
            for (String user : users) {
                System.out.println(user.replace(".db", " "));
            }
        } else {
            System.out.println("No users found.");
        }
    }

}

