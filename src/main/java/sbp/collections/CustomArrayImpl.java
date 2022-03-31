package sbp.collections;

import java.util.Collection;

/**
 * Класс CustomArrayImpl<T>
 * @autor Sergey Proshchaev
 * @version 2.0
 * Проверки JUnit находятся в классе CustomArrayImplTest
 * @see CustomArrayImplTest
 * Емкость и размер https://upread.ru/art.php?id=955
 * 1) Размер - это количество элементов, которые в настоящее время содержит список ArrayList.
 * Для каждого элемента, добавленного в список или удаленного из него, размер увеличивается
 * и уменьшается соответственно на единицу.
 * 2) Емкость, с другой стороны, - это количество элементов, которые может содержать базовый массив.
 * ArrayList начинается с начальной емкости, которая увеличивается с интервалами.
 * Каждый раз, когда вы превышаете емкость массива, ArrayList копирует данные в новый массив,
 * который примерно на 50% больше предыдущего

   Домашнее задание к занятию № 5, 6
   Продолжаем работать в уже созданных репозиториях
   Реализовать класс CustomArrayImpl<T>, который представляет динамический массив:
   Класс CustomArrayImpl реализует интерфейс CustomArray<T>;
   Класс CustomArrayImpl может хранить объекты любого типа;
   Класс CustomArrayImpl может динамически расширяться;
   Добавить кострукторы: CustomArrayImpl(), CustomArrayImpl(int capacity), CustomArrayImpl(Collection<T> c);
   Написать unit тесты;
   Написать java docs;
   Изменять CustomArray<T> нельзя.
 */

public class CustomArrayImpl<T> implements CustomArray<T> {

    private final int INITIAL_CAPACITY = 5;
    private T[] customArray;

    /**
     *  Конструктор без параметров создает массив с минимальной емкостью INITIAL_CAPACITY = 5
     *  Замена customArray = (T[]) new Object[]{} на customArray = (T[]) new Object[INITIAL_CAPACITY]{}
     */

