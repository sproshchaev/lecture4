package sbp.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Класс WebServer реализует функционал http-сервера
 *
 * @version 1.0
 * <p>
 * Домашнее задание к занятию № 13, 14 (ДЗ №7)
 * Написать реализацию REST сервиса для работы с CRUD операциями (из ДЗ 11,12).
 * Каждый реквест к БД должен отправляться в новом потоке
 * Доступ к таблице сделать потокобезопасным (синхронизировать доступ);
 * @autor Sergey Proshchaev https://youtu.be/RBUFdFKg_rI
 */
public class WebServer2 {

    private static final Logger logger = LoggerFactory.getLogger(WebServer2.class);

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            logger.info("WebServer started");

            while (true) {
                Socket socket = serverSocket.accept();

                try (InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
                     BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                     PrintWriter output = new PrintWriter(socket.getOutputStream());) {

                    while (!bufferedReader.ready()) {
                    }

                    logger.info(bufferedReader.readLine());

                    while (bufferedReader.ready()) {
                        logger.info(bufferedReader.readLine());
                    }

                    // Ответ клиенту
                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println("");
                    output.println("<p>Hello World!</p>");
                    output.flush();

                }
            }
        } catch (IOException ex) {
            logger.error("Error: " + ex);
            ex.printStackTrace();
        }
    }

}
