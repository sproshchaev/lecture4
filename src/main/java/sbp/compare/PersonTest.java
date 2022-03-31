package sbp.compare;

/**
 * Класс PersonTest выполняет проверку методов класса Person
 * @autor Sergey Proshchaev
 * @version 1.0
 * Модульное тестирование JUnit находится в классе PersonTests
 * @see "PersonTests"
 */

import java.util.*;

public class PersonTest {

    public static void main(String[] args) throws PersonExceptions {

        /**
         *  Объявление экземпляров класса Person
         *  @throws PersonExceptions if ame == null  or city == null  or age == 0
         */
        Person person1 = new Person("E", "City1", 11);
        Person person2 = new Person("F", "City1", 21);
        Person person3 = new Person("D", "City1", 31);

        Person person4 = new Person("C", "City2", 12);
        Person person5 = new Person("B", "City2", 23);
        Person person6 = new Person("A", "City2", 32);

        Person person7 = new Person("A", "City3", 32);

        /**
         *  Объявление экземпляров класса Person, вызывающих исключение
         *  @throws PersonExceptions if name == null  or city == null  or age == 0
         */
        System.out.println("1) person1.toString(): " + person1.toString() + " exp.: 'Person {name=Person1, city=City1, age=11}'");

        String cityNotNull = "City";
        String nameNotNull = "Name";
        int ageNotZero = 20;
        System.out.println("2) 'Person personNameIsNull = new Person(null, cityNotNull, ageNotZero)' exp.: @throws PersonExceptions");
        System.out.println("3) 'Person personCityIsNull = new Person(nameNotNull, null, ageNotZero)' exp.: @throws PersonExceptions");
        System.out.println("4) 'Person personAgeIsZero = new Person(nameNotNull, cityNotNull, 0)' exp.: @throws PersonExceptions");

        /**
         *  Создание коллекции из пользователей
         *  person1, person2, ... person7
         */
        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(person1);
        listOfPerson.add(person2);
        listOfPerson.add(person3);
        listOfPerson.add(person4);
        listOfPerson.add(person5);
        listOfPerson.add(person6);
        listOfPerson.add(person7);

        System.out.println("5) listOfPerson before: " + listOfPerson);

        listOfPerson.sort(Person::compareTo);

        System.out.println("6) listOfPerson after: " + listOfPerson);


        /**
         *  Вызов метода toString() класса Person
         *  @return String of Object
         */
        System.out.println("7) person1.toString(): " + person1.toString() + " exp.: 'Person {name=E, city=City1, age=11}'");

        /**
         *  Вызов метода equals() класса Person
         *  @return boolean
         */
        System.out.println("8) person1.equals(null)=" + person1.equals(null) + " exp.: false");
        System.out.println("9) person1.equals(person1)=" + person1.equals(person1)  + " exp.: true");

        /**
         *  Вызов метода equals() класса Person
         *  @param Other nested class
         *  @return boolean
         */
        PersonTest.MyNestedClass myNestedClass1 = new  PersonTest.MyNestedClass();
        System.out.println("10) person1.equals(myNestedClass1)=" + person1.equals(myNestedClass1)  + " exp.: false");

        Person person1Clone = new Person("E", "City1", 11);
        System.out.println("11) person1.equals(person1Clone)=" + person1.equals(person1Clone)  + " exp.: true");

        /**
         *  Вызов метода hashCode() класса Person
         *  @return int
         */
        System.out.println("12) person1.hashCode()==person1Clone.hashCode() is " + (person1.hashCode()==person1Clone.hashCode()) +  " exp.: true");
        System.out.println("13) person1.hashCode()==person2.hashCode() is " + (person1.hashCode()==person2.hashCode()) +  " exp.: false");
        System.out.println("14) person1.hashCode()= " + person1.hashCode() +  " exp.: 2018792489");

    }

    /**
     *  Статический вложенный класс для проверки метода equals() экземпляром другого класса
     */
    public static class MyNestedClass { }

}
