/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chitchat;

/**
 *
 * @author Student
 */
public class Message {

    // Hash format: [First 2 ID chars]:[Num messages]:[FIRSTWORD][LASTWORD]
    public String createMessageHash(String id, int numMessages, String text) {
        String idPart = id.substring(0, 2).toUpperCase(); // Ensure uppercase
        String[] words = text.trim().split("\\s+");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        // Returns the hash in all caps as requested
        return (idPart + ":" + numMessages + ":" + first + last).toUpperCase();
    }

    public boolean checkMessage(String text) {
        // Requirement: 250 characters max
        if (text.length() <= 250) {
            // Requirement says to print "Message sent" if requirements are met
            // (Note: This is usually handled in the main class, but per your doc:)
            System.out.println("Message sent");
            return true;
        } else {
            System.out.println("Please enter a message of less than 250 characters.");
            return false;
        }
    }

    public String checkCallNumber(String call) {
        // Requirement: No more than 10 characters and NO international code
        // Updated: Removed the check for "+"
        if (call.length() <= 10 && !call.startsWith("+")) {
            return call;
        } else {
            return "Invalid call number";
        }
    }

    public String storeMessage(int action, String call, String text, String hash) {
        if (action == 1) return "Message successfully sent";
        if (action == 2) return "Press 0 to delete the message";
        if (action == 3) return "Message successfully stored";
        return "Invalid choice.";
    }

    public String storeMessageAsJson(String id, String call, String text, String hash) {
        return "{\"id\": \"" + id + "\", \"call\": \"" + call + "\", \"text\": \"" + text + "\", \"hash\": \"" + hash + "\"}";
    }
}