package org.insight_centre.kdu.textcat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 *
 * @author Gopal KS
 * @author alanna.kelly@insight-centre.org
 *
 * Derived from original work by Thomas Hammerl
 */
public class InsightTextCategorizer implements ITextCategorizer {

    private final static int UNKNOWN_LIMIT = 10;

    private Collection<FingerPrint> fingerprints = new ArrayList<>();

    public InsightTextCategorizer() {
        MyProperties properties = new MyProperties();
        properties.load(InsightTextCategorizer.class.getClassLoader()
                .getResourceAsStream("textcaTweet.conf"));
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            FingerPrint fp;
            try {
                    String encoding;
                if(entry.getKey().contains("dutch") || entry.getKey().contains("english")) {
                    encoding="US-ASCII";
                } else if(entry.getKey().contains("swedish"))
                {
                    encoding="UTF-8";
                }else{
                    encoding="ISO-8859-1";
                }
                    InputStream is = InsightTextCategorizer.class.getClassLoader()
                            .getResourceAsStream(entry.getKey());
                    fp = new FingerPrint(is, encoding);


                fp.setCategory(entry.getValue());
                this.fingerprints.add(fp);
            } catch (FingerPrintFileException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String categorize(String text) {
        if(text.length() < UNKNOWN_LIMIT) {
            return "unknown";
        }

        String preprocessedText = text.toLowerCase().replaceAll("\\.|/|:"," ");
        FingerPrint fp = new FingerPrint();
        fp.create(preprocessedText);
        fp.categorize(fingerprints);

        return fp.getCategory();
    }

    @Override
    public String categorize(String text, int limit) {
        throw new RuntimeException("Unimplemented Method");
    }

    @Override
    public Map<String, Integer> getCategoryDistances(String text) {
        throw new RuntimeException("Unimplemented Method");
    }
}
