/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chitchat;

/**
 *
 * @author Student
 */

public class Registration {

    // These act as the memory to save the user's info for later
    public String savedUsername;
    public String savedPassword;
    public String savedPhoneNumber;
    public String firstName;
     public String lastName;

    // Checks if the username has a '_' and is short enough
    public boolean checkUserName(String username) {
      if (username == null) return false;
        
        // We check if the name contains an underscore and if the length is 5 or less
        return username.contains("_") && username.length() <= 5;
    }

    // Checks the password by looking at every single character
    public boolean isThePasswordValid(String password) {
       if (password == null || password.length() < 8) return false;
        
        boolean hasUpper = false;
         boolean hasNum = false;
         boolean hasSpec = false;

        // We turn the password into a list of characters and check each one
        for (int i = 0; i < password.length(); i++) {
           char c = password.charAt(i);

            if (Character.isUpperCase(c)) {
                hasUpper = true; // Found a capital letter!
            } else if (Character.isDigit(c)) {
                hasNum = true;   // Found a number!
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpec = true;  // Found a special character like @ or !
            }
        }
        // Only returns true if we found all three things
        return hasUpper && hasNum && hasSpec;
    }

    // Checks the phone number using basic string checks and a loop
    public boolean checkCellPhoneNumber(String phoneNumber) {
       if (phoneNumber == null || phoneNumber.length() != 12) return false;
        
        // First, check if it starts with +27
       if (!phoneNumber.startsWith("+27")) return false;
        
        // Then, check if every character after the '+' is a number
        for (int i = 1; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false; // If any character isn't a number, it's invalid
            }
        }
        return true;
    }

    // This method "captures" the info and saves it into the memory variables above
    public String registerUser(String user, String pass, String phone, String fName, String lName) {
       this.savedUsername = user;
       this.savedPassword = pass;
       this.savedPhoneNumber = phone;
       this.firstName = fName;
       this.lastName = lName;
        return "Registration successful: All details captured.";
    }
}