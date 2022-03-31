package sbp.io;

import java.io.*;

public class MyIOExample {

    /**
     * Создать объект класса {@link java.io.File}, проверить существование и чем является (фалй или директория).
     * Если сущность существует, то вывести в консоль информацию:
     *      - абсолютный путь
     *      - родительский путь
     * Если сущность является файлом, то вывести в консоль:
     *      - размер
     *      - время последнего изменения
     * Необходимо использовать класс {@link java.io.File}
     * @param fileName - имя файла
     * @return - true, если файл успешно создан
     */

    /**
     * PS: Для создания файла в клессе java.io.File используется метод createNewFile()
     */

    public boolean workWithFile(String fileName) throws IOException {

        System.out.println("Выполнение workWithFile:");
        System.out.println("------------------------");

        boolean resultOfWorkWithFile = false;
        File fileObj = new File(fileName);

        if (fileObj.exists()) {
            System.out.println("Сущность " + fileName + " найдена!");
            if (fileObj.isFile()) {
                System.out.println("Сущность " + fileName + " это файл");
                System.out.println("Размер: " + fileObj.length());
                System.out.println("Время последнего изменения: " + fileObj.lastModified());
            }
            if (fileObj.isDirectory()) {
                System.out.println("Сущность - " + fileName + " это директория");
                System.out.println("Абсолютный путь: " + fileObj.getAbsolutePath());
                System.out.println("Родительский путь: " + fileObj.getParent());
            }
        } else {

            System.out.println("Создание файла " + fileName + " ...");
            File newFile = new File(fileName);

            try {
                boolean created = newFile.createNewFile();
                if (created) {
                    System.out.println("Файл " + fileName + " был создан!");
                    resultOfWorkWithFile = true;
                }
            } catch(Exception ex) {
                System.out.println("Ошибка при выполнении: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        System.out.println("");

        return resultOfWorkWithFile;


    }

        /**
         * Метод должен создавать копию файла
         * Необходимо использовать IO классы {@link java.io.FileInputStream} и {@link java.io.FileOutputStream}
         * @param sourceFileName - имя исходного файла
         * @param destinationFileName - имя копии файла
         * @return - true, если файл успешно скопирован
         */

    /**
     * PS: Для чтения из файла по байтам из java.io.FileInputStream используется класс FileInputStream
     * Для записи используется класс FileOutputStream
     *
     * Метод чтения и записи в файл с использованием чтения FileInputStream и записи fileOutputStream
     * в байтах (низкоуровневый)
     *
     * В сигнатуру метода добавлена обработка throws IOException, чтобы
     *  FileInputStream fileInputStream = new FileInputStream(sourceFileName);
     *  FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);
     *  можно было бы вынести за первый try, а закрытие потоков перенести в блок finally
     */

    public boolean copyFile (String sourceFileName, String destinationFileName) throws IOException {

        System.out.println("Выполнение copyFile:");
        System.out.println("--------------------");

        boolean resultCopyFile = false;

            FileInputStream fileInputStream = new FileInputStream(sourceFileName);
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFileName);

        try {
                int oneByteFromFile = fileInputStream.read();

                while (oneByteFromFile != -1) {
                    fileOutputStream.write(oneByteFromFile);
                    oneByteFromFile = fileInputStream.read();
                }

                resultCopyFile = true;

            } catch (Exception ex) {
                System.out.println("Ошибка при выполнении: " + ex.getMessage());
                ex.printStackTrace();
        } finally {

            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (Exception ex) {
                System.out.println("Ошибка при закрытии потоков: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        System.out.println("");

        return resultCopyFile;
    }

        /**
         * Метод должен создавать копию файла
         * Необходимо использовать IO классы {@link java.io.BufferedInputStream} и {@link java.io.BufferedOutputStream}
         * @param sourceFileName - имя исходного файла
         * @param destinationFileName - имя копии файла
         * @return - true, если файл успешно скопирован
         */

        /*
         * Метод ускоренного создания копии файла с использованием чтения BufferedReader и записи BufferedWriter
         * (высокоуровневый)
         *
         * После чтения закрываем стачала более высокоуровневый класс bufferedWriter, затем fileWriter
         * и тоже самое для bufferedReader и fileReader
         * После каждой записи запускаем метод bufferedWriter.flush(), который физически записывает данные на диск
         *
         */

    public boolean copyBufferedFile (String sourceFileName, String destinationFileName) throws IOException {

        System.out.println("Выполнение copyBufferedFile:");
        System.out.println("----------------------------");

        boolean resultCopyBufferedFile = false;

        FileReader fileReader = new FileReader(sourceFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(destinationFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        try {

            String stringForRead = bufferedReader.readLine();

            while (stringForRead != null) {
                System.out.println(stringForRead);
                bufferedWriter.write(stringForRead + "\n");
                bufferedWriter.flush();
                stringForRead = bufferedReader.readLine();
            }

            resultCopyBufferedFile = true;

        } catch (Exception ex) {
            System.out.println("Ошибка при выполнении: " + ex.getMessage());
            ex.printStackTrace();
        } finally {

            try {
                bufferedReader.close();
                bufferedWriter.close();
                fileReader.close();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Ошибка при закрытии потоков: " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        System.out.println("");

        return resultCopyBufferedFile;
    }

        /**
         * Метод должен создавать копию файла
         * Необходимо использовать IO классы {@link java.io.FileReader} и {@link java.io.FileWriter}
         * @param sourceFileName - имя исходного файла
         * @param destinationFileName - имя копии файла
         * @return - true, если файл успешно скопирован
         */

        /*
         * Метод создания копии файла с использованием чтения FileReader и записи FileWriter
         * в символах (низкоуровневый)
         *
         *
         */

    public boolean copyFileWithReaderAndWriter (String sourceFileName, String destinationFileName) throws IOException
    {

        System.out.println("Выполнение copyFileWithReaderAndWriter:");
        System.out.println("---------------------------------------");

        boolean resultCopyFileWithReaderAndWriter = false;

        FileReader fileReader = new FileReader(sourceFileName);
        FileWriter fileWriter = new FileWriter(destinationFileName);

        try {

            int symbolFromfileReader = fileReader.read();

            while (symbolFromfileReader != -1) {

                fileWriter.write((char) symbolFromfileReader);
                fileWriter.flush();
                symbolFromfileReader = fileReader.read();
            }

            resultCopyFileWithReaderAndWriter = true;

        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            System.out.println("Ошибка при выполнении: " + ex.getMessage());
        } finally {
            fileReader.close();
            fileWriter.close();
        }

        System.out.println("");

        return resultCopyFileWithReaderAndWriter;
    }

}