package sbp.collections;

import java.util.ArrayList;

/**
 * Класс CustomArrayImplTest проверяет класс CustomArrayImpl<T> без использования JUnit
 * @autor Sergey Proshchaev
 * @version 1.0
 * Проверки JUnit находятся в классе CustomArrayImplTest
 * @see CustomArrayImplTest
 *
 *     1) CustomArrayImpl()
 *     2) CustomArrayImpl(int capacity)
 *     3) CustomArrayImpl(Collection<T> c)
 *     4) public int size()
 *     5) public boolean isEmpty()
 *     6) public boolean add(T item)
 *     7) public boolean addAll(T[] items)
 *     8) public boolean addAll(Collection<T> items)
 *     9) public boolean addAll(int index, T[] items)
 *     10) public T get(int index)
 *     11) public T set(int index, T item)
 *     12) public void remove(int index)
 *     13) public boolean remove(T item)
 *     14) public boolean contains(T item)
 *     15) public int indexOf(T item)
 *     16) public void ensureCapacity(int newElementsCount)
 *     17) public int getCapacity()
 *     18) public void reverse()
 *     19) public Object[] toArray()
 */


public class CustomArrayImplTests {

    public static void main(String[] args) {

        System.out.println("Тестирование работы класса CustomArrayImpl<T>:");
        System.out.println("----------------------------------------------");

        System.out.println("1) Конструктор класса CustomArrayImpl()");
        CustomArrayImpl<Integer> customArrayImpl1 = new CustomArrayImpl<Integer>(10);
        System.out.println("Массив customArrayImpl1: размер " + customArrayImpl1.getCapacity()
                + ". Массив пустой=" + customArrayImpl1.isEmpty()
                  + ". getCapacity()=" + customArrayImpl1.getCapacity());
        System.out.println("Заполнение элементами...");
        int currArraySize1 = customArrayImpl1.getCapacity();
        for (int i = 0; i < currArraySize1; i++) {
            customArrayImpl1.set(i, i * 100);
        }
        System.out.println("Массив заполнен!");

        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl1.getCapacity(); i++) {
            System.out.print(customArrayImpl1.get(i));
            if (i < customArrayImpl1.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("indexOf(300)=" + customArrayImpl1.indexOf(300) + ", ");
        System.out.println("");

        System.out.println("2) Конструктор класса CustomArrayImpl(int capacity)");
        CustomArrayImpl<String> customArrayImpl2 = new CustomArrayImpl<String>(10);
        System.out.println("Массив customArrayImpl2: размер " + customArrayImpl2.getCapacity()
                             + ". Массив пустой=" + customArrayImpl2.isEmpty()
                               + ". getCapacity()=" + customArrayImpl2.getCapacity());
        System.out.println("Заполнение элементами...");
        for (int i = 0; i < 10; i++) {
            customArrayImpl2.set(i, "Строка " + i);
        }
        System.out.println("Массив заполнен!");
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl2.getCapacity(); i++) {
            System.out.print(customArrayImpl2.get(i));
            if (i < customArrayImpl2.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("indexOf(Строка 4)=" + customArrayImpl2.indexOf("Строка 4"));
        System.out.println("");

        System.out.println("3) Конструктор класса CustomArrayImpl(Collection<T> c)");
        ArrayList<String> arrayList1 = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) { arrayList1.add("ArrayList_2." + i); }
        CustomArrayImpl<String> customArrayImpl3 = new CustomArrayImpl<String>(arrayList1);
        System.out.println("Массив customArrayImpl3: размер " + customArrayImpl3.getCapacity()
                + ". Массив пустой=" + customArrayImpl3.isEmpty()
                + ". getCapacity()=" + customArrayImpl3.getCapacity());
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("4) public int size()");
        System.out.println("Массив customArrayImpl1: размер " + customArrayImpl1.size());
        System.out.println("Массив customArrayImpl2: размер " + customArrayImpl2.size());
        System.out.println("Массив customArrayImpl3: размер " + customArrayImpl3.size());
        System.out.println("");

        System.out.println("5) public boolean isEmpty()");
        System.out.println("Массив customArrayImpl1: isEmpty()=" + customArrayImpl1.isEmpty());
        System.out.println("Массив customArrayImpl2: isEmpty()=" + customArrayImpl2.isEmpty());
        System.out.println("Массив customArrayImpl3: isEmpty()=" + customArrayImpl3.isEmpty());
        System.out.println("");

        System.out.println("6) public boolean add(T item)");
        System.out.println("customArrayImpl3.add(\"!\")=" + customArrayImpl3.add("!"));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("7) public boolean addAll(T[] items)");
        System.out.println("addAll(\"Winter\", \"Spring\", \"Summer\", \"Autumn\")");
        String[] string1  = new String[] {"Winter", "Spring", "Summer", "Autumn"};
        customArrayImpl3.addAll(string1);
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");


        System.out.println("8) public boolean addAll(Collection<T> items)");
        ArrayList<String> arrayList2 = new ArrayList<String>();
        for (int i = 1; i <= 3; i ++) { arrayList2.add("ArrayList " + i); }
        customArrayImpl3.addAll(arrayList2);
        System.out.print("Элементы массива (из ArrayList): ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("9) public boolean addAll(int index, T[] items)");
        System.out.println("addAll(int index = 3, T[] items = \"№1\", \"№2\", \"№3\", \"№4\")");
        String[] string2  = new String[] {"№1", "№2", "№3", "№4"};
        customArrayImpl3.addAll(3, string2);
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("10) public T get(int index)");
        System.out.println("get(2)= " + customArrayImpl3.get(2));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("11) public T set(int index, T item)");
        System.out.println("T set(2, \"№0\")= " + customArrayImpl3.set(2, "№0"));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");


        System.out.println("12) public void remove(int index)");
        System.out.println("remove(2)");
        customArrayImpl3.remove(2);
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("13) public boolean remove(T item)");
        System.out.println("remove(\"ArrayList_2.1\")=" + customArrayImpl3.remove("ArrayList_2.1"));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");


        System.out.println("14) public boolean contains(T item)");
        System.out.println("contains(\"№1\")=" + customArrayImpl3.contains("№1"));
        System.out.println("contains(\"№99\")=" + customArrayImpl3.contains("№99"));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("15) public int indexOf(T item)");
        System.out.println("indexOf(\"№1\")=" + customArrayImpl3.indexOf("№1"));
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("16) public void ensureCapacity(int newElementsCount)");
        System.out.println("Изменение емкости -> ensureCapacity(10)");
        customArrayImpl3.ensureCapacity(10);
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");


        System.out.println("17) public int getCapacity()");
        System.out.println("getCapacity(customArrayImpl1)=" + customArrayImpl1.getCapacity());
        System.out.println("getCapacity(customArrayImpl2)=" + customArrayImpl2.getCapacity());
        System.out.println("getCapacity(customArrayImpl3)=" + customArrayImpl3.getCapacity());
        System.out.println("");

        System.out.println("18) public void reverse()");
        customArrayImpl3.reverse();
        System.out.print("Элементы массива: ");
        for (int i = 0; i < customArrayImpl3.getCapacity(); i++) {
            System.out.print(customArrayImpl3.get(i));
            if (i < customArrayImpl3.getCapacity() - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("19) public Object[] toArray()");
        System.out.println("toArray()");
        Object[] obj1 = new Object[customArrayImpl2.getCapacity()];
        obj1 = customArrayImpl3.toArray();
        System.out.print("Элементы массива obj1: ");
        for (int i = 0; i < obj1.length; i++) {
            System.out.print(obj1[i]);
            if (i < obj1.length - 1) { System.out.print(", "); } else { System.out.println("."); }
        }
        System.out.println("");

        System.out.println("----------------------------------------------");

    }

}
