package org.insightcentre.kdu.textcat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private Collection<FingerPrint> fingerprints = new ArrayList<FingerPrint>();
    private final Pattern filePattern = Pattern.compile(".*\\-(.*)\\.lm$");

    public InsightTextCategorizer() {
        MyProperties properties = new MyProperties();
        properties.load(InsightTextCategorizer.class.getClassLoader()
                .getResourceAsStream("textcat.conf"));
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            FingerPrint fp;
            try {
                    String encoding = null;
                    Matcher matcher = filePattern.matcher(entry.getKey());
                    if (matcher.matches()) {
                        encoding = matcher.group(1);
                    }

                    InputStream is = InsightTextCategorizer.class.getClassLoader()
                            .getResourceAsStream(entry.getKey());

                    if (encoding != null) {
                        fp = new FingerPrint(is, encoding);
                    } else {
                        fp = new FingerPrint(is);
                    }

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
