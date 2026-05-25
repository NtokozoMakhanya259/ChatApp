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
        boolean loggedIn = true;

        // --- Message Part ---
        if (loggedIn) {
            System.out.println("Welcome to QuickChat.");
            int choice = 0;
            
            // Loop until user selects 3 (Quit) to keep the app running
            while (choice != 3) {
                System.out.println("\n1. Send Messages\n2. View Sent Messages\n3. Quit");
                System.out.print("Enter choice: ");
                choice = input.nextInt();
                input.nextLine(); // Consume newline for scanner buffer

                switch (choice) {
                    case 1:
                        // Ask how many messages to send first
                        System.out.print("How many messages do you want to enter? ");
                        int numMessages = input.nextInt();
                        input.nextLine();

                        // Loop through based on the count the user provided
                        for (int i = 0; i < numMessages; i++) {
                            System.out.println("\nEntering details for message " + (i + 1));
                            
                            System.out.print("Enter Recipient Number: ");
                            String call = input.nextLine();
                            String validCall = msg.checkCallNumber(call);
                            
                            // Validate phone logic from Message class
                            if (validCall.equals("Invalid call number")) {
                                System.out.println("Invalid call number.");
                                continue;
                            }

                            System.out.print("Enter Message Text: ");
                            String text = input.nextLine();
                            // Validate length
                            if (!msg.checkMessage(text)) continue;

                            System.out.print("Enter Unique Message ID (at least 2 chars): ");
                            String id = input.nextLine();

                            // Pass 'i + 1' as the current message counter for the hash
                            String hash = msg.createMessageHash(id, i + 1, text);
                            
                            System.out.println("Hash generated: " + hash);
                            
                            // Ask for action choice until valid
                            int action = 0;
                            while (action < 1 || action > 3) {
                                System.out.print("1. Send  2. Discard  3. Store: ");
                                action = input.nextInt();
                                input.nextLine();
                            }
                            System.out.println(msg.storeMessage(action, validCall, text, hash));
                        }
                        break;

                    case 2:
                        // Placeholder per instructions
                        System.out.println("Coming Soon.");
                        break;

                    case 3:
                        System.out.println("Quit");  
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
