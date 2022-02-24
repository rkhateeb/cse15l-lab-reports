import static org.junit.Assert.*;
import org.junit.*;

// Random comment. 

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTestOther {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void addition1() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet1() throws IOException {
        String contents= Files.readString(Path.of("./snippet1.md"));
        List<String> expect = List.of("google.com", "ucsd.edu");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet2() throws IOException {
        String contents= Files.readString(Path.of("./snippet2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testSnippet3() throws IOException {
        String contents= Files.readString(Path.of("./snippet3.md"));
        List<String> expect = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void lr4test1() throws IOException {
        //snippet 1, other person's implementation
        Path filename = Path.of("snippet1.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParseOther.getLinks(contents);
        List<String> expected = List.of("url.com", "google.com");
        assertEquals(links, expected);
    }

    @Test
    public void lr4test2() throws IOException {
        //snippet 1, other person's implementation
        Path filename = Path.of("snippet2.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParseOther.getLinks(contents);
        List<String> expected = List.of("b.com", "a.com", "example.com");
        assertEquals(links, expected);
    }

    @Test
    public void lr4test3() throws IOException {
        //snippet 1, other person's implementation
        Path filename = Path.of("snippet3.md");
        String contents = Files.readString(filename);
        ArrayList<String> links = MarkdownParseOther.getLinks(contents);
        List<String> expected = List.of("https://www.twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(links, expected);
    }
}