    CustomArrayImpl() {
        customArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     *  Конструктор создает массив с заданной емкостью
     */

    CustomArrayImpl(int capacity) {
        customArray = (T[]) new Object[capacity];
    }

    /**
     *  Конструктор создания массива из Collection с емкостью с Collection<T> c
     */

    CustomArrayImpl(Collection<T> c) {

        T[] cArray;
        cArray = (T[]) c.toArray();

        customArray = (T[]) new Object[cArray.length];

        for (int i = 0; i < cArray.length; i++) {
            customArray[i] = cArray[i];
        }
    }

    /**
     *  Получение текущего размера массива в емкости Capacity
     *  _ _ _ _ <= size()=0, getCapacity()=4
     *  _ 1 _ _ <= size()=1, getCapacity()=4
     */

    @Override
    public int size() {

        int resultSize = 0;

        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i] != null) {
                resultSize++;
            }
        }
        return resultSize;
    }

    /**
     *  Проверка массива на пустоту
     *  _ _ _ _ _ <= isEmpty=true
     *  _ _ 1 _ _ <= isEmpty=false
     */

    @Override
    public boolean isEmpty() {

        boolean resultIsEmpty = true;

        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i] != null) {
                resultIsEmpty = false;
            }
        }
        return resultIsEmpty;
    }

    /**
     * Add single item.
     *
     * @param item
     */
    @Override
    public boolean add(T item) {

        boolean resultAdd = false;

        int customArraySizeForAdd = 0;
        int positionToAdd = -1;
        for (int i = (customArray.length - 1); i >= 0; i--) {
            if (customArray[i] == null) {
                positionToAdd = i;
                customArraySizeForAdd++;
            } else {
                break;
            }
        }

        if (positionToAdd == -1) { positionToAdd = customArray.length; }

        try {

                if (customArraySizeForAdd == 0) {

                T[] customArrayNew;
                customArrayNew = (T[]) new Object[customArray.length + INITIAL_CAPACITY];

                for (int i = 0; i < customArray.length; i++) {
                    customArrayNew[i] = customArray[i];
                }

                positionToAdd = customArray.length;

                customArrayNew[customArray.length] = item;
                customArray = customArrayNew;

                }

                customArray[positionToAdd] = item;

                resultAdd = true;

        } catch (Exception ex) {
                System.out.println("Ошибка " + ex.getMessage());
                ex.printStackTrace();
        }
        return resultAdd;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(T[] items) {

        boolean resultAddAll = false;

        if (items == null) throw new IllegalArgumentException("Parameter items is null!");

        try {

        int customArraySizeForAdd = 0;
        int positionToAdd = -1;
        for (int i = (customArray.length - 1); i >= 0; i--) {
            if (customArray[i] == null) {
                positionToAdd = i;
                customArraySizeForAdd++;
            } else {
                break;
            }
        }

        if (positionToAdd == -1) { positionToAdd = customArray.length; }

        if ((positionToAdd + items.length) > customArray.length) {

            int newSizeCustomArrayNew = positionToAdd + items.length;
            T[] customArrayNew;
            customArrayNew = (T[]) new Object[newSizeCustomArrayNew];

            int indexCustomArrayNew = 0;
            for (int i = 0; i < customArray.length; i++) {
                customArrayNew[indexCustomArrayNew] = customArray[i];
                indexCustomArrayNew++;
            }
            customArray = customArrayNew;

        }
            int indexСustomArray = positionToAdd;
            for (int i = 0; i < items.length; i++) {
                customArray[indexСustomArray] = items[i];
                indexСustomArray++;
            }

            resultAddAll = true;

        } catch (Exception ex) {
            System.out.println("Ошибка " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultAddAll;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */

    @Override
    public boolean addAll(Collection<T> items) {

        boolean resultAddAll = false;

        if (items == null) throw new IllegalArgumentException("Parameter items is null!");

        try {

            T[] itemsArray;
            itemsArray = (T[]) items.toArray();

            int customArraySizeForAdd = 0;
            int positionToAdd = -1;
            for (int i = (customArray.length - 1); i >= 0; i--) {
                if (customArray[i] == null) {
                    positionToAdd = i;
                    customArraySizeForAdd++;
                } else {
                    break;
                }

            }

            if (positionToAdd == -1) { positionToAdd = customArray.length; }

            if ((positionToAdd + itemsArray.length) > customArray.length) {

                int newSizeCustomArrayNew = positionToAdd + itemsArray.length;
                T[] customArrayNew;
                customArrayNew = (T[]) new Object[newSizeCustomArrayNew];

                int indexCustomArrayNew = 0;
                for (int i = 0; i < customArray.length; i++) {
                    customArrayNew[indexCustomArrayNew] = customArray[i];
                    indexCustomArrayNew++;
                }
                customArray = customArrayNew;

            }
            int indexСustomArray = positionToAdd;
            for (int i = 0; i < itemsArray.length; i++) {
                customArray[indexСustomArray] = itemsArray[i];
                indexСustomArray++;
            }

            resultAddAll = true;

        } catch (Exception ex) {
            System.out.println("Ошибка " + ex.getMessage());
            ex.printStackTrace();
        }
        return resultAddAll;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, T[] items) {

        boolean resultAddAll = false;

        if (((index < 0) || (index > (customArray.length - 1))) && (customArray.length != 0)) throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");

        if (items == null) throw new IllegalArgumentException("Parameter items is null!");

        try {

            int newSizeArray = index + items.length;

            if (newSizeArray > customArray.length) {

                System.out.println("Создание нового массива размером " + newSizeArray + " элементов");

                T[] customArrayNew;
                customArrayNew = (T[]) new Object[ newSizeArray ];

                System.out.println("Заполнение массива customArrayNew с позиции 0 на " + customArray.length + " элементов");
                for (int i=0; i < customArray.length; i++) {
                    customArrayNew[i] = customArray[i];
                }

                System.out.println("Заполнение массива customArrayNew с позиции " + index + " на " + items.length + " элементов");
                int itemsCount = 0;
                for (int i = index; i < customArrayNew.length; i++) {
                    customArrayNew[i] = items[itemsCount];
                    itemsCount++;
                }

                customArray = customArrayNew;

            } else {

                System.out.println("Размер действующего массива достаточен. Заполнение с " + index + " индекса на " + items.length + " элементов" );

                int indexCustomArray = index;
                for (int i = 0; i < items.length; i++) {
                    customArray[indexCustomArray] = items[i];
                    indexCustomArray++;
                }
            }

            resultAddAll = true;

        } catch (Exception ex) {
            System.out.println("Ошибка " + ex.getMessage());
            ex.printStackTrace();
        }

        return resultAddAll;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T get(int index) {

        if (((index < 0) || (index > (customArray.length - 1))) && (customArray.length != 0)) throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");

        T resultGet;
        resultGet = customArray[index];
        return resultGet;
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public T set(int index, T item) {

        if (((index < 0) || (index > (customArray.length - 1))) && (customArray.length != 0)) throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");

        T resultOldValue;
        resultOldValue = this.customArray[index];

        this.customArray[index] = item;

        return resultOldValue;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) {

        if (((index < 0) || (index > (customArray.length - 1))) && (customArray.length != 0)) throw new ArrayIndexOutOfBoundsException("Index is out of bounds!");

        T[] customArrayNew;
        customArrayNew = (T[]) new Object[ customArray.length - 1 ];

        int customArrayNewIndex = 0;
        for (int i = 0; i < customArray.length; i++) {
            if (i != index) {
                customArrayNew[customArrayNewIndex] = customArray[i];
                customArrayNewIndex++;
            }
        }
        customArray = customArrayNew;
    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(T item) {

        boolean resultRemove = false;
        int countItemWasFound = 0;

        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i].equals(item)) {
                countItemWasFound = countItemWasFound + 1;
            }
        }

        if (countItemWasFound >0) {
            T[] customArrayNew;

            int newSizeCustomArrayNew = customArray.length - countItemWasFound;
            customArrayNew = (T[]) new Object[newSizeCustomArrayNew];

            int customArrayNewIndex = 0;
            for (int i = 0; i < customArray.length; i++) {
                if (customArray[i].equals(item)) {
                    resultRemove = true;
                } else {
                    customArrayNew[customArrayNewIndex] = customArray[i];
                    customArrayNewIndex++;
                }
            }
            customArray = customArrayNew;
        }
        return resultRemove;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(T item) {

        boolean resultContains = false;

        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i].equals(item)) {
                resultContains = true;
            }
        }
        return resultContains;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(T item) {

        int resultIndexOf = -1;
        for (int i = 0; i < customArray.length; i++) {
            if (customArray[i].equals(item) ) {
                resultIndexOf = i;
                break;
            }
        }
        return resultIndexOf;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {

        T[] customArrayNew;
        customArrayNew = (T[]) new Object[ newElementsCount ];

        int copyToElement = this.customArray.length;
        if (newElementsCount < this.customArray.length) {
            copyToElement = newElementsCount;
        }

        for (int i=0; i < copyToElement; i++) {
            customArrayNew[i] = customArray[i];
        }

        customArray = customArrayNew;
    }

    /**
     * Get current capacity.
     * Вопрос в чат: "@RomanTaranov В ДЗ в public class CustomArrayImpl<T> implements CustomArray<T>
     * метод     public int size() и метод public int getCapacity() будут возвращать одно и тоже?
     *
     * Ответ из чата: "при инициализации масива с заданным капасити  size вернет 0  getCapacity вернет capaсity заданное при инициализации
     * по мере добавления элементов size будет увеличиваться пока не станет равным capacity дальше они будут увеличиваться вместе при удалении элемента size будет уменьшатся а capacity остается неизменным"
     *
     * _ _ _ _ getCapacity() = 4
     */
    @Override
    public int getCapacity() {
        return customArray.length;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {
        T[] customArrayNew;
        customArrayNew = (T[]) new Object[ customArray.length ];

        for (int i=0; i < customArray.length; i++) {
            customArrayNew[customArray.length - i - 1] = customArray[i];
        }
        customArray = customArrayNew;
    }

    /**
     * Get copy of current array.
     */
    @Override
    public Object[] toArray() {
        Object[] obj1 = new Object[customArray.length];
        for (int i=0; i < customArray.length; i++) {
            obj1[i] = customArray[i];
        }
        return obj1;
    }

}

