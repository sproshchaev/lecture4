package sbp.searchDuplicates;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс SearchDuplicatesTests выполняет Модульное тестирование JUnit класса SearchDuplicates
 * @author Sergey Proshchaev
 * @version 1.0
 * @see SearchDuplicates
 */

class SearchDuplicatesTests {

    @Test
    void test_noDuplicatesInteger_duplicateSearchMethod() {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listInt.add(i);
                listInt.add(i);
            } else {
                listInt.add(i);
            }
        }
        SearchDuplicates<Integer> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod(listInt).toString(), "[1, 2, 3, 4, 6, 7, 8, 9, 10]");
    }

    @Test
    void test_noDuplicatesString_duplicateSearchMethod() {
        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listStr.add("String_" + i);
                listStr.add("String_" + i);
            } else {
                listStr.add("String_" + i);
            }
        }
        SearchDuplicates<String> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod(listStr).toString(), "[String_1, String_2, String_3, String_4, String_6, String_7, String_8, String_9, String_10]");
    }

    @Test
    void test_noDuplicates_duplicateSearchMethod2() {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listInt.add(i);
                listInt.add(i);
            } else {
                listInt.add(i);
            }
        }
        SearchDuplicates<Integer> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod2(listInt).toString(), "[1, 2, 3, 4, 6, 7, 8, 9, 10]");
    }

    @Test
    void test_noDuplicatesString_duplicateSearchMethod2() {
        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listStr.add("String_" + i);
                listStr.add("String_" + i);
            } else {
                listStr.add("String_" + i);
            }
        }
        SearchDuplicates<String> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod2(listStr).toString(), "[String_1, String_2, String_3, String_4, String_6, String_7, String_8, String_9, String_10]");
    }

    @Test
    void test_noDuplicates_duplicateSearchMethod3() {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listInt.add(i);
                listInt.add(i);
            } else {
                listInt.add(i);
            }
        }
        SearchDuplicates<Integer> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod3(listInt).toString(), "[1, 2, 3, 4, 6, 7, 8, 9, 10]");
    }

    @Test
    void test_noDuplicatesString_duplicateSearchMethod3() {
        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listStr.add("String_" + i);
                listStr.add("String_" + i);
            } else {
                listStr.add("String_" + i);
            }
        }
        SearchDuplicates<String> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod3(listStr).toString(), "[String_1, String_2, String_3, String_4, String_6, String_7, String_8, String_9, String_10]");
    }


    @Test
    void test_noDuplicates_duplicateSearchMethod4() {
        ArrayList<Integer> listInt = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listInt.add(i);
                listInt.add(i);
            } else {
                listInt.add(i);
            }
        }
        SearchDuplicates<Integer> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod4(listInt).toString(), "[1, 2, 3, 4, 6, 7, 8, 9, 10]");
    }

    @Test
    void test_noDuplicatesString_duplicateSearchMethod4() {
        ArrayList<String> listStr = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            if (i != 5) {
                listStr.add("String_" + i);
                listStr.add("String_" + i);
            } else {
                listStr.add("String_" + i);
            }
        }
        SearchDuplicates<String> searchDuplicates = new SearchDuplicates<>();
        Assert.assertEquals(searchDuplicates.duplicateSearchMethod4(listStr).toString(), "[String_1, String_2, String_3, String_4, String_6, String_7, String_8, String_9, String_10]");
    }

}