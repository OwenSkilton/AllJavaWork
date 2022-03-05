package HTMLGenerator.MAIN;

import HTMLGenerator.HTML.Elements.HTMLElements;
import HTMLGenerator.HTML.Elements.Heading;
import HTMLGenerator.HTML.Elements.Paragraph;
import HTMLGenerator.HTML.HTMLDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        HTMLDocument htmlDoc = new HTMLDocument("WAGWAN PIFFTING");
        htmlDoc.addHTMLElements(new Heading("BENDER", "color: red", 1));
        htmlDoc.addHTMLElements(new Paragraph("I AM A POOPY HEAD"));
        htmlDoc.addHTMLElements(new Heading("MUG", "color: blue", 2));
        Files.writeString(Path.of("src/HTMLGenerator/MAIN/index.html"), htmlDoc.toString());
    }
}


