package HTMLGenerator.HTML.Elements;

public class Paragraph extends HTMLElements{

    public Paragraph(String content) {
        super(content);
    }

    public Paragraph(String content, String style) {
        super(content, style);
    }

    @Override
    public String toString() {
        return String.format("<p style=\"%s\">%s</p>", style, content);
    }
}
