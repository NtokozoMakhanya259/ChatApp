/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chitchat;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest {
    Registration reg = new Registration();
// checking phone number if it meets the rules and is correct
    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(reg.checkCellPhoneNumber("+27831234567"));
        assertFalse(reg.checkCellPhoneNumber("0831234567"));
    }
//checking the undername if the correct format was used
    @Test
    public void testCheckUserName() {
        assertTrue(reg.checkUserName("ko_se"));
        assertFalse(reg.checkUserName("kosei"));
    }
//checking if the password was correctly inputed
    @Test
    public void testIsThePasswordValid() {
        assertTrue(reg.isThePasswordValid("Chit@123"));
        assertFalse(reg.isThePasswordValid("pass"));
    }
}
