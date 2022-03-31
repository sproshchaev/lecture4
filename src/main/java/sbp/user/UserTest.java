package sbp.user;

/**
 * Класс UserTest проверяет класс User без использования JUnit
 * @autor Sergey Proshchaev
 * @version 1.0
 * Проверки JUnit находятся в классе UserTests
 * @see UserTests
 */

import java.util.Date;

public class UserTest {

    public static void main(String[] args) {

        System.out.println("Регистрация нового пользователя...");

        Date dateOfbirth = new Date("12/11/1993");
        User userOne = new User("Ivan", "Ivanovich", "Ivanov", dateOfbirth, "+7922123456", "iivanov", "123456");
        System.out.println("Новый пользователь " + userOne.getLogin() + " зарегистрирован!");
        System.out.println("");

        System.out.println("Изменение учетных данных для пользователя " + userOne.getName() + " " + userOne.getName().substring(0, 1) + "." + userOne.getSurName().substring(0, 1) + "." + ":");
        userOne.setLogin("iiivanov");
        userOne.setPassword("654321");
        System.out.println("завершено!");

        System.out.println("");
        System.out.println("Метод toString(): " + userOne.toString());

        System.out.println("");
        User userTwo = new User("Ivan", "Ivanovich", "Ivanov", dateOfbirth, "+7922123456", "iiivanov", "654321");
        User userThree = new User("Petr", "Petrovich", "Petrov", dateOfbirth, "+7922123457", "pppetrov", "987654");
        System.out.println("userOne = userTwo Метод equals(): " + userOne.equals(userTwo));
        System.out.println("userOne != userThree Метод equals(): " + userOne.equals(userThree));
        System.out.println("");

        System.out.println("userOne.toString() = "+userOne.toString());
        System.out.println("");
        System.out.println("userOne.hashCode() = "+userOne.hashCode());
    }

}
