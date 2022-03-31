package sbp.nio2;

/**
 * Класс MyNIO2Exception содержит методы обработки исключений класса MyNIO2Example
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
public class MyNIO2Exception extends Throwable {

    public MyNIO2Exception(String message) {
        super("MyNIO2Exception: " + message);
    }

}
