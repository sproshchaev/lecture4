package sbp.compare;

/**
 * Класс PersonExceptions содержит обработку исключений класса Person
 * @autor Sergey Proshchaev
 * @version 1.0
 */

public class PersonExceptions extends Exception {

    public PersonExceptions(String message) {
        super("PersonExceptions: " + message);
    }
}
