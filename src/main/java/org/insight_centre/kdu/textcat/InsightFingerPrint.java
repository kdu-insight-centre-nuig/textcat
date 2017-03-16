package org.insight_centre.kdu.textcat;

import java.io.InputStream;

/**
 * Created by alanna on 10/02/17.
 */
public class InsightFingerPrint extends FingerPrint {

    public InsightFingerPrint(InputStream resourceAsStream) throws FingerPrintFileException {
        super(resourceAsStream);
    }

    @Override
    public void setCategory(String category) {
        super.setCategory(category);
    }


}
