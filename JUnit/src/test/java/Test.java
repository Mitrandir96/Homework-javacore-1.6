import netology.ru.Main;
import netology.ru.User;
import netology.ru.UserNotFoundException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Test {

    User user;


    @BeforeAll
    public static void initSuite() {
        System.out.println("Tests started");
    }
    @BeforeEach
    public void initTest() {
        System.out.println("Starting new Test");
    }
    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete");
    }
    @AfterAll
    public static void completeSuit() {
        System.out.println("Tests complete");
    }
    @org.junit.jupiter.api.Test
    public void testAccess() {
        String login = "Petya";
        String password = "1234";
        var expected = Exception.class;


        Assertions.assertThrows(expected, () -> Main.getUserByLoginAndPassword(login, password));

    }
    @org.junit.jupiter.api.Test
    public void testValidateUser() {
        Main.getUsers();
        Assertions.assertDoesNotThrow(
                () -> Main.validateUser((Main.getUsers())[1])
        );



    }
    @org.junit.jupiter.api.Test
    public void testQuantityUsers() {
        int expected = 3;
        int a = (Main.getUsers()).length;

        assertEquals(expected, a);
    }

}
