package sbp.http;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sbp.jdbc.PersonDAO;

import java.io.IOException;

/**
 * Класс WebServerTests выполняет Модульное тестирование JUnit класса WebServer
 * @author Sergey Proshchaev
 * @version 1.0
 * @see WebServer
 */
class WebServerTests {

    /**
     * Метод createTable_SuccessfulCrNewTable_Test() выполняет Модульное тестирование JUnit
     * для тестирования со стороны приложения выполняется запуск из Postman строки http://localhost:8080/
     */
    @Test
    void startWebServer_Successful_Test() throws IOException {

        WebServer webServer = new WebServer(8080);
        webServer.start();

    }



}