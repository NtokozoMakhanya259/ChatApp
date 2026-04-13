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
        
        Scanner input = new Scanner(System.in);
        
        // Making the objects so we can use the code from the other files
        Registration signUp = new Registration();
        Login signIn = new Login();

        System.out.println("--- WELCOME TO CHITCHAT ---");

        // 1. PHONE NUMBER
        String phone = "";
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
        while (!signUp.checkUserName(user)) {
            System.out.print("Create username (max 5 chars, must have '_'): ");
            user = input.nextLine();
        }

        // 4. PASSWORD
        String pass = "";
        while (!signUp.isThePasswordValid(pass)) {
            System.out.print("Create password (8+ chars, Cap, Num, Symbol): ");
            pass = input.nextLine();
        }

        // Lock all the info into the Registration object
        
        System.out.println("\n" + signUp.registerUser(user, pass, phone, fName, lName));

        // --- LOGIN PART ---
        System.out.println( "--- PLEASE LOGIN ---");
        int tries = 0;
        boolean loggedIn = false;

        while (tries < 3 && !loggedIn) {
            System.out.print("Username: ");
            String inUser = input.nextLine();
            System.out.print("Password: ");
            String inPass = input.nextLine();

            // We check the input against the SAVED details in signUp
            loggedIn = signIn.loginUser(inUser, inPass, signUp.savedUsername, signUp.savedPassword);
            
            System.out.println(signIn.returnLoginStatus(loggedIn, signUp.firstName, signUp.lastName));

            if (!loggedIn) {
                tries++;
                if (tries < 3) {
                    System.out.println("Tries left: " + (3 - tries));
                } else {
                    System.out.println("LOCKED OUT.");
                }
            }
        }
        input.close();
    }
}