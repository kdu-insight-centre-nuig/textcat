package org.insightcentre.kdu.textcat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.searchbox.annotations.JestId;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Content {

    @JestId
    private String id;

    private String uri;

    private String author;

    private String source;

    private String content;

    private long date;

    private String geo;

    private boolean shared;

    private String language;

    private int sentiment;

    private List<Target> targets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Content() {
        this.source = "twitter";
        this.content = "";
        this.targets = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSentiment() {
        return sentiment;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = new ArrayList(targets);
    }

    public void addTarget(String label, Integer sentiment) {
        final Target target = new Target();
        target.setLabel(label);
        target.setSentiment(sentiment);
        addTarget(target);
    }

    public void addTarget(String label) {
        final Target target = new Target();
        target.setLabel(label);
        addTarget(target);
    }

    public void addTarget(Target target) {
        this.targets.add(target);
    }

}
