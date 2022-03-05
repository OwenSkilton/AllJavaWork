package HTMLGenerator.HTML;

import HTMLGenerator.HTML.Elements.HTMLElements;

import java.util.ArrayList;

public class HTMLDocument {

    private String title;
    private ArrayList<HTMLElements> elements;

    public HTMLDocument(String title) {
        this.title = title;
        this.elements = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<HTMLElements> getElements() {
        return elements;
    }

    public void addHTMLElements(HTMLElements element){
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder htmlDoc = new StringBuilder();

        htmlDoc.append("<!DOCTYPE html>\n");
        htmlDoc.append("<html>\n");
        htmlDoc.append("<head>\n");
        htmlDoc.append(String.format("<title>%s</title>\n",title));
        htmlDoc.append("</head>\n");
        htmlDoc.append("<body>\n");
        for (HTMLElements element : elements){
            htmlDoc.append(String.format("%s\n",element));
        }
        htmlDoc.append("</body>\n");
        htmlDoc.append("</html>\n");
        return htmlDoc.toString();
    }
}
