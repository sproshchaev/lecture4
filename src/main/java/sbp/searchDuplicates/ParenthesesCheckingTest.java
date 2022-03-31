package sbp.searchDuplicates;

import java.io.FileNotFoundException;

/**
 * Класс ParenthesesCheckingTest выполняет проверку класса ParenthesesChecking
 * @author Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе ParenthesesCheckingTests
 * @see ParenthesesCheckingTest
 * Домашнее задание к занятию № 9, 10
 * Доп. задание: написать метод, который на вход получает строку, содержащую скобочки (корректный пример "(){}[]").
 * Результат работы метода булевое значение: true, если последовательность правильная.
 * Правильная - если скобочки открыты и закрыты корректно.
 * Некорректные примеры: "[(])", "{", ")", "({[][({((()))})(])]})".
 * Корректные примеры: "(){}[]", "{([({})])}". еще ({}) {()} [()] [{}]
 */

public class ParenthesesCheckingTest {

    public static void main(String[] args) throws FileNotFoundException {

        /**
         * 1) ParenthesesCheckingMethod
         *     @param String = "[(])"
         *     @return boolean = false
         */

        String parenthesesString1 = "[(])";
        System.out.println( "1)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString1));

        /**
         * 2) ParenthesesCheckingMethod
         *     @param String = "{"
         *     @return boolean = false, Нечетное число элементов!
         */

        String parenthesesString2 = "{";
        System.out.println( "2)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString2));

        /**
         * 3) ParenthesesCheckingMethod
         *     @param String = ")"
         *     @return boolean = false, Нечетное число элементов!
         */

        String parenthesesString3 = ")";
        System.out.println( "3)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString3));

        /**
         * 4) ParenthesesCheckingMethod
         *     @param String = ")"
         *     @return boolean = false, нечетное число элементов
         */

        String parenthesesString4 = "({[][({((()))})(])]})";
        System.out.println( "4)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString4));

        /**
         * 5) ParenthesesCheckingMethod
         *     @param String = "(){}[]"
         *     @return boolean = true
         */

        String parenthesesString5 = "(){}[]";
        System.out.println( "5)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString5));

        /**
         * 6) ParenthesesCheckingMethod
         *     @param String = "{([({})])}"
         *     @return boolean = true
         */

        String parenthesesString6 = "{([({})])}";
        System.out.println( "6)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString6));

        /**
         * 7) ParenthesesCheckingMethod
         *     @param String = "{([({})])_"
         *     @return boolean = false, "Присутствует не скобка!"
         */

        String parenthesesString7 = "{([({})])_";
        System.out.println( "7)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString7));

        /**
         * 8) ParenthesesCheckingMethod
         *    "trv: Добавьте ещё тест для такой последовательности “{([([({][}])]))}“
         *     @param String = "{([([({][}])]))}"
         *     @return boolean = false
         */

        String parenthesesString8 = "{([([({][}])]))}";
        System.out.println( "8)" + ParenthesesChecking.ParenthesesCheckingMethod(parenthesesString8));

    }

}
