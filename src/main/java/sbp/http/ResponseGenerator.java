package sbp.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sbp.compare.Person;
import sbp.compare.PersonExceptions;
import sbp.jdbc.PersonDAO;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Класс ResponseGenerator содержит методы, обрабатывающие GET, POST, PUT, DELETE запросы, получаемые сервером
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
public class ResponseGenerator {

    private static final Logger logger = LoggerFactory.getLogger(ResponseGenerator.class);

    /**
     * Метод responseGenerator анализирует содержание строки запроса stringRequest на наличие GET, POST, PUT, DELETE
     * и вызывает соответствующие методы getRequestProcessing, postRequestProcessing, deleteRequestProcessing
     *
     * @param - String строка запроса
     * @return - HashMap с содержанием полей ответа Status Code, Reason Phrase, Result
     */
    public static ConcurrentHashMap<String, String> responseGenerator(String stringRequest) throws PersonExceptions {

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Status Code", "501");
        concurrentHashMap.put("Reason Phrase", "Not Implemented");
        concurrentHashMap.put("Result", "Request type is not defined!");

        if (stringRequest.substring(0, 3).equals("GET")) {
            concurrentHashMap = (ConcurrentHashMap<String, String>) getRequestProcessing(stringRequest);
        }

        if (stringRequest.substring(0, 4).equals("POST")) {
            concurrentHashMap = (ConcurrentHashMap<String, String>) postRequestProcessing(stringRequest);
        }

        if (stringRequest.substring(0, 6).equals("DELETE")) {
            concurrentHashMap = (ConcurrentHashMap<String, String>) deleteRequestProcessing(stringRequest);
        }

        if (stringRequest.substring(0, 3).equals("PUT")) {
            concurrentHashMap = (ConcurrentHashMap<String, String>) putRequestProcessing(stringRequest);
        }

        return concurrentHashMap;
    }

    /**
     * Метод getRequestProcessing получает на вход строку запроса метода GET, осуществляет добавление пользователя в
     * таблицу addtotableperson и формирует ответ Status Code,
     * Reason Phrase, Result
     *
     * @param - String строка запроса
     * @return - HashMap с полями ответа Status Code, Reason Phrase, Result
     */
    private static Map<String, String> getRequestProcessing(String stringRequest) throws PersonExceptions {

        logger.info("GET identified");

        String resultSelectFromTablePerson = "";

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Status Code", "501");
        concurrentHashMap.put("Reason Phrase", "Not Implemented");
        concurrentHashMap.put("Result", "Request type is not defined!");

        logger.info("GET parameters name: " + getValueFromGETStringRequest(stringRequest, "name") + " city: " + getValueFromGETStringRequest(stringRequest, "city") + " age: " + getValueFromGETStringRequest(stringRequest, "age"));

        if (!getValueFromGETStringRequest(stringRequest, "name").equals("")) {

            PersonDAO personDAO = new PersonDAO();

            resultSelectFromTablePerson = personDAO.selectFromTablePerson(getValueFromGETStringRequest(stringRequest, "name"),
                    Integer.parseInt(getValueFromGETStringRequest(stringRequest, "age")),
                    getValueFromGETStringRequest(stringRequest, "city")).toString();

            if (!resultSelectFromTablePerson.equals("")) {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", resultSelectFromTablePerson);
            } else {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person not found!");
            }
        }

        logger.info("Method getRequestProcessing completed");

        return concurrentHashMap;
    }

    /**
     * Метод postRequestProcessing получает на вход строку запроса метода POST, осуществляет добавление пользователя в
     * таблицу addtotableperson и формирует ответ Status Code,
     * Reason Phrase, Result
     *
     * @param - String строка запроса
     * @return - HashMap с полями ответа Status Code, Reason Phrase, Result
     */
    private static ConcurrentHashMap<String, String> postRequestProcessing(String stringRequest) throws PersonExceptions {

        logger.info("POST identified");

        boolean resultAddToTablePerson = false;

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Status Code", "501");
        concurrentHashMap.put("Reason Phrase", "Not Implemented");
        concurrentHashMap.put("Result", "Request type is not defined!");

        if (stringRequest.contains("addtotableperson")) {

            PersonDAO personDAO = new PersonDAO();
            Person person1 = new Person(getFromStringRequest(stringRequest, "name"),
                    getFromStringRequest(stringRequest, "city"),
                    Integer.parseInt(getFromStringRequest(stringRequest, "age")));

            resultAddToTablePerson = personDAO.addToTablePerson(person1);

            if (resultAddToTablePerson) {
                concurrentHashMap.put("Status Code", "201");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person has been added");
            } else {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person not added!");
            }
        }

        logger.info("Method postRequestProcessing completed");

        return concurrentHashMap;
    }

