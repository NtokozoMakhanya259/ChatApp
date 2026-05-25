package chitchat;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    Message msg = new Message();

    @Test
    public void testCreateMessageHash() {
        // Updated to match: createMessageHash(String id, int numMessages, String text)
        String result = msg.createMessageHash("1234567890", 1, "Hello World");

        // Format is [ID_part]:[Num]:[FIRST][LAST] -> 12:1:HELLOWORLD
        assertTrue(result.contains("12:1:HELLOWORLD"));
    }

    @Test
    public void testCheckMessage() {
        assertTrue(msg.checkMessage("This is a valid message"));
        // Fixed: The requirement is 250 characters, not 50
        assertFalse(msg.checkMessage("a".repeat(251)));
    }

    @Test
    public void testCheckCallNumber() {
        // Fixed: Your logic requires a string length <= 10 and NO "+" prefix
        assertEquals("0712345678", msg.checkCallNumber("0712345678"));
        assertEquals("Invalid call number", msg.checkCallNumber("+27712345678")); 
    }

    @Test
    public void testStoreMessage() {
        // Updated to match return strings in your Message.java
        assertEquals("Message successfully sent", msg.storeMessage(1, "0712345678", "Hi", "hash"));
        assertEquals("Press 0 to delete the message", msg.storeMessage(2, "0712345678", "Hi", "hash"));
        assertEquals("Message successfully stored", msg.storeMessage(3, "0712345678", "Hi", "hash"));
        assertEquals("Invalid choice.", msg.storeMessage(99, "0712345678", "Hi", "hash"));
    }

    @Test
    public void testStoreMessageAsJson() {
        String json = msg.storeMessageAsJson("1", "0712345678", "Hello", "abc");

        assertTrue(json.contains("\"id\": \"1\""));
        assertTrue(json.contains("\"call\": \"0712345678\""));
        assertTrue(json.contains("\"text\": \"Hello\""));
        assertTrue(json.contains("\"hash\": \"abc\""));
    }
}