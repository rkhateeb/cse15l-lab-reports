import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarkdownParseTest {
    @Test
    public void testFile() throws IOException {
        Path filename = Path.of("test-file.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://something.com", "some-page.html");
        assertEquals(links, expected);
    }

    @Test
    public void test1() throws IOException {
        Path filename = Path.of("test1.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://something.com", "some-page.html");
        assertEquals(links, expected);
    }

    @Test
    public void test2() throws IOException {
        Path filename = Path.of("test2.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://something.com");
        assertEquals(links, expected);
    }

    @Test
    public void lr4test1() throws IOException {
        //snippet 1, my implementation
        Path filename = Path.of("snippet1.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("url.com", "google.com");
        assertEquals(links, expected);
    }

    @Test
    public void lr4test2() throws IOException {
        //snippet 2, my implementation
        Path filename = Path.of("snippet2.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("b.com", "a.com", "example.com");
        assertEquals(links, expected);
    }

    @Test
    public void lr4test3() throws IOException {
        //snippet 3, my implementation
        Path filename = Path.of("snippet3.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(links, expected);
    }
}