    /**
     * Метод deleteRequestProcessing получает на вход строку запроса метода POST, осуществляет удаление пользователя из
     * таблицы addtotableperson и формирует ответ Status Code,
     * Reason Phrase, Result
     *
     * @param - String строка запроса
     * @return - HashMap с полями ответа Status Code, Reason Phrase, Result
     */
    private static ConcurrentHashMap<String, String> deleteRequestProcessing(String stringRequest) throws PersonExceptions {

        logger.info("DELETE identified");

        boolean resultDeleteFromTablePerson = false;

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Status Code", "501");
        concurrentHashMap.put("Reason Phrase", "Not Implemented");
        concurrentHashMap.put("Result", "Request type is not defined!");

        if (stringRequest.contains("deletefromtableperson")) {

            PersonDAO personDAO = new PersonDAO();
            Person person1 = new Person(getFromStringRequest(stringRequest, "name"),
                    getFromStringRequest(stringRequest, "city"),
                    Integer.parseInt(getFromStringRequest(stringRequest, "age")));

            resultDeleteFromTablePerson = personDAO.deleteFromTablePerson(person1);

            if (resultDeleteFromTablePerson) {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person " + person1.toString() + " has been deleted");
            } else {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person not deleted!");
            }

            logger.info("Thread in method deleteRequestProcessing completed");

        }

        logger.info("Method deleteRequestProcessing completed");

        return concurrentHashMap;
    }

    /**
     * Метод putRequestProcessing2 в качестве параметра получает строку запроса к серверу методом PUT
     * и возвращает коллекцию ConcurrentHashMap с полями ответа клиенту
     *
     * @param - String строка запроса к серверу с методом PUT
     * @return - ConcurrentHashMap
     */
    private static ConcurrentHashMap<String, String> putRequestProcessing(String stringRequest) {

        logger.info("PUT identified");

        boolean resultUpdateTablePerson = false;

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Status Code", "501");
        concurrentHashMap.put("Reason Phrase", "Not Implemented");
        concurrentHashMap.put("Result", "Request type is not defined!");

        if (stringRequest.contains("updatetableperson")) {

            PersonDAO personDAO = new PersonDAO();

            resultUpdateTablePerson = personDAO.updateTablePerson(getFromStringRequest(stringRequest, "name"),
                    Integer.parseInt(getFromStringRequest(stringRequest, "age")),
                    getFromStringRequest(stringRequest, "city"));

            if (resultUpdateTablePerson) {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person has been updated");
            } else {
                concurrentHashMap.put("Status Code", "200");
                concurrentHashMap.put("Reason Phrase", "OK");
                concurrentHashMap.put("Result", "Person not updated!");
            }

            logger.info("Thread in method putRequestProcessing completed");

        }

        logger.info("Method putRequestProcessing completed");

        return concurrentHashMap;
    }


    /**
     * Метод getFromStringRequest преобразует строку запроса от клиента в массив строк и получает из данного массива
     * значение параметра
     *
     * @param - String строка запроса от клиента
     * @param - String параметр
     * @return - String значение параметра
     */
    private static String getFromStringRequest(String stringRequest, String param) {

        String resultParam = "";
        String[] arrayString = stringRequest.split("\"");

        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].equals(param)) {
                resultParam = arrayString[i + 2];
                break;
            }
        }
        return resultParam;
    }


    /**
     * Метод getValueFromGETStringRequest преобразует строку запроса от клиента полученную методом GET и query-параметрами
     * и возвращает значение параметра
     *
     * @param - String строка запроса от клиента
     * @param - String параметр
     * @return - String значение параметра
     */
    private static String getValueFromGETStringRequest(String stringRequest, String param) {

        String paramName = param;
        String resultGetValueFromGETStringRequest = "";

        String[] arrayString = stringRequest.split(" ");

        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].contains("/person?")) {

                String[] arrayGetString = arrayString[i].split("&");
                for (int j = 0; j < arrayGetString.length; j++) {

                    String[] arrayParamString = arrayGetString[j].split("=");
                    for (int k = 0; k < arrayParamString.length; k++) {

                        if (arrayParamString[k].contains(paramName)) {
                            resultGetValueFromGETStringRequest = arrayParamString[k + 1];
                        }
                        break;
                    }
                }
                break;
            }

        }
        return resultGetValueFromGETStringRequest;

    }

}
