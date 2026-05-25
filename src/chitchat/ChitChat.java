/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chitchat;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class ChitChat {

    public static void main(String[] args) {

        // Scanner setup so the user can actually type in the terminal
        Scanner input = new Scanner(System.in);

        // Creating objects from our other classes to use their methods
        Registration signUp = new Registration();
        Login signIn = new Login();
        Message msg = new Message();

        System.out.println("--- WELCOME TO CHITCHAT ---");

        // 1. PHONE NUMBER
        String phone = "";
        // Loops until the phone number fits the +27 SA format rules
        while (!signUp.checkCellPhoneNumber(phone)) {
            System.out.print("Enter phone number (+27XXXXXXXXX): ");
            phone = input.nextLine();
            if (!signUp.checkCellPhoneNumber(phone)) {
                System.out.println("Invalid phone. Must start with +27 and be 12 digits.");
            }
        }

        // 2. NAMES
        System.out.print("Enter first name: ");
        String fName = input.nextLine();
        System.out.print("Enter last name: ");
        String lName = input.nextLine();

        // 3. USERNAME
        String user = "";
        // Loops until username is max 5 chars and has an underscore
        while (!signUp.checkUserName(user)) {
            System.out.print("Create username (max 5 chars, must have '_'): ");
            user = input.nextLine();
        }

        // 4. PASSWORD
        String pass = "";
        // Loops until password passes the security checks (Cap, Num, Symbol)
        while (!signUp.isThePasswordValid(pass)) {
            System.out.print("Create password (8+ chars, Cap, Num, Symbol): ");
            pass = input.nextLine();
        }

        // Send all the valid details to register the user
        System.out.println("\n" + signUp.registerUser(user, pass, phone, fName, lName));

        // 5. LOGIN
        System.out.print("Enter username to log in: ");
        String loginUser = input.nextLine();
        System.out.print("Enter password to log in: ");
        String loginPass = input.nextLine();
        
        // Forcing login to true for now so the program can move to the menu
        boolean loggedIn = false;
        loggedIn = true;

        // --- Message Part ---
        if (loggedIn) {
            int menuChoice = 0;
            // Keeps running the menu until the user selects option 3 (Quit)
            while (menuChoice != 3) {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Send a new Message");
                System.out.println("2. Discard and return to main menu");
                System.out.println("3. Quit");
                System.out.print("Choice: ");
                menuChoice = input.nextInt();
                input.nextLine(); // Clears the scanner buffer

                switch (menuChoice) {
                    case 1:
                        System.out.print("How many messages do you want to enter? ");
                        int numMessages = input.nextInt();
                        input.nextLine(); // Clears the scanner buffer

                        // Loops for the total number of messages specified
                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("\nEntering details for message " + (i + 1));

                            System.out.print("Enter Recipient Number: ");  
                            String call = input.nextLine();
                            String validCall = msg.checkCallNumber(call);

                            // Skips this loop iteration if the phone number is invalid
                            if (validCall.equals("Invalid call number")) {
                                System.out.println("Invalid call number. Skipping message.");
                                continue;
                            }

                            System.out.print("Enter Message Text: ");
                            String text = input.nextLine();
                            // Skips if the text is too long
                            if (!msg.checkMessage(text)) {
                                System.out.println("Message too long. Skipping.");  
                                continue;
                            }

                            System.out.print("Enter Message ID: ");
                            int id = input.nextInt();
                            input.nextLine(); // Clears the scanner buffer

                            // Generates a security hash for the message
                            String hash = msg.createMessageHash(id, text);

                            int action = 0;
                            // Loops until user selects 1, 2, or 3
                            while (action < 1 || action > 3) {  
                                System.out.print("1. Send  2. Discard  3. Store: ");
                                action = input.nextInt();
                                input.nextLine(); // Clears the scanner buffer
                            }

                            // Processes and prints the final message status
                            String result = msg.storeMessage(action, validCall, text, hash);
                            System.out.println(result);

                            // If action is 3, prints it in JSON format
                            if (action == 3) {
                                System.out.println("Stored as JSON: " +
                                    msg.storeMessageAsJson(String.valueOf(id), validCall, text, hash));
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Discarded.");
                        break;

                    case 3:
                        System.out.println("Goodbye!");  
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                        break;
                }
            }
        }

        // Close the scanner to prevent memory leaks
        input.close();
    }
}