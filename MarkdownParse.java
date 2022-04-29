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
<<<<<<< Updated upstream
            int openQuotes = markdown.indexOf('"',currentIndex);
            int closeQuotes = markdown.indexOf('"',openQuotes+1);
=======
>>>>>>> Stashed changes
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int imageSyntax = markdown.indexOf("!",openBracket-1);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
<<<<<<< Updated upstream
            
            boolean passes = false;

            while (!passes) {
                if ((imageSyntax != -1) && imageSyntax == openBracket-1){ // skips if is image
                    currentIndex = closeBracket+1;
                    openBracket = markdown.indexOf("[", currentIndex);
                } else if ((openQuotes != -1 && closeQuotes != -1) && ((openQuotes < openBracket && closeQuotes > closeBracket) || (openQuotes < openParen && closeQuotes > closeParen))) {
                    // skips if enclosed by quotes
                    currentIndex = closeQuotes+1;
                } else {
                    passes = true;
                }
                if (!passes) {
                    closeBracket = markdown.indexOf("]", currentIndex);
                    openParen = markdown.indexOf("(", closeBracket);
                    closeParen = markdown.indexOf(")", openParen);
                }
            }

=======
>>>>>>> Stashed changes
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
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