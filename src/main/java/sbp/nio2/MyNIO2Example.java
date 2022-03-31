package sbp.nio2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.nio.file.Files.*;

/**
 * Класс MyNIO2Example содержит методы работы с файламии с использованием NIO2 из пакета java.nio
 *
 * @version 1.0
 * <p>
 * Домашнее задание к занятию № 11, 12 (ДЗ №6)
 * Написать реализации всех методов в классе MyIOExample с применением NIO2 (подробности в javadocs над каждым методом);
 * @autor Sergey Proshchaev
 */

public class MyNIO2Example {

    private static final Logger logger = LoggerFactory.getLogger(MyNIO2Example.class);

    /**
     * Метод checkStringParamIsNotNull проверяет аргумент типа String
     * и вызывает исключение IllegalArgumentException, если аргумент is null
     *
     * @param String
     * @throws IllegalArgumentException - если string == null
     */
    private static void checkStringParamIsNotNull(String string) throws MyNIO2Exception {
        if (string == null) {
            logger.error("MyNIO2Exception parameter is null!");
            throw new MyNIO2Exception("MyNIO2Exception parameter is null!");
        }
    }

    /**
     * Метод checkFileExists проверяет наличие файла по имени, переданному в аргументе типа String
     * и вызывает исключение MyNIO2Exception, если файл не существует
     *
     * @param String
     * @throws MyNIO2Exception - если файл не существует
     */
    private static void checkFileExists(String fileName) throws MyNIO2Exception {
        Path pathIn = Paths.get(fileName);
        if (!exists(pathIn)) {
            logger.error("MyNIO2Exception file=" + fileName + " does not exists");
            throw new MyNIO2Exception("MyNIO2Exception file=" + fileName + " does not exists");
        }
    }

    /**
     * Метод workWithFileNIO2
     * Создает объект класса {@link java.nio.file}, проверяет существование и чем является (файл или директория)
     * Если сущность существует, то вывести в консоль информацию:
     * - абсолютный путь
     * - родительский путь
     * Если сущность является файлом, то вывести в консоль:
     * - размер
     * - время последнего изменения
     * Необходимо использовать класс {@link java.nio.file}
     *
     * @param fileName - имя файла
     * @return - true, если файл успешно создан
     * @throws MyNIO2Exception - если fileName равен null
     */
    public boolean workWithFileNIO2(String fileName) throws MyNIO2Exception {

        logger.info("Start workWithFileNIO2");

        boolean resultWorkWithFileNIO2 = false;

        checkStringParamIsNotNull(fileName);

        try {
            Path path = Paths.get(fileName);

            if (Files.exists(path)) {

                System.out.println("Файл " + path + " существует!");
                System.out.println("*      - абсолютный путь isAbsolute=" + path.toAbsolutePath());
                System.out.println("*      - родительский путь " + path.getParent());

                if (!Files.isDirectory(path)) {
                    System.out.println("Это файл");
                    System.out.println("*      - размер " + size(path));
                    System.out.println("*      - время последнего изменения " + getLastModifiedTime(path));
                } else {
                    System.out.println("Это дирректория");
                }
            } else {
                Files.createFile(path);
                resultWorkWithFileNIO2 = true;
                System.out.println("Файл path = " + path + " не существовал и был создан");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("IOException" + ex);
        }

        logger.info("End workWithFileNIO2 return: " + resultWorkWithFileNIO2);
        return resultWorkWithFileNIO2;
    }

    /**
     * Метод copyFileNIO2 использует небуферезированный ввод и вывод данных из файлов
     * Метод создает копию файла используя побайтовое чтение данных из потока Files.newInputStream
     *
     * @param sourceFileName      - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     * @throws MyNIO2Exception - если sourceFileName или destinationFileName равен null,
     *                         или sourceFileName не существует
     */
    public boolean copyFileNIO2(String sourceFileName, String destinationFileName) throws MyNIO2Exception {

        logger.info("Start copyFileNIO2");

        boolean resultCopyFileNIO2 = false;

        checkStringParamIsNotNull(sourceFileName);
        checkStringParamIsNotNull(destinationFileName);
        checkFileExists(sourceFileName);

        Path pathIn = Paths.get(sourceFileName);
        Path pathOut = Paths.get(destinationFileName);

        try (
                InputStream reader = Files.newInputStream(pathIn);
                OutputStream writer = Files.newOutputStream(pathOut)
        ) {
            int charCodeRead;
            while ((charCodeRead = reader.read()) != -1) {
                writer.write((char) charCodeRead);
            }
            resultCopyFileNIO2 = true;
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("IOException" + ex);
        }

        logger.info("End copyFileNIO2 return: " + resultCopyFileNIO2);

        return resultCopyFileNIO2;
    }

    /**
     * Метод copyBufferedFileNIO2 использует буферизированный ввод и вывод в текстовые файлы
     * на основе методов newBufferedReader и newBufferedWriter
     * Метод создает копию файла
     *
     * @param sourceFileName      - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     * @throws MyNIO2Exception - если sourceFileName или destinationFileName равен null,
     *                         или sourceFileName не существует
     */
    public boolean copyBufferedFileNIO2(String sourceFileName, String destinationFileName) throws MyNIO2Exception {

        logger.info("Start copyBufferedFileNIO2");

        boolean resultCopyBufferedFileNIO2 = false;

        checkStringParamIsNotNull(sourceFileName);
        checkStringParamIsNotNull(destinationFileName);
        checkFileExists(sourceFileName);

        Path pathIn = Paths.get(sourceFileName);
        Path pathOut = Paths.get(destinationFileName);

        try (
                BufferedReader bufferedReader = Files.newBufferedReader(pathIn);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOut)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            resultCopyBufferedFileNIO2 = true;
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("IOException" + ex);
        }

        logger.info("End copyBufferedFileNIO2 return: " + resultCopyBufferedFileNIO2);

        return resultCopyBufferedFileNIO2;
    }

    /**
     * Метод copyFileWithReaderAndWriterNIO2
     * Метод создает копию файла c использованием метода Files.lines(), который производит построчное чтение файла
     * без сохранения (всего читаемого файла) в памяти и производит буфферезированную запись в копируемый файл
     * с использованием newBufferedWriter
     *
     * @param sourceFileName      - имя исходного файла
     * @param destinationFileName - имя копии файла
     * @return - true, если файл успешно скопирован
     * @throws MyNIO2Exception - если sourceFileName или destinationFileName равен null,
     *                         или sourceFileName не существует
     */
    public boolean copyFileWithReaderAndWriterNIO2(String sourceFileName, String destinationFileName) throws MyNIO2Exception {

        logger.info("Start copyFileWithReaderAndWriterNIO2");

        boolean resultCopyFileWithReaderAndWriter = false;

        checkStringParamIsNotNull(sourceFileName);
        checkStringParamIsNotNull(destinationFileName);
        checkFileExists(sourceFileName);

        Path pathOut = Paths.get(destinationFileName);

        try (Stream<String> stream = Files.lines(Paths.get(sourceFileName));
             BufferedWriter bufferedWriter = Files.newBufferedWriter(pathOut)
        ) {

            stream.forEach(str -> {
                try {
                    bufferedWriter.write(str);
                    bufferedWriter.newLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    logger.error("IOException" + ex);
                }
            });

            resultCopyFileWithReaderAndWriter = true;

        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("IOException" + ex);
        }

        logger.info("End copyFileWithReaderAndWriterNIO2 return: " + resultCopyFileWithReaderAndWriter);

        return resultCopyFileWithReaderAndWriter;
    }

}