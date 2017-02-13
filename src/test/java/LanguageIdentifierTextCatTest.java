//import io.redlink.ssix.pipeline.model.Content;
//import io.redlink.ssix.pipeline.nlp.impl.LanguageIdentifierTextCat;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.*;
import org.insightcentre.kdu.textcat.Content;
import org.insightcentre.kdu.textcat.InsightTextCategorizer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Language Identifier TextCat tests
 *
 * @author Gopal KS
 */
public class LanguageIdentifierTextCatTest {

    static private InsightTextCategorizer languageIdentifier;

    @BeforeClass
    public static void setup() throws IOException {
        languageIdentifier = new InsightTextCategorizer();
    }

    private String identify(String text) {
        return languageIdentifier.categorize(text);
    }

    @Test
    public void testLanguageIdentificationOnRegularText() {
        Assert.assertEquals("en", identify("this is a simple text"));
        Assert.assertEquals("es", identify("esto es una prueba muy simple que debería funcionar"));
        Assert.assertEquals("de", identify("Dies ist eine sehr einfache Test"));
    }

    @Test
    public void testLanguageIdentificationOnTweetsText() {
        Assert.assertEquals("en", identify("$AAPL I miss those old AAPL Friday Zooms of  a field goal. $210B? Just sittin there? and AAPL's transmission is still slipping in 3rd gear?"));
        Assert.assertEquals("en", identify("$AAPL is not a worthy company, all they can sell is good image but their products ar not as good as the rest."));
        Assert.assertEquals("en", identify("$AAPL maturity 01/27/2017 Vol PutCallRatio of 0.95 puts=48,941 calls=51,545 . https://t.co/J56VbPyp4h https://t.co/jgMnB73dsK"));
        Assert.assertEquals("en", identify("Centre likely to reject #Apple Inc's demands for India unit: Report. Read more: https://t.co/rf3ojOqvBs $AAPL"));
        Assert.assertEquals("en", identify("Apple's Legal Assault on Qualcomm Is Part of Phone Margin Grab, potentially retroactively over 20 yrs $ QCOM $ AAPL https://t.co/FD8sdllsyi"));
        Assert.assertEquals("en", identify("RT @AnalystWire: Barclays Downgrades Apple AAPL to $ Equalweight, Concerned India / China Will not Emerge As Growth Catalysts https://t.co/jPJ..."));
        Assert.assertEquals("en", identify("$AAPL received a new alert. Find out why at https://t.co/nZwqReM0tj #stocks #daytrading #trading #mkt #NYSE #NASDAQ #markets 43"));
        Assert.assertEquals("en", identify("RT @The_Real_Fly: $AAPL downgraded at Barclays"));
        Assert.assertEquals("en", identify("Find #stocks to #trade with https://t.co/uAcamNRUPt $AAPL $MCUR +181% https://t.co/e2zXG3II89 $GLBS $MRNS $HMNY $ASTI $ACST $GMAN"));
        //Assert.assertEquals("en", identify("RT @MarketCurrents: Qualcomm weighs countersuit against Apple https://t.co/4mmfqvJ01h $ QCOM $ AAPL"));
        //Assert.assertEquals("en", identify("RT @jmleray: Long-standing Apple bull steps back https://t.co/sAHCSr5ByD $AAPL"));
    }
}
