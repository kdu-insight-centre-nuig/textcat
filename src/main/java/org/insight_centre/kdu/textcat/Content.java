package org.insight_centre.kdu.textcat;

public class Content {

    private String source;
    private String content;
    private String uri;

    public Content() {
        this.source = "twitter";
        this.content = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

}