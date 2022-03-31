package sbp.io;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static java.lang.Math.random;

  /**
   * JUnit тестирование медодов класса MyIOExample проекта lecture4
   * @autor Sergey Proshchaev
   * @version 1.0
   */

class MyIOExampleTests {

    @Test
    void workWithFile_IO_Test() throws IOException {
        System.out.println("JUnit тест workWithFile:");

        MyIOExample myIOExample1 = new MyIOExample();
        Assert.assertFalse(myIOExample1.workWithFile("txt.txt"));
        Assert.assertFalse(myIOExample1.workWithFile("MyFile"));
        Assert.assertFalse(myIOExample1.workWithFile("src"));

        Integer i = (int) (random() * 1000);
        Assert.assertTrue(myIOExample1.workWithFile(i.toString()));

        System.out.println("---------------------------------");
    }

    @Test
    void copyFile_IO_Test() throws IOException {
        System.out.println("JUnit тест copyFile:");

        MyIOExample myIOExample1 = new MyIOExample();
        Assert.assertTrue(myIOExample1.copyFile("MyFile", "MyFile_copy"));
        Assertions.assertThrows(IOException.class, () -> myIOExample1.copyFile("whoseFileDoesNotExist.txt", "MyFile_copy"));

        System.out.println("---------------------------------");
    }

    @Test
    void copyBufferedFile_IO_Test() throws IOException {
        System.out.println("JUnit тест copyBufferedFile:");

        MyIOExample myIOExample1 = new MyIOExample();
        Assert.assertTrue(myIOExample1.copyBufferedFile("MyFile", "MyFile_copy"));
        Assertions.assertThrows(IOException.class, () -> myIOExample1.copyBufferedFile("whoseFileDoesNotExist.txt", "MyFile_copy"));

        System.out.println("---------------------------------");
    }

    @Test
    void copyFileWithReaderAndWriter_IO_Test() throws IOException {
        System.out.println("JUnit тест copyFileWithReaderAndWriter:");

        MyIOExample myIOExample1 = new MyIOExample();
        Assert.assertTrue(myIOExample1.copyFileWithReaderAndWriter("MyFile", "MyFile_copy"));
        Assertions.assertThrows(IOException.class, () -> myIOExample1.copyFileWithReaderAndWriter("whoseFileDoesNotExist.txt", "MyFile_copy"));

        System.out.println("---------------------------------");
    }
}