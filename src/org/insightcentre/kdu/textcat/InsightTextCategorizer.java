package org.insightcentre.kdu.textcat;

import at.knallgrau.textcat.FingerPrint;
import at.knallgrau.textcat.TextCategorizer;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by alanna on 10/02/17.
 */
public class InsightTextCategorizer extends TextCategorizer {

    public InsightTextCategorizer() {
    }

    public InsightTextCategorizer(Collection<FingerPrint> fingerprints) {
        super(fingerprints);
    }

    public InsightTextCategorizer(String confFile) throws FileNotFoundException {
        super(confFile);
    }

    @Override
    public String categorize(String text) {
        return super.categorize(text);
    }

    @Override
    public String categorize(String text, int limit) {
        return super.categorize(text, limit);
    }

    @Override
    public Map<String, Integer> getCategoryDistances(String text) {
        return super.getCategoryDistances(text);
    }

    
}
