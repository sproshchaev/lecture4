package sbp.searchDuplicates;

import java.util.ArrayList;

/**
 * Класс SearchDuplicatesTest выполняет проверку класса SearchDuplicates
 * @author Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе SearchDuplicatesTests
 * @see SearchDuplicatesTests
 * Домашнее задание к занятию № 9, 10
 *  1. Сделать как минимум 3 метода для поиска дубликатов. Метод на вход принимает коллекцию (любой тип данных).
 *  Исходящие данные - коллекция элементов, имеющих дубликаты.
 */

public class SearchDuplicatesTest {

    public static void main(String[] args) {

        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listInt.add(i);
                listInt.add(i);
            } else {
                listInt.add(i);
            }
        }
        System.out.println("listInt: " + listInt);

        SearchDuplicates<Integer> searchDuplicates = new SearchDuplicates<>();
        System.out.println("1) listIntDuplicates: " + searchDuplicates.duplicateSearchMethod(listInt));
        System.out.println("2) listIntDuplicates: " + searchDuplicates.duplicateSearchMethod2(listInt));
        System.out.println("3) listIntDuplicates: " + searchDuplicates.duplicateSearchMethod3(listInt));
        System.out.println("4) listIntDuplicates: " + searchDuplicates.duplicateSearchMethod4(listInt));
        System.out.println("");

        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listStr.add("String_" + i);
                listStr.add("String_" + i);
            } else {
                listStr.add("String_" + i);
            }
        }
        System.out.println("listStr: " + listStr);

        SearchDuplicates<String> searchDuplicates2 = new SearchDuplicates<>();

        System.out.println("1) listStrString: " + searchDuplicates2.duplicateSearchMethod(listStr));
        System.out.println("2) listStrString: " + searchDuplicates2.duplicateSearchMethod2(listStr));
        System.out.println("3) listStrString: " + searchDuplicates2.duplicateSearchMethod3(listStr));
        System.out.println("4) listStrString: " + searchDuplicates2.duplicateSearchMethod4(listStr));
        System.out.println("");

    }


}
