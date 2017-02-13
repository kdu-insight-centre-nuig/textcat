package org.insightcentre.kdu.textcat;

import at.knallgrau.textcat.TextCategorizer;

/**
 * Created by alanna on 10/02/17.
 */
public class InsightTextCategorizer implements InsightLanguageIdentifier {

    private final static int UNKNOWN_LIMIT = 10;

    private TextCategorizer textcat;

    public InsightTextCategorizer() {

    }

    public void init() {
        textcat = new TextCategorizer();
    }

    /**
     * categorizes the text passed to it
     *
     * @param text
     *            text to be categorized
     * @return the category name given in the configuration file
     */
    public String identifyLanguage(String text) {
        if(text.length() < UNKNOWN_LIMIT) {
            return "unknown";
        }

        final String preprocessedText = text.toLowerCase().replaceAll("\\.|/|:"," ");

        return textcat.categorize(preprocessedText);
    }

}
