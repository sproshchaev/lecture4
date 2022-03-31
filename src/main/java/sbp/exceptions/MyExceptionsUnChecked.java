package sbp.exceptions;

/**
 * Класс кастомных непроверяемых исключений MyExceptionsUnChecked
 * @autor Sergey Proshchaev
 * @version 1.0
 */

public class MyExceptionsUnChecked extends RuntimeException {

    public MyExceptionsUnChecked(String message, Throwable cause) {

        super("Возникло Unchecked исключение: " + message, cause);

    }
}

