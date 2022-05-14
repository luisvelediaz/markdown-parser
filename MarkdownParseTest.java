import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinksTest() throws IOException
    {
        Path fileName = Path.of("test-file.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("The link should be https://something.com","https://something.com",links.get(0));
        assertEquals("The links should be some-thing.html","some-thing.html",links.get(1));
    }

    @Test
    public void getImageLinkTest() throws IOException
    {
        Path fileName = Path.of("imagelink.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }

    @Test
    public void testfile2() throws IOException
    {
        Path fileName = Path.of("test-file2.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("The link should be https://something.com","https://something.com",links.get(0));
        assertEquals("The links should be some-page.html","some-page.html",links.get(1));
    }

    @Test 
    public void testfile3() throws IOException
    {
        Path fileName = Path.of("test-file3.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }

    @Test
    public void testfile4() throws IOException
    {
        Path fileName = Path.of("test-file4.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }


/*    @Test
    public void testfile5() throws IOException
    {
        Path fileName = Path.of("test-file5.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }

  */
    @Test
    public void testfile6() throws IOException
    {
        Path fileName = Path.of("test-file6.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }

    @Test
    public void testfile7() throws IOException
    {
        Path fileName = Path.of("test-file7.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList of links",0,links.size());
    }

    @Test
    public void testfile8() throws IOException
    {
        Path fileName = Path.of("test-file6.md");
        String fileContent = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(fileContent);
        assertEquals("There should be nothing in the arrayList",0,links.size());
    }


}

