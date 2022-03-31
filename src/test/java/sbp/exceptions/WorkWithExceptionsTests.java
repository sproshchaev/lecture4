package sbp.exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * JUnit тестирование медодов класса WorkWithExceptions проекта lecture4
 * @autor Sergey Proshchaev
 * @version 1.0
 */

class WorkWithExceptionsTests {

    @Test
    void exceptionProcessing_RuntimeException_Test()  {

        WorkWithExceptions workWithExceptions1 = new WorkWithExceptions();
        Assertions.assertThrows(RuntimeException.class, () -> workWithExceptions1.exceptionProcessing());

    }

    @Test
    void exceptionProcessing_Exception_Test()  {

        WorkWithExceptions workWithExceptions1 = new WorkWithExceptions();
        Assertions.assertThrows(Exception.class, () -> workWithExceptions1.exceptionProcessing());

    }

}