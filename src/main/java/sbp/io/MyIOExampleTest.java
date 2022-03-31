package sbp.io;

import java.io.IOException;

/**
 * Класс MyIOExampleTest проверяет класс MyIOExample без использования JUnit
 * @autor Sergey Proshchaev
 * @version 1.0
 * Проверки JUnit находятся в классе MyIOExampleTests
 */

public class MyIOExampleTest {

    public static void main(String[] args) throws IOException {

        MyIOExample myIOExampleObj = new MyIOExample();

        /*
         * Проверка метода workWithFile для файла несуществующего, файла существующего и дирректории
         */
        System.out.println("Результат workWithFile(txt.txt):" + myIOExampleObj.workWithFile("txt.txt"));
        System.out.println("Результат workWithFile(MyFile):" + myIOExampleObj.workWithFile("MyFile"));
        System.out.println("Результат workWithFile(src):" + myIOExampleObj.workWithFile("src"));

        /*
         * Проверка метода copyFile
         */
        System.out.println("Результат copyFile:" + myIOExampleObj.copyFile("MyFile", "MyFile_copy"));

        /*
         * Проверка метода copyBufferedFile
         */
        System.out.println("Результат copyBufferedFile:" + myIOExampleObj.copyBufferedFile("MyFile", "MyFile_copy"));

        /*
         * Проверка метода copyFileWithReaderAndWriter
         */
        System.out.println("Результат copyFileWithReaderAndWriter:" + myIOExampleObj.copyFileWithReaderAndWriter("MyFile", "MyFile_copy1"));
    }


}
