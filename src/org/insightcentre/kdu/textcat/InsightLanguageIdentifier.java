package org.insightcentre.kdu.textcat;

/**
 * Language Identifier
 *
 * @author Sergio Fernández
 */
public interface InsightLanguageIdentifier {

    default String identifyLanguage(Content content) {
        return identifyLanguage(content.getContent());
    }

    String identifyLanguage(String content);

}
