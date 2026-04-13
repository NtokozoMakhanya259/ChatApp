/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chitchat;

/**
 *
 * @author Student
 */

public class Login {

    // This checks if what the user typed matches what we saved in Registration
    public boolean loginUser(String enteredUser, String enteredPass, String savedUser, String savedPass) {
        if (enteredUser == null || enteredPass == null) return false;
        
        // .equals is the best way to compare strings in Java
        return enteredUser.equals(savedUser) && enteredPass.equals(savedPass);
    }

    // This creates the welcome message if the login worked
    public String returnLoginStatus(boolean loginWasSuccessful, String fName, String lName) {
        if (loginWasSuccessful) {
            return "Welcome " + fName + " " + lName + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}