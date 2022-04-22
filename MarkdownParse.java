//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int openParen = markdown.indexOf("(", openBracket);
            int closeParen = markdown.indexOf(")", openParen);

            if(markdown.substring(openBracket-1,openBracket).equals("!"))
            {
                currentIndex = closeParen + 1;
            } 
            else
            {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }

        return toReturn;
    }
}