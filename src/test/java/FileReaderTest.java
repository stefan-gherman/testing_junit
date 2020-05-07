import com.codecool.readers.FilePartReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {
    @Test
    public void testSetFromLineThrowsIllegalArgumentExceptionOnNegativeNumberAssignment() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {reader.setToLine(-12);});
    }

    @Test
    public void testSetFromLineThrowsIllegalArgumentExceptionOnFromLineGreaterThanToLine() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {reader.setToLine(13); reader.setFromLine(15);});
    }

    @Test
    public void testSetupThrowsIllegalArgumentExceptionOnNegativeNumberAssignment() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {reader.setup("path", -1, 13);});
    }

    @Test
    public void testSetupThrowsIllegalArgumentExceptionOnToLineSmallerThanFromLine() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> {reader.setup("path", 13, 8);});
    }

    @Test
    public void testReadReturnsIOExceptionOnFIleNotFound() {
        FilePartReader reader = new FilePartReader();
        reader.setup("path", 1, 13);
        assertThrows(IOException.class, reader::read);
    }

    @Test
    public void testReadReturnsCorrectResult() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 1, 13);
        String correctResult = "We've reached the crossRoads of what makes truth and lies\n" +
                "No more time will pass by, we need to draw the line\n" +
                "All the things you did, they left me so betrayed\n" +
                "The words you never said now begin to fade away";
        assertEquals(correctResult, reader.read());
    }

    @Test
    public void testReadLinesReturnsIOExceptionOnFileNotFound() {
        FilePartReader reader = new FilePartReader();
        reader.setup("path", 1, 13);
        assertThrows(IOException.class, reader::readLines);
    }

    @Test
    public void testReadLinesReturnsIllegalArgumentExceptionOnBadfromLineAndtoLIne() {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 50, 75);
        assertThrows(IndexOutOfBoundsException.class, reader::readLines);
    }


    @Test
    public void testReadLinesReturnsCorrectResult() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 2, 4);
        String correctResult = "No more time will pass by, we need to draw the line\n" +
                "All the things you did, they left me so betrayed\n" +
                "The words you never said now begin to fade away";
        assertEquals(correctResult, reader.readLines());
    }



    @Test
    public void testReadLinesReturnsCorrectAnswerIfFromLineIsGreaterThanTheMax() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 2, 18);
        String correctResult = "No more time will pass by, we need to draw the line\n" +
                "All the things you did, they left me so betrayed\n" +
                "The words you never said now begin to fade away";
        assertEquals(correctResult, reader.readLines());
    }



}
