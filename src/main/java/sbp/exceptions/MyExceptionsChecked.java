package sbp.exceptions;

/**
 * Класс кастомных проверяемых исключений MyExceptionsChecked
 * @autor Sergey Proshchaev
 * @version 1.0
 */

public class  MyExceptionsChecked extends Exception {

    public MyExceptionsChecked(String message, Throwable cause) {

        super("Возникло Checked исключение: " + message, cause);

    }
}
