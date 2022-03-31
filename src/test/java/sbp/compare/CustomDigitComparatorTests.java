package sbp.compare;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс CustomDigitComparatorTests проверяет класс CustomDigitComparator c использованием JUnit
 * @autor Sergey Proshchaev
 * @version 2.0
 */


class CustomDigitComparatorTests {

    @Test
    void test_sortedFirstValue_compare() {

        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        CustomDigitComparator customDigitComparator = new CustomDigitComparator();
        list.sort(customDigitComparator);

        /**
         *  Элементы коллекции до сортировки:
         *  list before: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
         *  *  Элементы коллекции после сортировки:
         * list after: [2, 4, 6, 8, 10, 1, 3, 5, 7, 9]
         */

        Assert.assertEquals(list.get(0).intValue(), 2);
    }

    @Test
    void test_sortedLastValue_compare() {

        List<Integer> list = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            list.add(i);
        }

        CustomDigitComparator customDigitComparator = new CustomDigitComparator();
        list.sort(customDigitComparator);

        /**
         *  Элементы коллекции до сортировки:
         *  list before: [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
         *  *  Элементы коллекции после сортировки:
         * list after: [2, 4, 6, 8, 10, 1, 3, 5, 7, 9]
         */

        Assert.assertEquals(list.get(9).intValue(), 9);
    }

}