import com.codecool.analyzers.FileWordAnalyzer;
import com.codecool.readers.FilePartReader;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileWordAnalyzerTest {

    @Test
    public void testGetWordsOrderedAlphabeticallyThrowsIOException() {
        FilePartReader reader = new FilePartReader();
        reader.setup("path", 1, 13);

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertThrows(IOException.class, () -> {
            analyzer.getWordsOrderedAlphabetically();
        });
    }

    @Test
    public void testGetWordsOrderedAlphabeticallyReturnsCorrectAnswer() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 1, 2);

        List<String> result = new ArrayList<>(Arrays.asList("and", "by,", "crossroads", "draw", "lies", "line", "makes", "more", "need", "No", "of", "pass", "reached", "the", "the", "time", "to", "truth", "we", "We've", "what", "will"));
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(result, analyzer.getWordsOrderedAlphabetically());
    }


    @Test
    public void testGetWordsContainingSubstringThrowsIOException() {
        FilePartReader reader = new FilePartReader();
        reader.setup("path", 1, 13);

        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertThrows(IOException.class, () -> {
            analyzer.getWordsContainingSubstring("roads");
        });
    }

    @Test
    public void testGetWordsContainingSubstringCorrectAnswer() throws IOException {
        FilePartReader reader = new FilePartReader();
        reader.setup("/mnt/7d45c543-fc06-4310-b70a-2a9aa2e43a54/Projects/codecool/java/testing_junit/.idea/files/for_test.txt", 1, 2);

        List<String> result = new ArrayList<>(Arrays.asList("crossroads"));
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(result, analyzer.getWordsContainingSubstring("roads"));
    }





}
