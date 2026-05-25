/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package chitchat;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    //creating objects for login
    Login log = new Login();

    @Test
    public void testLoginUser() {
        // Correct details saved
        String savedU = "ko_se";
        String savedP = "Chit@123";
        assertTrue(log.loginUser("ko_se", "Chit@123", savedU, savedP));
        assertFalse(log.loginUser("ko_se", "wrong", savedU, savedP));
    }
}