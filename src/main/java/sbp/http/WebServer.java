package sbp.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sbp.compare.PersonExceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Класс WebServer содержит методы реализации сервера, работающего по протоколу http
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
public class WebServer {

    private static final Logger logger = LoggerFactory.getLogger(WebServer.class);

    private final int port;

    /**
     * Конструктор WebServer инициализирует переменную port
     */
    public WebServer(int port) {
        this.port = port;
    }

    /**
     * Метод start запускает режим сканирования порта
     *
     * @throws IOException - при возникновении ошибок чтения и записи сокета
     *                     <p>
     *                     Сервер запускается и вызывает метод accept, блокирующий его выполнение,
     *                     как только клиент соединяется с сервером и готов с ним к обмену сообщениями - метод accept
     *                     разблокируется и возвращает сокет, который связывает клиента с сервером
     *                     В блоке try-catch-finally закрывается соединение socket.close
     */
    public void start() throws IOException {

        logger.info("WebServer started");

        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {

            Socket socket = serverSocket.accept();

            try {
                processConnection(socket);
            } catch (Exception ex) {
                ex.printStackTrace();
                logger.error("processConnection error: " + ex);
            } finally {
                socket.close();
            }
        }
    }

    /**
     * Метод processConnection производит чтение байтового потока из входящего соединения (порта)
     *
     * @param - Socket имя исходного файла
     */
    private void processConnection(Socket socket) throws Exception {

        logger.info("Method processConnection started");

        final ConcurrentMap<String, String> hashMapResponse = new ConcurrentHashMap<>();

        try (
                InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);) {

            char[] charMessage = new char[512];
            bufferedReader.read(charMessage);
            String stringRequest = String.valueOf(charMessage);

            if ((stringRequest != null) && (stringRequest.contains("HTTP/1.1"))) {

                logger.info("stringRequest=" + stringRequest);

                Runnable runnable = new Runnable() {

                    @Override
                    public synchronized void run() {
                        logger.info("start Thread");

                        try {
                            ConcurrentMap<String, String> hashMapResponseLocal = new ConcurrentHashMap<>();
                            hashMapResponseLocal = ResponseGenerator.responseGenerator(stringRequest);

                            hashMapResponse.put("Status Code", (String) hashMapResponseLocal.get("Status Code"));
                            hashMapResponse.put("Reason Phrase", (String) hashMapResponseLocal.get("Reason Phrase"));
                            hashMapResponse.put("Result", (String) hashMapResponseLocal.get("Result"));

                        } catch (PersonExceptions ex) {
                            ex.printStackTrace();
                            logger.error("Error " + ex);
                        }

                        logger.info("hashMapResponse3=" + hashMapResponse.toString());
                        logger.info("finish Thread");
                    }
                };

                Thread thread = new Thread(runnable);

                thread.start();

                thread.join();

                try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream());) {

                    printWriter.write("HTTP/1.1 " + hashMapResponse.get("Status Code") + " " + hashMapResponse.get("Reason Phrase") + "\n");
                    printWriter.write("Content-Length: " + hashMapResponse.get("Result").toString().length() + "\n");
                    printWriter.println();
                    printWriter.write(hashMapResponse.get("Result").toString());
                    printWriter.println();
                    printWriter.flush();

                    logger.info("HTTP/1.1 " + hashMapResponse.get("Status Code") + " " + hashMapResponse.get("Reason Phrase"));
                    logger.info("stringResponse=" + "Content-Length: " + hashMapResponse.get("Result").toString().length());
                    logger.info(hashMapResponse.get("Result").toString());
                }
            } else {
                logger.info("stringRequest is null");
            }

            logger.info("Method processConnection finished" + "\n");

        }
    }
}
