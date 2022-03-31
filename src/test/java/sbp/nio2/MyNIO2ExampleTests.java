package sbp.nio2;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.deleteIfExists;
import static java.nio.file.Files.exists;

/**
 * Класс MyNIO2ExampleTests выполняет Модульное тестирование JUnit класса MyNIO2Example
 *
 * @author Sergey Proshchaev
 * @version 1.0
 * @see MyNIO2Example
 */
class MyNIO2ExampleTests {

    /**
     * Метод deleteIfExistsFile() удаляет файл если файл существует
     *
     * @param String имя файла
     */
    private static void deleteIfExistsFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            if (exists(path)) {
                deleteIfExists(path);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод createFileIfNotExists() создает файл
     *
     * @param String имя файла
     */
    private static void createFileIfNotExists(String fileName) {
        Path path = Paths.get(fileName);
        try {
            if (!exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод createDirIfNotExists() создает дирректорию
     *
     * @param String имя дирректории
     */
    private static void createDirIfNotExists(String fileName) {
        Path path = Paths.get(fileName);
        try {
            if (!exists(path)) {
                Files.createDirectory(path);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Метод workWithFileNIO2_SuccessfulCreateFile_Test() выполняет Модульное тестирование JUnit
     * метода workWithFileNIO2 класса MyNIO2Example
     */
    @Test
    void workWithFileNIO2_SuccessfulCreateFile_Test() throws MyNIO2Exception {
        String fileName = "file_nio2.txt";
        deleteIfExistsFile(fileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertTrue(myNIO2Example1.workWithFileNIO2(fileName));
    }

    /**
     * Метод workWithFileNIO2_SuccessfulFileExists_Test() выполняет Модульное тестирование JUnit
     * метода workWithFileNIO2 класса MyNIO2Example
     */
    @Test
    void workWithFileNIO2_SuccessfulFileExists_Test() throws MyNIO2Exception {
        String fileName = "file_nio2.txt";
        createFileIfNotExists(fileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertFalse(myNIO2Example1.workWithFileNIO2(fileName));
    }

    /**
     * Метод workWithFileNIO2_SuccessfulDirectoryExists_Test() выполняет Модульное тестирование JUnit
     * метода workWithFileNIO2 класса MyNIO2Example
     */
    @Test
    void workWithFileNIO2_SuccessfulDirectoryExists_Test() throws MyNIO2Exception {
        String fileName = "c:/work";
        createDirIfNotExists(fileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertFalse(myNIO2Example1.workWithFileNIO2(fileName));
    }

    /**
     * Метод workWithFileNIO2_FailParamIsNull_Test() выполняет Модульное тестирование JUnit
     * метода workWithFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если входящий параметр null
     */

    @Test
    void workWithFileNIO2_FailParamIsNull_Test() {
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.workWithFileNIO2(null));
    }

    /**
     * Метод copyFileNIO2_SuccessfulCopy_Test() выполняет Модульное тестирование JUnit
     * метода copyFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileNIO2_SuccessfulCopy_Test() throws MyNIO2Exception {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = "file_nio2_w.txt";
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertTrue(myNIO2Example1.copyFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyFileNIO2_FailedSourceFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileNIO2_FailedSourceFileNameIsNull_Test() {
        String sourceFileName = null;
        String destinationFileName = "file_nio2_w.txt";
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyFileNIO2_FailedDestinationFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileNIO2_FailedDestinationFileNameIsNull_Test() {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = null;
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyBufferedFileNIO2_SuccessfulCopy_Test() выполняет Модульное тестирование JUnit
     * метода copyBufferedFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyBufferedFileNIO2_SuccessfulCopy_Test() throws MyNIO2Exception {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = "file_nio2_w.txt";
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertTrue(myNIO2Example1.copyBufferedFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyBufferedFileNIO2_FailedSourceFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyBufferedFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyBufferedFileNIO2_FailedSourceFileNameIsNull_Test() {
        String sourceFileName = null;
        String destinationFileName = "file_nio2_w.txt";
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyBufferedFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyBufferedFileNIO2_FailedDestinationFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyBufferedFileNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */

    @Test
    void copyBufferedFileNIO2_FailedDestinationFileNameIsNull_Test() {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = null;
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyBufferedFileNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyFileWithReaderAndWriterNIO2_SuccessfulCopy_Test() выполняет Модульное тестирование JUnit
     * метода copyFileWithReaderAndWriterNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileWithReaderAndWriterNIO2_SuccessfulCopy_Test() throws MyNIO2Exception {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = "file_nio2_w.txt";
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assert.assertTrue(myNIO2Example1.copyFileWithReaderAndWriterNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyFileWithReaderAndWriterNIO2_FailedSourceFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyFileWithReaderAndWriterNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileWithReaderAndWriterNIO2_FailedSourceFileNameIsNull_Test() {
        String sourceFileName = null;
        String destinationFileName = "file_nio2_w.txt";
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyFileWithReaderAndWriterNIO2(sourceFileName, destinationFileName));
    }

    /**
     * Метод copyFileWithReaderAndWriterNIO2_FailedDestinationFileNameIsNull_Test() выполняет Модульное тестирование JUnit
     * метода copyFileWithReaderAndWriterNIO2 класса MyNIO2Example
     *
     * @throws MyNIO2Exception если имя исходного файла sourceFileName равно null или не существует,
     *                         если destinationFileName равно null
     */
    @Test
    void copyFileWithReaderAndWriterNIO2_FailedDestinationFileNameIsNull_Test() {
        String sourceFileName = "file_nio2.txt";
        String destinationFileName = null;
        createFileIfNotExists(sourceFileName);
        MyNIO2Example myNIO2Example1 = new MyNIO2Example();
        Assertions.assertThrows(MyNIO2Exception.class, () -> myNIO2Example1.copyFileWithReaderAndWriterNIO2(sourceFileName, destinationFileName));
    }

}