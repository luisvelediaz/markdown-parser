import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.Files;
import org.junit.*;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException
    {
        Path fileName = Path.of("/Users/luisvelediaz/Documents/GitHub/markdown-parser2/test-file.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("The link should be https://something.com","https://something.com",links.get(0));
        assertEquals("The links should be some-thing.html","some-thing.html",links.get(1));
    }

    @Test
    public void getImageLinkTest() throws IOException
    {
        Path fileName = Path.of("/Users/luisvelediaz/Documents/GitHub/markdown-parser2/test4.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }
    
} 
