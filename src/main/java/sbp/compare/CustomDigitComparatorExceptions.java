package sbp.compare;

public class CustomDigitComparatorExceptions extends Throwable {
    /**
     * Класс CustomDigitComparatorExceptions содержит обработку исключений класса CustomDigitComparator
     * @autor Sergey Proshchaev
     * @version 1.0
     */
    public CustomDigitComparatorExceptions(String message) {
        super("CustomDigitComparator: " + message);
    }


}
