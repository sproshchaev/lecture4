package sbp.jdbc;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sbp.compare.Person;
import sbp.compare.PersonExceptions;

/**
 * Класс PersonDAOTests выполняет Модульное тестирование JUnit класса PersonDAO
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see PersonDAO
 */
class PersonDAOTests {

    /**
     * Метод addToTablePersonData() в таблицу "Test_name" добавляет экземпляр класса Person
     */
    private static void addToTablePersonData() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        Person person1 = new Person("Test_name", "Test_city", 99);
        personDAO.addToTablePerson(person1);
    }

    /**
     * Метод deleteFromTablePerson() удаляет таблицу "Test_name"
     */
    private static void deleteFromTablePerson() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        Person person2 = new Person("Test_name", "Test_city2", 99);
        personDAO.deleteFromTablePerson(person2);
    }

    /**
     * Метод createTablePerson() создает таблицу "Person_test"
     */
    private static void createTablePerson() {
        PersonDAO personDAO = new PersonDAO();
        personDAO.createTable("Person_test", "name", "varchar(32)",
                "city", "varchar(32)",
                "age", "integer");
    }

    /**
     * Метод createTable_SuccessfulCrNewTable_Test() выполняет Модульное тестирование JUnit
     * метода createTable() класса PersonDAO
     * Успешное создание таблицы Person_test
     */
    @Test
    void createTable_SuccessfulCrNewTable_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertTrue(personDAO.createTable("Person_test", "name", "varchar(32)",
                "city", "varchar(32)",
                "age", "integer"));
        personDAO.dropTable("Person_test");
    }

    /**
     * Метод createTable_FailCrNewTable_Test() выполняет Модульное тестирование JUnit
     * метода createTable() класса PersonDAO
     * Неудачное создание таблицы Person_test, таблица Person_test уже существует
     */
    @Test
    void createTable_FailCrNewTable_Test() {
        PersonDAO personDAO = new PersonDAO();
        createTablePerson();
        Assertions.assertFalse(personDAO.createTable("Person_test", "name", "varchar(32)",
                "city", "varchar(32)",
                "age", "integer"));
        personDAO.dropTable("Person_test");
    }

    /**
     * Метод dropTable_SuccessfulDropTable_Test выполняет Модульное тестирование JUnit
     * метода dropTable класса PersonDAO
     * Метод создает и успешно удаляет тестовую таблицу Person_test
     */
    @Test
    void dropTable_SuccessfulDropTable_Test() {
        PersonDAO personDAO = new PersonDAO();
        createTablePerson();
        Assertions.assertTrue(personDAO.dropTable("Person_test"));
    }

    /**
     * Метод dropTable_FailDropTable_Test выполняет Модульное тестирование JUnit
     * метода dropTable класса PersonDAO
     * Метод пытается удалить таблицу с именем TableNotFound, которая не существует
     */
    @Test
    void dropTable_FailDropTable_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertFalse(personDAO.dropTable("TableNotFound"));
    }

    /**
     * Метод addToTablePerson_Successful_Test() выполняет Модульное тестирование JUnit
     * метода addToTablePerson класса PersonDAO
     * Метод успешно добавляет новую запись в таблицу Person
     */
    @Test
    void addToTablePerson_Successful_Test() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        Person person1 = new Person("Test_name", "Test_city", 99);
        Assertions.assertTrue(personDAO.addToTablePerson(person1));
        Assertions.assertTrue(personDAO.deleteFromTablePerson(person1));
    }

    /**
     * Метод addToTablePerson_FailIllegalArgumentException_Test() выполняет Модульное тестирование JUnit
     * метода addToTablePerson класса PersonDAO
     * Метод пытается передать null в addToTablePerson в качестве аргумента
     * и вызывает исключение IllegalArgumentException
     */
    @Test
    void addToTablePerson_FailIllegalArgumentException_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertThrows(IllegalArgumentException.class, () -> personDAO.addToTablePerson(null));
    }

    /**
     * Метод deleteFromTablePerson_Successful_Test() выполняет Модульное тестирование JUnit
     * метода deleteFromTablePerson класса PersonDAO
     * Метод успешно удаляет запись из таблицы Person
     */
    @Test
    void deleteFromTablePerson_Successful_Test() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        Person person1 = new Person("Test_name", "Test_city", 99);
        Assertions.assertTrue(personDAO.addToTablePerson(person1));
        Assertions.assertTrue(personDAO.deleteFromTablePerson(person1));
    }

    /**
     * Метод deleteFromTablePerson_FailIllegalArgumentException_Test() выполняет Модульное тестирование JUnit
     * метода deleteFromTablePerson класса PersonDAO
     * Метод пытается передать null в deleteFromTablePerson в качестве аргумента
     * и вызывает исключение IllegalArgumentException
     */
    @Test
    void deleteFromTablePerson_FailIllegalArgumentException_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertThrows(IllegalArgumentException.class, () -> personDAO.deleteFromTablePerson(null));
    }

    /**
     * Метод deleteFromTablePerson_FailPersonNotFound_Test() выполняет Модульное тестирование JUnit
     * метода deleteFromTablePerson класса PersonDAO
     * Метод пытается удалить запись из таблицы Person, которой нет в таблице
     */
    @Test
    void deleteFromTablePerson_FailPersonNotFound_Test() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        Person person1 = new Person("Test_name", "Test_city", 99);
        Assertions.assertFalse(personDAO.deleteFromTablePerson(person1));
    }

    /**
     * Метод updateTablePerson_Successful_Test() выполняет Модульное тестирование JUnit
     * метода updateTablePerson класса PersonDAO
     * Метод успешно удаляет запись из таблицы Person
     */
    @Test
    void updateTablePerson_Successful_Test() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        addToTablePersonData();
        Assertions.assertTrue(personDAO.updateTablePerson("Test_name", 99, "Test_city2"));
        deleteFromTablePerson();
    }

    /**
     * Метод updateTablePerson_FailPersonNotFound_Test() выполняет Модульное тестирование JUnit
     * метода updateTablePerson класса PersonDAO
     * Метод успешно удаляет запись из таблицы Person
     */
    @Test
    void updateTablePerson_FailPersonNotFound_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertFalse(personDAO.updateTablePerson("PersonNotFound", 99, "Test_city2"));
    }

    /**
     * Метод updateTablePerson_FailIllegalArgumentException_Test() выполняет Модульное тестирование JUnit
     * метода deleteFromTablePerson класса PersonDAO
     * Метод пытается передать null в updateTablePerson в качестве аргументов name и age
     * и вызывает исключение IllegalArgumentException
     */
    @Test
    void updateTablePerson_FailIllegalArgumentException_Test() {
        PersonDAO personDAO = new PersonDAO();
        Assertions.assertThrows(IllegalArgumentException.class, () -> personDAO.updateTablePerson(null, 99, "Test_city2"));
    }

    /**
     * Метод selectFromTablePerson_Success_Test() выполняет Модульное тестирование JUnit
     * метода selectFromTablePerson класса PersonDAO
     * Метод передает в качестве аргументов name, age, city
     * и получает коллекцию из элементов класса Person, соответствующих заданным параметрам.
     * Предварительно перед тестом в таблицу Person добавляется пользователь ("Test_name", "Test_city", 99)
     * и после тестирования удаляется
     */
    @Test
    void selectFromTablePerson_Success_Test() throws PersonExceptions {
        PersonDAO personDAO = new PersonDAO();
        addToTablePersonData();
        String resultExpected = "[Person {name=Test_name, city=Test_city, age=99}]";
        Assert.assertEquals(personDAO.selectFromTablePerson("Test_name", 99, "Test_city").toString(), resultExpected);
        deleteFromTablePerson();
    }

    /**
     * Метод selectFromTablePerson_PersonNotFound_Test() выполняет Модульное тестирование JUnit
     * метода selectFromTablePerson класса PersonDAO
     * Метод передает в качестве аргументов name, age, city
     * и получает коллекцию из элементов класса Person, соответствующих заданным параметрам.
     * В методе selectFromTablePerson_SuccessPersonNotFound_Test формируется запрос на получения коллекции
     * с данными пользователя класса Person, которого нет в таблице Person, в результате метод
     * возвращает пустую коллекцию
     */
    @Test
    void selectFromTablePerson_SuccessPersonNotFound_Test() {
        PersonDAO personDAO = new PersonDAO();
        String resultExpected = "[]";
        Assert.assertEquals(personDAO.selectFromTablePerson("PersonNotFound", 99, "Test_city").toString(), resultExpected);
    }

}