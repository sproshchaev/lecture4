package sbp.user;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

/**
 * JUnit тестирование медодов класса User проекта lecture4
 * @autor Sergey Proshchaev
 * @version 1.0
 */

class UserTests {

    @Test
    void toString_ObjInfo_Test() {
        System.out.println("JUnit тест userToString_Test:");

        Date dateOfbirth = new Date("12/11/1993");
        User user1 = new User("Ivan", "Ivanovich", "Ivanov", dateOfbirth, "+7922123456", "iiivanov", "654321");

        String stringForEquals = "sbp.user.User Ivan Ivanovich Ivanov Sat Dec 11 00:00:00 YEKT 1993 +7922123456 iiivanov";

        Assert.assertEquals(stringForEquals, user1.toString());

        System.out.println("---------------------------------");
    }

    @Test
    void equals_ObjСomparison_Test() {
        System.out.println("JUnit тест userEquals_Test:");

        Date dateOfbirth = new Date("12/11/1993");

        User user1 = new User("Ivan", "Ivanovich", "Ivanov", dateOfbirth, "+7922123456", "iiivanov", "654321");
        User user2 = new User("Ivan", "Ivanovich", "Ivanov", dateOfbirth, "+7922123456", "iiivanov", "654321");
        User user3 = new User("Petr", "Petrovich", "Petrov", dateOfbirth, "+7922123457", "pppetrov", "987654");

        Assert.assertTrue(user1.equals(user2));
        Assert.assertFalse(user1.equals(user3));

        System.out.println("---------------------------------");

    }
}