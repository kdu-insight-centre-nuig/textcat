package org.insightcentre.kdu.textcat;

/**
 * Target entity
 *
 * @author Sergio Fernández
 */
public class Target {

    private double sentiment;

    private String label;

    //private List<Aspect> aspects;


    public double getSentiment() {
        return sentiment;
    }

    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
