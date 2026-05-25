package chitchat;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    Message msg = new Message();

    @Test
    public void testCreateMessageHash() {
        String result = msg.createMessageHash(12, "Hello world");

        assertTrue(result.contains("12"));
        assertTrue(result.contains("helloworld"));
    }

    @Test
    public void testCheckMessage() {
        assertTrue(msg.checkMessage("This is a valid message"));
        assertFalse(msg.checkMessage("This message is definitely going to be longer than fifty characters which is not allowed"));
    }

    @Test
    public void testCheckCallNumber() {
        assertEquals("0712345678", msg.checkCallNumber("0712345678"));
        assertEquals("Invalid call number", msg.checkCallNumber("12345"));
    }

    @Test
    public void testStoreMessage() {
        assertEquals("message successfully sent.", msg.storeMessage(1, "0712345678", "Hi", "hash"));
        assertEquals("message disregard.", msg.storeMessage(2, "0712345678", "Hi", "hash"));
        assertEquals("merssage successfuly stored.", msg.storeMessage(3, "0712345678", "Hi", "hash"));
        assertEquals("Invalid choice.", msg.storeMessage(99, "0712345678", "Hi", "hash"));
    }

    @Test
    public void testReturnDone() {
        assertEquals("Saving done.", msg.returnDone());
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