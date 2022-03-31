package sbp.searchDuplicates;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Класс ParenthesesChecking выполняет проверку дубликатов
 * @author Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе ParenthesesCheckingTests
 * @see ParenthesesCheckingTests
 * Домашнее задание к занятию № 9, 10
 * Доп. задание: написать метод, который на вход получает строку, содержащую скобочки (корректный пример "(){}[]").
 * Результат работы метода булевое значение: true, если последовательность правильная.
 * Правильная - если скобочки открыты и закрыты корректно.
 * Некорректные примеры: "[(])", "{", ")", "({[][({((()))})(])]})".
 * Корректные примеры: "(){}[]", "{([({})])}". еще ({}) {()} [()] [{}]
 */

public class ParenthesesChecking {

    /**
     * ParenthesesCheckingMethod
     *     @param String
     *     @return boolean
     */

    public static boolean ParenthesesCheckingMethod(String inParenthesesString) throws FileNotFoundException {

        System.setErr(new PrintStream(new File("log.txt")));
        System.err.println("run ParenthesesCheckingMethod(" + inParenthesesString + ")");

        boolean resultChecking = false;
        boolean checkingStop = false;

        System.err.println("Инициализация коллекций со скобками");
        List<String> openParenthes = Arrays.asList("(", "{", "[");
        List<String> closeParenthes = Arrays.asList(")", "}", "]");

        System.err.println("Инициализация functionPairedParenthes - Передаем '(', получаем реверсивную скобку ')'");
        Function<String, String> functionPairedParenthes = (String inParenthes) -> {

            String resultFunctionPairedParenthes = "";

            int indexOpenParenthes = openParenthes.indexOf(inParenthes);
            int indexCloseParenthes = closeParenthes.indexOf(inParenthes);

            if (indexOpenParenthes != -1) {
                resultFunctionPairedParenthes = closeParenthes.get(indexOpenParenthes);
            }
            if (indexCloseParenthes != -1) {
                resultFunctionPairedParenthes = openParenthes.get(indexCloseParenthes);
            }

            return resultFunctionPairedParenthes;
        };

        System.err.println("Проверка 1: должно быть четное число элементов и все элементы из массивов");
        if (inParenthesesString.length() % 2 != 0) {
            resultChecking = false;
            checkingStop = true;
            System.err.println("Проверка 1: в строке - Нечетное число элементов! checkingStop=" + checkingStop);
        }

        System.err.println("Проверка 2: в строке должны быть только элементы, входящие в коллекции" );
        if (checkingStop == false) {

            System.err.println("Выполняется Проверка 2");

            for (int i = 0; i < inParenthesesString.length(); i++) {

                if ((openParenthes.indexOf(inParenthesesString.substring(i, i + 1)) == -1)
                        & (closeParenthes.indexOf(inParenthesesString.substring(i, i + 1)) == -1)) {

                    resultChecking = false;
                    checkingStop = true;
                    System.err.println("Есть символ, отличный от скобок!");

                };

            }
            System.err.println("Результат проверки 2 resultChecking=" + resultChecking);

        }

        System.err.println("Проверка 3) Число открытых = числу закрытых и идут подряд");
        if (checkingStop == false) {

            System.err.println("Выполняется проверка 3)");

            int countErrorCheckingAllParentheses = 0;
            int index = 0;
            while (index < inParenthesesString.length()) {

                System.err.println("Проверка пары " + functionPairedParenthes.apply(inParenthesesString.substring(index, index + 1)));

                String firstPair = inParenthesesString.substring(index, index + 2);
                String secondPair = (inParenthesesString.substring(index, index + 1).concat(functionPairedParenthes.apply(inParenthesesString.substring(index, index + 1))));
                if (inParenthesesString.substring(index, index + 2).equals(inParenthesesString.substring(index, index + 1).concat(functionPairedParenthes.apply(inParenthesesString.substring(index, index + 1))))) {
                    System.err.println("Скобки прошли проверку: " + firstPair + " " + secondPair);
                } else {
                    countErrorCheckingAllParentheses++;
                }
                index = index + 2;
            }
            if (countErrorCheckingAllParentheses == 0) {
                resultChecking = true;
                checkingStop = true;
            } else {
                resultChecking = false;
                checkingStop = false;
            }
            System.err.println("Результат проверки 3) : " + resultChecking);
        }

        System.err.println("Проверка 4) Первая и последняя скобки в строке и далее к середине");
        if (checkingStop == false) {

            System.err.println("Выполняется проверка 4)");

            int countErrorCheckingAllParentheses = 0;

            for (int i = 0; i < (int) inParenthesesString.length()/2; i++ ) {

                String firstParenthes = inParenthesesString.substring(i, i + 1);
                String reverseFirstParenthes  = functionPairedParenthes.apply(firstParenthes);
                String lastParenthes = inParenthesesString.substring(inParenthesesString.length() - i - 1, inParenthesesString.length() - i);

                if ( reverseFirstParenthes.equals(lastParenthes) ) {
                    System.err.println("Пара прошла проверку" + firstParenthes + " " + lastParenthes);
                } else {
                    countErrorCheckingAllParentheses++;
                    System.err.println("Пара НЕ прошла проверку s1 и s4 " + firstParenthes + " " + lastParenthes);
                }
            }
            if (countErrorCheckingAllParentheses == 0) {
                resultChecking = true;
                checkingStop = true;
            } else {
                resultChecking = false;
                checkingStop = false;
            }
            System.err.println("Результат проверки 4) : " + resultChecking);
        }

        System.err.println("Результат ParenthesesCheckingMethod resultChecking=" + resultChecking + " checkingStop="+checkingStop);
        return resultChecking;
    }

    /**
     * ParenthesesCheckingMethod2
     * trv: "По обработке последовательности скобок, можно сделать простое решение на основе стека"
     *     @param String
     *     @return boolean
     */


}
