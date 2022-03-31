package sbp.collections;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Класс CustomArrayImplTest проверяет класс CustomArrayImpl<T> c использованием JUnit
 * @autor Sergey Proshchaev
 * @version 2.0
 */

class CustomArrayImplTest {

    @Test
    public void test_noParameter_CustomArrayImpl() {

        System.out.println("1) JUnit Конструктор класса CustomArrayImpl()");
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>(10);
        System.out.println("Заполнение элементами...");
        int currArraySize1 = customArrayImpl1.getCapacity();
        for (int i = 0; i < currArraySize1; i++) {
            customArrayImpl1.set(i, i * 100);
        }
        System.out.println("Массив заполнен!");
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl1.getCapacity(); i++) {
            System.out.print(customArrayImpl1.get(i));
            if (i < customArrayImpl1.getCapacity() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }

        System.out.println("1.1) customArrayImpl1 notNull");
        Assert.assertNotNull(customArrayImpl1);

        System.out.println("1.2) size()=10");
        Assert.assertEquals(customArrayImpl1.getCapacity(), 10);

        System.out.println("1.3) Элементы массива: 0, 100, 200, 300, 400, 500, 600, 700, 800, 900");
        for (int i = 0; i < customArrayImpl1.getCapacity(); i++) {
            Assert.assertTrue(customArrayImpl1.get(i).equals(i * 100));
        }
        System.out.println("");
    }

    @Test
    public void test_capacity_CustomArrayImpl() {

        System.out.println("2) Конструктор класса CustomArrayImpl(int capacity)");
        CustomArrayImpl<String> customArrayImpl2 = new CustomArrayImpl<String>(10);
        System.out.println("Заполнение элементами...");
        for (int i = 0; i < 10; i++) {
            customArrayImpl2.set(i, "Строка " + i);
        }
        System.out.println("Массив заполнен!");
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl2.getCapacity(); i++) {
            System.out.print(customArrayImpl2.get(i));
            if (i < customArrayImpl2.getCapacity() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }

        System.out.println("2.1) customArrayImpl2 notNull");
        Assert.assertNotNull(customArrayImpl2);

        System.out.println("2.2) size()=10");
        Assert.assertEquals(customArrayImpl2.getCapacity(), 10);

        System.out.println("2.3) Строка 0, Строка 1, Строка 2, Строка 3, Строка 4, Строка 5, Строка 6, Строка 7, Строка 8, Строка 9");
        for (int i = 0; i < customArrayImpl2.getCapacity(); i++) {
            Assert.assertTrue(customArrayImpl2.get(i).equals("Строка " + i));
        }

        System.out.println("");
    }

