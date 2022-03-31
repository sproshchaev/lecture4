package sbp.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс ArrayIterator
 *
 * @version 1.0
 * Доп.задание: Необходимо написать класс ArrayIterator который умеет работать с массивами T[][]
 * @autor Sergey Proshchaev
 */
public class ArrayIterator<T> implements Iterator<T> {

    private T[][] twoDimArray;
    private int i, j;
    private int iMax, jMax;

    public ArrayIterator(T[][] twoDimArray) {
        this.twoDimArray = twoDimArray;
        i = -1;
        j = 0;
        iMax = twoDimArray[0].length - 1;
        jMax = twoDimArray.length - 1;
    }

    /**
     * Метод hasNext()
     *
     * @return - true если есть следующий элемент в массиве, false если элемента нет
     */
    @Override
    public boolean hasNext() {

        int iLocal = i;
        int jLocal = j;

        boolean result = true;

        if ((iLocal + 1) <= iMax) {
            iLocal = iLocal + 1;
        } else {
            if ((jLocal + 1) <= jMax) {
                iLocal = 0;
                jLocal = jLocal + 1;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод hasPrevious()
     *
     * @return - true если есть предидущий элемент в массиве, false если предидущего элемента нет
     */
    public boolean hasPrevious() {

        int iLocal = i;
        int jLocal = j;

        boolean result = true;

        if ((iLocal - 1) >= 0) {
            iLocal = iLocal - 1;
        } else {

            if ((jLocal - 1) >= 0) {
                iLocal = 0;
                jLocal = jLocal - 1;
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Метод previous()
     *
     * @return возвращает предидущий элемент массива
     * @throws NoSuchElementException если предидущий элемент отсутствует
     */
    public T previous() {
        if ((i - 1) >= 0) {
            i = i - 1;
        } else {

            if ((j - 1) >= 0) {
                i = iMax;
                j = j - 1;
            } else {
                throw new NoSuchElementException("Not found!");
            }
        }
        return twoDimArray[j][i];
    }

    /**
     * Метод next()
     *
     * @return возвращает следующий элемент массива
     * @throws NoSuchElementException если следующий элемент отсутствует
     */
    @Override
    public T next() {
        if ((i + 1) <= iMax) {
            i = i + 1;
        } else {
            if ((j + 1) <= jMax) {
                i = 0;
                j = j + 1;
            } else {
                throw new NoSuchElementException("Not found!");
            }
        }
        return twoDimArray[j][i];
    }

}
