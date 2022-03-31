package sbp.collections;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;


/**
 * Класс ArrayIteratorTests выполняет Модульное тестирование JUnit класса ArrayIterator
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see ArrayIterator
 */
class ArrayIteratorTests {

    /**
     * Метод hasNext_SuccessfulTrue_Test выполняет Модульное тестирование JUnit
     * метода hasNext класса ArrayIterator
     */
    @Test
    void hasNext_SuccessfulTrue_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);
        Assert.assertTrue(iterator.hasNext());
    }

    /**
     * Метод hasNext_SuccessfulFalse_Test выполняет Модульное тестирование JUnit
     * метода hasNext класса ArrayIterator
     */
    @Test
    void hasNext_SuccessfulFalse_Test() {
        String[][] array = new String[][]{{"01", "02", "03"}, {"04", "05", "06"}, {"07", "08", "09"}, {"10", "11", "12"}, {"13", "14", "15"}};
        ArrayIterator iterator = new ArrayIterator(array);

        while (iterator.hasNext()) {
            iterator.next();
        }

        Assert.assertFalse(iterator.hasNext());
    }

    /**
     * Метод hasPrevious_SuccessfulTrue_Test выполняет Модульное тестирование JUnit
     * метода hasPrevious класса ArrayIterator
     */
    @Test
    void hasPrevious_SuccessfulTrue_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);

        int count = -1;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
            if (count >= 1) {
                Assert.assertTrue(iterator.hasPrevious());
            }
        }
    }

    /**
     * Метод hasPrevious_SuccessfulFalse_Test выполняет Модульное тестирование JUnit
     * метода hasPrevious класса ArrayIterator
     */
    @Test
    void hasPrevious_SuccessfulFalse_Test() {
        Double[][] array = new Double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}, {10.0, 11.0, 12.0}, {13.0, 14.0, 15.0}};
        ArrayIterator iterator = new ArrayIterator(array);

        Assert.assertFalse(iterator.hasPrevious());
        iterator.hasNext();
        Assert.assertFalse(iterator.hasPrevious());
    }

    /**
     * Метод next_Successful_Test выполняет Модульное тестирование JUnit
     * метода next класса ArrayIterator
     */
    @Test
    void next_Successful_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);

        Integer digit = 0;
        while (iterator.hasNext()) {
            digit = (Integer) iterator.next();
            Assert.assertTrue(digit != null);
        }
        Assert.assertTrue(digit == 15);
    }

    /**
     * Метод next_Fail_Test выполняет Модульное тестирование JUnit
     * метода next класса ArrayIterator
     */
    @Test
    void next_Fail_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);

        Integer digit = 0;
        while (iterator.hasNext()) {
            digit = (Integer) iterator.next();
            Assert.assertTrue(digit != null);
        }
        Assert.assertTrue(digit == 15);

        Assertions.assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    /**
     * Метод previous_Successful_Test выполняет Модульное тестирование JUnit
     * метода previous класса ArrayIterator
     */
    @Test
    void previous_Successful_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);

        Integer digit = 0;
        while (iterator.hasNext()) {
            digit = (Integer) iterator.next();
        }
        Assert.assertTrue(digit == 15);

        while (iterator.hasPrevious()) {
            digit = (Integer) iterator.previous();
            Assert.assertTrue(digit != null);
        }
        Assert.assertTrue(digit == 1);
    }

    /**
     * Метод previous_Fail_Test выполняет Модульное тестирование JUnit
     * метода previous класса ArrayIterator
     */
    @Test
    void previous_Fail_Test() {
        Integer[][] array = new Integer[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        ArrayIterator iterator = new ArrayIterator(array);

        Integer digit = 0;
        while (iterator.hasNext()) {
            digit = (Integer) iterator.next();
        }
        Assert.assertTrue(digit == 15);

        while (iterator.hasPrevious()) {
            digit = (Integer) iterator.previous();
            Assert.assertTrue(digit != null);
        }
        Assert.assertTrue(digit == 1);

        Assertions.assertThrows(NoSuchElementException.class, () -> iterator.previous());
    }

}