    @Test
    public void test_Collection_CustomArrayImpl() {

        System.out.println("3) Конструктор класса CustomArrayImpl(Collection<T> c)");
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            arrayList1.add("ArrayList_2." + i);
        }
        CustomArrayImpl<String> customArrayImpl3 = new CustomArrayImpl<String>(arrayList1);
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) {
                System.out.print(", ");
            } else {
                System.out.println(".");
            }
        }

        System.out.println("3.1) customArrayImpl3 notNull");
        Assert.assertNotNull(customArrayImpl3);

        System.out.println("3.2) size()=10");
        Assert.assertEquals(customArrayImpl3.getCapacity(), 10);

        System.out.println("3.3) Строка 0, Строка 1, Строка 2, Строка 3, Строка 4, Строка 5, Строка 6, Строка 7, Строка 8, Строка 9");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            Assert.assertTrue(customArrayImpl3.get(i).equals("ArrayList_2." + i));
        }

        System.out.println("");

    }

    @Test
    void test_10_size() {
        CustomArrayImpl<Integer> customArrayImpl0 = new CustomArrayImpl<Integer>(10);
        for (int i = 0; i < customArrayImpl0.getCapacity(); i++) { customArrayImpl0.set(i, i * 100); }
        Assert.assertNotNull(customArrayImpl0);
        Assert.assertEquals(customArrayImpl0.size(), 10);
    }

    @Test
    void test_1_size() {
        CustomArrayImpl<Integer> customArrayImpl0 = new CustomArrayImpl<Integer>(10);
        customArrayImpl0.set(5, 1000);
        Assert.assertNotNull(customArrayImpl0);
        Assert.assertEquals(customArrayImpl0.size(), 1);
    }

    @Test
    void test_trueCapacity10_isEmpty() {
        CustomArrayImpl<Integer> customArrayImpl0 = new CustomArrayImpl<Integer>(10);
        Assert.assertTrue(customArrayImpl0.isEmpty());
    }

    @Test
    void test_trueCapacity0_isEmpty() {
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>();
        Assert.assertTrue(customArrayImpl1.isEmpty());
    }

    @Test
    void test_falseCapacity10_isEmpty() {
        CustomArrayImpl<Integer> customArrayImpl0 = new CustomArrayImpl<Integer>(10);
        for (int i = 0; i < customArrayImpl0.getCapacity(); i++) { customArrayImpl0.set(i, i * 100); }
        Assert.assertFalse(customArrayImpl0.isEmpty());
    }

    @Test
    void test_falseCapacity10set5_isEmpty() {
        CustomArrayImpl<Integer> customArrayImpl0 = new CustomArrayImpl<Integer>(10);
        customArrayImpl0.set(5, 1000);
        Assert.assertFalse(customArrayImpl0.isEmpty());
    }

    @Test
    void test_Capacity0item_add() {
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>();
        Assert.assertTrue(customArrayImpl1.add(1000));
        Assert.assertEquals(customArrayImpl1.size(), 1);
        Assert.assertEquals(customArrayImpl1.getCapacity(), 5);
        Assert.assertEquals(customArrayImpl1.indexOf(1000), 0);
    }

    @Test
    void test_Capacity10Set0Add1Item_add() {
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>(10);
        customArrayImpl1.set(0, 100);
        Assert.assertTrue(customArrayImpl1.add(1000));
        Assert.assertEquals(customArrayImpl1.size(), 2);
        Assert.assertEquals(customArrayImpl1.getCapacity(), 10);
        Assert.assertEquals(customArrayImpl1.indexOf(100), 0);
        Assert.assertEquals(customArrayImpl1.indexOf(1000), 1);
    }

    @Test
    void test_Capacity10item_add() {
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>(10);
        for (int i = 0; i < 10; i++) { customArrayImpl1.set(i, (i * 10)); }
        Assert.assertTrue(customArrayImpl1.add(1000));
        Assert.assertEquals(customArrayImpl1.size(), 11);
        Assert.assertEquals(customArrayImpl1.getCapacity(), 15);
    }

    @Test
    void test_items2x4_addAll() {
        String[] string1  = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>();
        Assert.assertTrue(customArrayImpl1.addAll(string1));
        Assert.assertEquals(customArrayImpl1.get(0), "Winter");
        Assert.assertEquals(customArrayImpl1.get(1), "Spring");
        Assert.assertEquals(customArrayImpl1.get(2), "Summer");
        Assert.assertEquals(customArrayImpl1.get(3), "Autumn");
        Assert.assertEquals(customArrayImpl1.get(4), null);

        Assert.assertEquals(customArrayImpl1.getCapacity(), 5);
        Assert.assertEquals(customArrayImpl1.size(), 4);

        Assert.assertTrue(customArrayImpl1.addAll(string1));
        Assert.assertEquals(customArrayImpl1.get(4), "Winter");
        Assert.assertEquals(customArrayImpl1.get(5), "Spring");
        Assert.assertEquals(customArrayImpl1.get(6), "Summer");
        Assert.assertEquals(customArrayImpl1.get(7), "Autumn");

        Assert.assertEquals(customArrayImpl1.getCapacity(), 8);
        Assert.assertEquals(customArrayImpl1.size(), 8);

    }

    @Test
    void test_Collection_AddAll() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>();
        Assert.assertTrue(customArrayImpl1.addAll(arrayList1));
        Assert.assertTrue(customArrayImpl1.addAll(arrayList1));

        Assert.assertEquals(customArrayImpl1.get(19), "ArrayList_10");
        Assert.assertEquals(customArrayImpl1.getCapacity(), 20);
        Assert.assertEquals(customArrayImpl1.size(), 20);

        }


    @Test
    void test_indexItems_AddAll() {
        System.out.println("Создаем массив из 4-х элементов и добавляем string1 начиная с 3-го addAll(4, string1)");
        String[] string1  = new String[] {"№1", "№2", "№3", "№4"};
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(4);
        Assert.assertTrue(customArrayImpl1.addAll(3, string1));
        Assert.assertEquals(customArrayImpl1.getCapacity(), 7);
    }

    @Test
    void test_ArrayIndexOutOfBoundsException_AddAll() {
        System.out.println("Создаем массив из 4-х элементов и вызываем исключение, обращаясь к 5-му addAll(4, string1)");
        String[] string1  = new String[] {"№1", "№2", "№3", "№4"};
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(4);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                                  () -> customArrayImpl1.addAll(4, string1));
    }

    @Test
    void test_IllegalArgumentException_AddAll() {
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>();
        Assertions.assertThrows(IllegalArgumentException.class,
                                  () -> customArrayImpl1.addAll(0, null));
    }

    @Test
    void test_get0_get() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assert.assertEquals(customArrayImpl1.get(0), "ArrayList_1");
    }

    @Test
    void test_ArrayIndexOutOfBoundsException_get() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> customArrayImpl1.get(11));
    }

    @Test
    void test_set0_set() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assert.assertEquals(customArrayImpl1.set(0, "ArrayList_1_new"), "ArrayList_1");
    }

    @Test
    void test_ArrayIndexOutOfBoundsException_set() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> customArrayImpl1.set(10, "ArrayList_11_new"));
    }

    @Test
    void test_remove0_remove() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        customArrayImpl1.remove(0);
        Assert.assertEquals(customArrayImpl1.get(0), "ArrayList_2");
    }

    @Test
    void test_ArrayIndexOutOfBoundsException_remove() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> customArrayImpl1.remove(10));
    }

    @Test
    void test_removeTrue_remove() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertTrue(customArrayImpl1.remove("ArrayList_1"));
    }

    @Test
    void test_removeFalse_remove() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertFalse(customArrayImpl1.remove("ArrayList_99"));
    }

    @Test
    void test_containsTrue_contains() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertTrue(customArrayImpl1.contains("ArrayList_1"));
    }

    @Test
    void test_containsFalse_contains() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertFalse(customArrayImpl1.contains("ArrayList_99"));
    }


    @Test
    void test_indexOf0_indexOf() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertEquals(customArrayImpl1.indexOf("ArrayList_1"), 0);
    }

    @Test
    void test_indexOfNotContain_indexOf() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertEquals(customArrayImpl1.indexOf("ArrayList_99"), -1);
    }


    @Test
    void test_upTo20_ensureCapacity() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertEquals(customArrayImpl1.getCapacity(), 10);
        customArrayImpl1.ensureCapacity(20);
        Assertions.assertEquals(customArrayImpl1.getCapacity(), 20);
    }

    @Test
    void test_check10_getCapacity() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        Assertions.assertEquals(customArrayImpl1.getCapacity(), 10);
    }

    @Test
    void test_check0_reverse() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);
        customArrayImpl1.reverse();
        Assertions.assertEquals(customArrayImpl1.get(0), "ArrayList_10");
    }

    @Test
    void test_obj0_toArray() {
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_" + i); }
        CustomArrayImpl<String> customArrayImpl1 = new CustomArrayImpl<String>(arrayList1);

        Object[] obj1 = new Object[customArrayImpl1.getCapacity()];
        obj1 = customArrayImpl1.toArray();

        Assertions.assertEquals(obj1[0], "ArrayList_1");
    }
}