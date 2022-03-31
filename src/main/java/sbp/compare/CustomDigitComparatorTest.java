package sbp.compare;

import java.util.*;

/**
 * Класс CustomDigitComparatorTest выполняет проверку методов класса CustomDigitComparator
 * @autor Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе CustomDigitComparatorTests
 * @see "CustomDigitComparatorTests"
 */

public class CustomDigitComparatorTest {

    public static void main(String[] args) {

        /**
         *  Создание коллекции List с упорядоченными по убыванию элементами
         *  и сортировка через customDigitComparator
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        CustomDigitComparator customDigitComparator = new CustomDigitComparator();

        System.out.println("1) list before: " + list);
        list.sort(customDigitComparator);
        System.out.println("list after: " + list);

        /**
         *  Создание коллекции List с генерацией случайных элементов
         *  и сортировка через customDigitComparator
         */
        List<Integer> listRandom = new ArrayList<>();
        Integer intVar;
        for (int i = 1; i <= 10; i++) {

            intVar = (int) (Math.random() * 100);
            listRandom.add( (int) (Math.random() * 100 * i) );
        }

        System.out.println("2) listRandom before: " + listRandom);
        listRandom.sort(customDigitComparator);
        System.out.println("listRandom after: " + listRandom);

    }
}
