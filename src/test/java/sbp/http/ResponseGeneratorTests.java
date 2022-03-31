package sbp.http;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import sbp.compare.PersonExceptions;

/**
 * Класс ResponseGeneratorTests выполняет Модульное тестирование JUnit класса ResponseGenerator
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see ResponseGenerator
 */
class ResponseGeneratorTests {

    private final String stringRequestGET = "GET /person?name=Test_name&city=Test_city&age=99 HTTP/1.1 ";
    private final String stringRequestPOST = "POST /person/addtotableperson HTTP/1.1 { \"name\": \"Test_name\", \"city\": \"Test_city\", \"age\": \"99\"}";
    private final String stringRequestPUT = "PUT /person/updatetableperson HTTP/1.1 { \"name\": \"Test_name\",\"age\": \"99\", \"city\": \"Test_city2\" }";
    private final String stringRequestDELETE = "DELETE /person/deletefromtableperson HTTP/1.1 { \"name\": \"Test_name\", \"city\": \"Test_city\", \"age\": \"99\"}";
    private final String stringRequestDELETE2 = "DELETE /person/deletefromtableperson HTTP/1.1 { \"name\": \"Test_name\", \"city\": \"Test_city2\", \"age\": \"99\"}";

    /**
     * Метод responseGenerator_SuccessfulGET_PersonNotFound_Test() выполняет Модульное тестирование JUnit
     * метода GET responseGenerator класса ResponseGenerator
     */
    @Test
    void responseGenerator_SuccessfulGET_PersonNotFound_Test() throws PersonExceptions {

        String resultExpectedPOST = "{Status Code=201, Reason Phrase=OK, Result=Person has been added}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestPOST).toString(), resultExpectedPOST);

        String resultExpectedGET = "{Status Code=200, Reason Phrase=OK, Result=[Person {name=Test_name, city=Test_city, age=99}]}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestGET).toString(), resultExpectedGET);

        String resultExpectedDELETE = "{Status Code=200, Reason Phrase=OK, Result=Person Person {name=Test_name, city=Test_city, age=99} has been deleted}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestDELETE).toString(), resultExpectedDELETE);

    }

    /**
     * Метод responseGenerator_SuccessfulPOST_Test() выполняет Модульное тестирование JUnit
     * метода GET responseGenerator класса ResponseGenerator
     */
    @Test
    void responseGenerator_SuccessfulPOST_Test() throws PersonExceptions {

        String resultExpectedPOST = "{Status Code=201, Reason Phrase=OK, Result=Person has been added}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestPOST).toString(), resultExpectedPOST);

        String resultExpectedDELETE = "{Status Code=200, Reason Phrase=OK, Result=Person Person {name=Test_name, city=Test_city, age=99} has been deleted}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestDELETE).toString(), resultExpectedDELETE);
    }

    /**
     * Метод responseGenerator_SuccessfulPUT_Test() выполняет Модульное тестирование JUnit
     * метода GET responseGenerator класса ResponseGenerator
     */
    @Test
    void responseGenerator_SuccessfulPUT_Test() throws PersonExceptions {

        String resultExpectedPOST = "{Status Code=201, Reason Phrase=OK, Result=Person has been added}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestPOST).toString(), resultExpectedPOST);

        String resultExpectedPUT = "{Status Code=200, Reason Phrase=OK, Result=Person has been updated}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestPUT).toString(), resultExpectedPUT);

        String resultExpectedDELETE2 = "{Status Code=200, Reason Phrase=OK, Result=Person Person {name=Test_name, city=Test_city2, age=99} has been deleted}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestDELETE2).toString(), resultExpectedDELETE2);
    }

    /**
     * Метод responseGenerator_SuccessfulDELETE_Test() выполняет Модульное тестирование JUnit
     * метода GET responseGenerator класса ResponseGenerator
     */
    @Test
    void responseGenerator_SuccessfulDELETE_Test() throws PersonExceptions {

        String resultExpectedPOST = "{Status Code=201, Reason Phrase=OK, Result=Person has been added}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestPOST).toString(), resultExpectedPOST);

        String resultExpectedDELETE = "{Status Code=200, Reason Phrase=OK, Result=Person Person {name=Test_name, city=Test_city, age=99} has been deleted}";
        Assert.assertEquals(ResponseGenerator.responseGenerator(stringRequestDELETE).toString(), resultExpectedDELETE);
    }

}