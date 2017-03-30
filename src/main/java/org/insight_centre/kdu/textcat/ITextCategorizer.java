package org.insight_centre.kdu.textcat;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by alanna on 13/02/17.
 */
public interface ITextCategorizer extends Serializable {

    /**
     * categorizes the text passed to it
     *
     * @param text
     *            text to be categorized
     * @return the category name given in the configuration file
     */
    String categorize(String text);

    String categorize(String text, int limit);

    Map<String, Integer> getCategoryDistances(String text);

}