package sbp.searchDuplicates;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Класс SearchDuplicates выполняет проверку дубликатов
 * @author Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе SearchDuplicatesTests
 * @see SearchDuplicatesTests
 * Домашнее задание к занятию № 9, 10
 *  1. Сделать как минимум 3 метода для поиска дубликатов. Метод на вход принимает коллекцию (любой тип данных).
 *  Исходящие данные - коллекция элементов, имеющих дубликаты.
 */

public class SearchDuplicates<T> {

    /**
     * Метод №1 duplicateSearchMethod реализован для коллекции ArrayList<T>
     *     @param ArrayList<T>
     *     @return ArrayList<T>
     */

    public ArrayList<T> duplicateSearchMethod(ArrayList<T> inArrayList) {

        ArrayList<T> outArrayList = new ArrayList<T>();

        int index = 0;
        int indexSearchDuplicate;
        int countDuplicate;

        while (index < inArrayList.size()) {

            countDuplicate = 0;
            indexSearchDuplicate = 0;

            while (indexSearchDuplicate < inArrayList.size()) {
                if (inArrayList.get(index).equals(inArrayList.get(indexSearchDuplicate)) ) { countDuplicate++; };
                indexSearchDuplicate++;
            }

            if ((countDuplicate > 1) && ( outArrayList.contains(inArrayList.get(index)) == false )) {
                outArrayList.add(inArrayList.get(index));
            };

            index++;
        }
        return outArrayList;
    }

    /**
     * Метод №2 duplicateSearchMethod2 реализован для коллекции ArrayList<T>
     * с использованием Iterator и ListIterator
     * @param ArrayList<T>
     * @return ArrayList<T>
     */

    public ArrayList<T> duplicateSearchMethod2(ArrayList<T> inArrayList) {

        ArrayList<T> outArrayList = new ArrayList<T>();

        Iterator iterator = inArrayList.iterator();
        ListIterator listIterator = inArrayList.listIterator();

        Object collectionObject = new Object();

        int countDuplicate;
        boolean movingForward = true;
        while(iterator.hasNext()) {

            collectionObject = iterator.next();
            countDuplicate = 0;

            if (movingForward) {

                while(listIterator.hasNext()) {
                    if (collectionObject.equals(listIterator.next())) { countDuplicate++; };
                }
                movingForward = false;

            } else {
                while(listIterator.hasPrevious()) {
                    if (collectionObject.equals(listIterator.previous())) { countDuplicate++; };
                }
                movingForward = true;
            }

            if ((countDuplicate > 1) && ( outArrayList.contains( (T) collectionObject ) == false )) {
                outArrayList.add( (T) collectionObject );
            };

        }
        return outArrayList;
    }


    /**
     * Метод №3 duplicateSearchMethod3 реализован для коллекции ArrayList<T>
     *     с использованием методов Stream API
     *  @param ArrayList<T>
     *  @return ArrayList<T>
     */

    public ArrayList<T> duplicateSearchMethod3(ArrayList<T> inArrayList) {

        Stream<T> inStream = inArrayList.stream();

        Predicate<T> predicate = (T item) -> {
            int index = 0;
            int countDuplicate = 0;
            while (index < inArrayList.size()) {
                if ( item.equals(inArrayList.get(index))) { countDuplicate++; }
                index++;
            }
            if (countDuplicate > 1) { return true; } else { return false; }
        };

        ArrayList<T> outArrayList = (ArrayList<T>) inStream
                .filter( predicate )
                .distinct()
                .collect(Collectors.toList());

        return outArrayList;
    }

    /**
     * Метод №4 duplicateSearchMethod4 реализован для коллекции Collection<T>
     *     с использованием массива Array
     * @param Collection<T>
     * @return Collection<T>
     */

    public Collection<T> duplicateSearchMethod4(Collection<T> inCollection) {

        T[] inCollectionArray;
        inCollectionArray = (T[]) inCollection.toArray();

        BiPredicate<T[], Integer> predicateItemWasFoundOnLeft = (T[] inArray, Integer index) -> {
            int countItemWasFoundOnLeft = 0;
            for (int i = 0; i < index; i++ ) {
                if (inArray[i].equals(inArray[index])) { countItemWasFoundOnLeft++; }
            };
            if (countItemWasFoundOnLeft > 0) { return true; } else { return false; }
        };

        Function<T[], Integer> functionCountDuplicateInCollectionArray = (T[] inArray) -> {
            int countDuplicateInCollectionArray = 0;
            int countDuplicateItem;
            for (int i = 0; i < inArray.length; i++) {
                countDuplicateItem = 0;
                for (int j = 0; j < inArray.length; j++) {
                    if (inArray[i].equals(inArray[j])) { countDuplicateItem++; };
                };
                if ((countDuplicateItem > 1) && (predicateItemWasFoundOnLeft.test(inArray, i))) { countDuplicateInCollectionArray++; }
            };
            return countDuplicateInCollectionArray;
        };

        T[] outCollectionArray;
        outCollectionArray = (T[]) new Object[functionCountDuplicateInCollectionArray.apply(inCollectionArray)];

        Predicate<T> predicateItemInOutCollectionArray = (T item) -> {
            int countItem = 0;
            for (int i = 0; i < outCollectionArray.length; i++) {
                if (item.equals(outCollectionArray[i])) { countItem++; }
            }
            if (countItem > 0) { return false; } else { return true; }
        };

        int countDuplicate;
        int indexOutCollectionArray = 0;

        for (int i = 0; i < inCollectionArray.length; i++) {

            countDuplicate = 0;

            for (int j = 0; j < inCollectionArray.length; j++) {
                if (inCollectionArray[i].equals(inCollectionArray[j])) { countDuplicate++; }
            }

            if ((countDuplicate > 1) && ( predicateItemInOutCollectionArray.test(inCollectionArray[i]) )) {
                outCollectionArray[indexOutCollectionArray] = inCollectionArray[i];
                indexOutCollectionArray++;
            }
        }
        return Arrays.asList(outCollectionArray);
    }

}
