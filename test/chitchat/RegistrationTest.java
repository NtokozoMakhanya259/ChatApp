/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chitchat;

import org.junit.Test;
import static org.junit.Assert.*;

public class RegistrationTest {
    Registration reg = new Registration();

    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue(reg.checkCellPhoneNumber("+27831234567"));
        assertFalse(reg.checkCellPhoneNumber("0831234567"));
    }

    @Test
    public void testCheckUserName() {
        assertTrue(reg.checkUserName("ko_se"));
        assertFalse(reg.checkUserName("kosei"));
    }

    @Test
    public void testIsThePasswordValid() {
        assertTrue(reg.isThePasswordValid("Chit@123"));
        assertFalse(reg.isThePasswordValid("pass"));
    }
}
