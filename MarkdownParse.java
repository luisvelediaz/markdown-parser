
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
            int openQuotes = markdown.indexOf('"',currentIndex);
            int closeQuotes = markdown.indexOf('"',openQuotes+1);
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int imageSyntax = markdown.indexOf("!",openBracket-1);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            while (openQuotes != -1 && closeQuotes != -1) { // skips brakets enclosed in quotes ""
                if ((openQuotes < openBracket && closeQuotes > closeBracket) || (openQuotes < openParen && closeQuotes > closeParen)) {
                    closeBracket = markdown.indexOf("]", closeBracket+1);
                    openParen = markdown.indexOf("(", closeBracket);
                    closeParen = markdown.indexOf(")", openParen);
                } else {
                    break;
                }
            }
            
            if(openBracket == -1 || closeBracket == -1 || openParen == -1) { // avoid infinite loops
                currentIndex = markdown.length();
                break;
            } else if ((imageSyntax != -1) && imageSyntax == openBracket-1){ // skips if is image
                currentIndex = openBracket+1;
            } else if (openParen != closeBracket+1) { // skips if parenthesis not right after close bracket
                currentIndex = closeBracket+1;
            } else if ((openQuotes != -1 && closeQuotes != -1) && ((openQuotes < openBracket && closeQuotes > closeBracket) || (openQuotes < openParen && closeQuotes > closeParen))) {
                // skips if enclosed by quotes
                currentIndex = closeQuotes+1;
            } else {
                if (openParen != -1 && closeParen != -1) {
                    toReturn.add(markdown.substring(openParen + 1, closeParen));
                    currentIndex = closeParen + 1;
                } else {
                    break;
                }
            }
        }
        
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}

