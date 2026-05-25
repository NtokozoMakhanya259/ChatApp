/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chitchat;

/**
 *
 * @author Student
 */
class Message {
    
    public String createMessageHash(int messagenumber, String text){
        String numbers = "";
        for (int i = 0; i < Integer.toString(messagenumber).length(); i++){
            if (Integer.toString(messagenumber).length() > 0){
                numbers = "" + messagenumber;
                break;
            }
        }
        if (numbers.length() == 0){
            numbers = "00";
        }
        String[] words = text.trim().split(" ");
        String firstWord = words[0].toLowerCase();
        String lastWord = words[words.length - 1].toLowerCase();
        String textPart = firstWord + lastWord;
        return numbers + " " + textPart;
    }
    public boolean checkMessage(String text) {
        if (text.length() <= 50){
            return true;
        }else{
            System.out.println("Message is loo long. Must be 50 charaters or less.");
            return  false;
        }
    }
    public String checkCallNumber (String call){
        if (call.startsWith("0") && call.length() >= 10 && call.length() <= 10){
            return call;
        } else{
            return "Invalid call number";
        }
    }
    public String storeMessage(int action,   String call, String text,String hash){
        if (action == 1) return "message successfully sent.";
        if (action == 2) return "message disregard.";
        if (action == 3) return "merssage successfuly stored.";
        return "Invalid choice.";
    }
    public String returnDone(){
        return "Saving done.";
    }
    public String storeMessageAsJson(String id, String call, String text, String hash){
        return "{" +
                "\"id\": \"" + id + "\"," +
                "\"call\": \"" + call + "\"," +
                "\"text\": \"" + text + "\"," +
                "\"hash\": \"" + hash + "\"" +
                "}";       
    }
    
    
}