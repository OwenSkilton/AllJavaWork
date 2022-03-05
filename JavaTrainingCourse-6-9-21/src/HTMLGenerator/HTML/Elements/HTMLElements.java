package HTMLGenerator.HTML.Elements;

public class HTMLElements {
    protected String content;
    protected String style;

    public HTMLElements() {
        this.content = "";
        this.style = "";
    }

    public HTMLElements(String content) {
        this();
        this.content = content;
    }

    public HTMLElements(String content, String style) {
        this(content);
        this.style = style;
    }

    public String getContent() {
        return content;
    }

    public String getStyle() {
        return style;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
