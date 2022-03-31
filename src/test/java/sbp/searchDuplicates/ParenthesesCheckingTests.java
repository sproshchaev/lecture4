package sbp.searchDuplicates;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс ParenthesesCheckingTests выполняет Модульное тестирование JUnit класса ParenthesesChecking
 * @author Sergey Proshchaev
 * @version 1.0
 * @see ParenthesesChecking
 */

class ParenthesesCheckingTests {

    /**
     * 1) ParenthesesCheckingMethod
     *     @param String = "[(])"
     *     @return boolean = false
     */

    @Test
    void test_returnFalse1_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString1 = "[(])";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString1));
    }

    /**
     * 2) ParenthesesCheckingMethod
     *     @param String = "{"
     *     @return boolean = false, Нечетное число элементов!
     */

    @Test
    void test_returnFalse2_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString2 = "{";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString2));
    }

    /**
     * 3) ParenthesesCheckingMethod
     *     @param String = ")"
     *     @return boolean = false, Нечетное число элементов!
     */

    @Test
    void test_returnFalse3_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString3 = ")";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString3));
    }


    /**
     * 4) ParenthesesCheckingMethod
     *     @param String = ")"
     *     @return boolean = false, нечетное число элементов
     */

    @Test
    void test_returnFalse4_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString4 = "({[][({((()))})(])]})";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString4));
    }


    /**
     * 5) ParenthesesCheckingMethod
     *     @param String = "(){}[]"
     *     @return boolean = true
     */

    @Test
    void test_returnFalse5_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString5 = "(){}[]";
        Assertions.assertTrue(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString5));
    }

    /**
     * 6) ParenthesesCheckingMethod
     *     @param String = "{([({})])}"
     *     @return boolean = true
     */

    @Test
    void test_returnFalse6_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString6 = "{([({})])}";
        Assertions.assertTrue(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString6));
    }

    /**
     * 7) ParenthesesCheckingMethod
     *     @param String = "{([({})])_"
     *     @return boolean = false, "Присутствует не скобка!"
     */

    @Test
    void test_returnFalse7_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString7 = "{([({})])_";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString7));
    }

    /**
     * 8) ParenthesesCheckingMethod
     *    "trv: Добавьте ещё тест для такой последовательности “{([([({][}])]))}“
     *     @param String = "{([([({][}])]))}"
     *     @return boolean = false
     */
    @Test
    void test_returnFalse8_parenthesesCheckingMethod() throws FileNotFoundException {
        String parenthesesString8 = "{([([({][}])]))}";
        Assertions.assertFalse(ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString8));
    }


}