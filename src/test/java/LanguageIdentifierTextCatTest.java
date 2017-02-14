//import io.redlink.ssix.pipeline.model.Content;
//import io.redlink.ssix.pipeline.nlp.impl.LanguageIdentifierTextCat;
import org.insightcentre.kdu.textcat.InsightTextCategorizer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

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
        Assert.assertEquals("fr", identify("Le New York Times est exclu du store #Apple en Chine. C'est bon pour $AAPL ? via @WSJ http://crwd.fr/2ifEV2s "));
        Assert.assertEquals("fr", identify("Apple présentera ses résultats financiers du Q1 2017 le 31 janvier à 23h (Paris) http://www.apple.com/pr/library/2017/01/27FY-17-First-Quarter-Results-Conference-Call.html … $AAPL"));
        Assert.assertEquals("fr", identify("Les 5 actions avec les volumes sur options les plus importants aujourd'hui: 1) $AAPL avec 232,119 Calls et... http://fb.me/33Z9geb7J "));
        Assert.assertEquals("fr", identify("$DAX 4 heures : les résultats d' $AAPL aidant, on devrait retourner dans la zone des 11660/720 pts. Au-delà des 720 --> 790. "));
        Assert.assertEquals("fr", identify("Apple se dit “forcé” d’avoir eu à augmenter les prix des iPhone jusqu’à 40% dans certains pays à cause du prix du dollar. $AAPL"));
        Assert.assertEquals("fr", identify("#Apple $aapl bonne réaction +3,6% en après séance suite à la publication"));
        Assert.assertEquals("fr", identify("Les 5 actions avec les volumes sur options les plus importants à la mi-journée sont: 1) $RAD, 2) $BAC, 3) $AAPL,... http://fb.me/7LXA4KX5L "));
        Assert.assertEquals("fr", identify("#StockMarket $AAPL $CVX $CSCO $GOOGL Investissez sur les actions US ! https://goo.gl/8uhY0z "));
        Assert.assertEquals("fr", identify("#Apple Toujours sous pression post résultats Pourrait tester supp oblique à ct avec incursion < 110.00  $AAPL --> "));
        Assert.assertEquals("fr", identify("Un président d'Apple ne devrait pas dire ça... $AAPL "));
        Assert.assertEquals("es", identify("negociación esta semana compartida aquí en twitter $aapl sacamos +700%..casualidad?si fuera la primera...trabajo? ya te digo k si..y muuucho"));
        Assert.assertEquals("es", identify("Salimos con un 7.18% de ganancia. Gracias Apple $AAPL"));
        Assert.assertEquals("es", identify("Es increible como subieron a $AAPL en momentos q el $SP500 necesitaba rebotar, toda una ingenieria...sin palabras.."));
        Assert.assertEquals("es", identify("@CMDTrader Mantenemos $ATVI $AAPL $PBR Y $PYPL ,Estamos a un día de que los principales bancos americanos reporten, que podemos esperar de los report?"));
        Assert.assertEquals("es", identify("Ayer fui al Apple Store de Aventura y lo que más me provocó comprar fue la acción! $AAPL"));
        Assert.assertEquals("es", identify("Consenso de estimaciones recopiladas por Markit de $AAPL de 2 años: no muestra una clara tendencia ni para un lado ni para el otro."));
        Assert.assertEquals("es", identify("Vamos $AAPL, tú sabes que te tienes que caer, no nos hagas perder más theta "));
        Assert.assertEquals("es", identify("quieren una señal de $AAPL? bueno tuve que cerrar el ninjatrader porq insiste hace dos dias en venderla solo y tengo que cancelar #señales"));
        Assert.assertEquals("es", identify("Apple $AAPL presenta una demanda contra la UE de € 13B, la defensa de Irlanda, acusando a Bruselas de infringir la soberanía."));
        Assert.assertEquals("es", identify("@Ichi_Premium Sabes si el Cedear respeta $aapl? CEDEARAAPL hoy dio hizo max con medias en orden y paraditas. ¿Dara p/Arbitrar x CedearVALE? "));
        Assert.assertEquals("de", identify("#DeutscheBank - Kurssprung nach Einigung im Hypothekenstreit #börse #aktien $dbk http://gmtr.ly/4ysUwCBVG "));
        //Assert.assertEquals("de", identify("$DBK:GR Deutsche Bank, VW, Bayer: Trump als X-Faktor fr deutsche Konzerne #DEUTSCHE BANK AG  http://tinyurl.com/jh2cw9w  #STOXX600"));
        Assert.assertEquals("de", identify("#DeutscheBank Aktie scheitert vorerst am Widerstand #wirtschaft #finanzen $dbk "));
        Assert.assertEquals("de", identify("Wie tief fällt der Dax-Kurs der Deutschen Bank? - http://www.handelsblatt.com/14555638.html?share=twitter … #Handelsblatt $DBK $VW"));
        Assert.assertEquals("de", identify("Apple-Rivale Xiaomi kämpft mit weltweit rückläufigem Smartphone-Geschäft  $AAPL http://bit.ly/2fzaqG2 "));
        Assert.assertEquals("de", identify("Apple hat einen neuen Weg eingeführt, wie ihr günstig iPhones einkaufen könnt $AAPL "));
        Assert.assertEquals("de", identify("#Tech-Titanen: Ist Microsoft das neue Apple – und #Apple das alte #Microsoft? – via @YahooDE $AAPL MSFT "));
        Assert.assertEquals("de", identify("#Apple Capital-Depesche: Auch wenn die Zahlen enttäuschten, nun wird alles besser $AAPL  /WS http://tiny.li/pl6e  "));
        Assert.assertEquals("de", identify("Mittelfristiges Signal! $AAPL: Eine Doppeltop wurde bei 115.720 USD nach unten durchbrochen http://ow.ly/pYb8505RmyT "));
        Assert.assertEquals("de", identify("Apple kann Umsatzschwund nicht stoppen, hoﬀt aber auf das Weihnachtsgeschäft http://de.reuters.com/article/usa-apple-idDEKCN12Q0D5 … #apple $AAPL"));
        Assert.assertEquals("it", identify("Non succedeva dal 2015: in queste ore le azioni AAPL sono valutate a 120 dollari, la quota… http://ift.tt/2jQgMRg "));
        Assert.assertEquals("it", identify("BlacRock fa incetta di azioni Apple e incrementa la sua quota di azioni AAPL. Il più grand… http://ift.tt/2jVGB2j "));
        Assert.assertEquals("it", identify("Apple Inc. (AAPL) il prezzo di chiusura, January 24, 2017, è 119.9708."));
        Assert.assertEquals("it", identify("macitynet - Le azioni AAPL sono le più snobbate al mondo dai fondi di investimento"));
        Assert.assertEquals("it", identify("Altro che flop: le vendite record dell’Apple Watch trascinano al rialzo AAPL http://spider-mac.com/2016/12/07/altro-che-flop-le-vendite-record-dellapple-watch-trascinano-al-rialzo-aapl/ …"));
        Assert.assertEquals("it", identify("Nessun effetto #Trump su #APPLE #AAPL...anzi! Siamo sul supporto in zona 104$, ma con un profondo rosso #HeikinAshi!"));
        Assert.assertEquals("it", identify("Apple perde il 3% in borsa, per gli analisti «È il momento di comprare azioni AAPL» http://ift.tt/2dZi0c3  #apple #appstore #iphone #ipad"));
        Assert.assertEquals("it", identify("#APPLE: utili in calo ma il crollo delle vendite è sopratutto Made in #ChinaOpen @Apple #AAPL "));
        Assert.assertEquals("it", identify("@paulkrugman Paolo sei grato alla #SNB perché è piena di #AAPL #FB #GOOGL etc. fino al buco del culo. Traducitelo. @CARLOGALL"));
        Assert.assertEquals("it", identify("Che settimana in borsa x le azioni Apple $AAPL: +12%! Da $ 103,10 a $ 115,57… pompate dalle recensioni di iPhone 7 "));
        Assert.assertEquals("en", identify("@hanie: Apple Employees Send A Complaint Letter To CEO Tim Cook  $AAPL http://stks.co/i2Ytm'LOL dirty bears!!"));
        //Assert.assertEquals("en", identify("Pacific Crest lowers price target on Micron stock - http://stks.co/g2YXs $MU $AAPL"));
        Assert.assertEquals("en", identify("$AAPL who would of thought joining the Dow would be a abad omen??"));
        Assert.assertEquals("en", identify("$TWTR LOL I bet Jack Dorsey clown thinks he's some sort of second coming of Steve Jobs who was also interim before he was not $AAPL"));
        //Assert.assertEquals("en", identify("Apple Employees Send A Complaint Letter To CEO Tim Cook  $AAPL http://stks.co/h2YzU"));
        //Assert.assertEquals("en", identify("$AAPL below 120 soon"));
        Assert.assertEquals("en", identify("$AAPL suxs 2 b in appl...another red apple day again"));
        Assert.assertEquals("en", identify("@rettamatson $AAPL Employees Complaint Letter To CEO Cook' Ridiculous. I work retail, standard operating procedure, most shrink internal."));
        Assert.assertEquals("en", identify("$AAPL Sky is falling? What's new."));
        Assert.assertEquals("en", identify("Buying $AAPL 130 puts for Friday's  expiration.  Holding for 30 minutes max."));
        Assert.assertEquals("en", identify("$AAPL now this is the roll over I've been looking for, looking like it could roll further"));
        Assert.assertEquals("en", identify("$AAPL Still say MASSIVE distribution for months now going into summer with a HUGE crash in FALL! Trillions have to exit. That takes time!"));
        Assert.assertEquals("en", identify("$AAPL Apple Employees Send A Complaint Letter To CEO Tim Cook - http://stks.co/j2Yhw"));
        Assert.assertEquals("en", identify("$AAPL I think it's going to be a rough summer with these stocks"));
        Assert.assertEquals("en", identify("$AAPL Too much retail in this stock maybe. It's like panic selling every other day.Too funny. Here's one that Cramer is actually right about"));
        Assert.assertEquals("en", identify("$AAPL This stock, it will close around 127.50 today.  Use the Force!!"));
        Assert.assertEquals("en", identify("$AAPL  Hey ! It doesn't feel like it but AAPL is outperforming the index today. #staylucky"));
        //Assert.assertEquals("en", identify("$AAPL 125 lets go"));
        Assert.assertEquals("en", identify("$AAPL dumping has started.. we could be down 3 today if this doesnt let up.. start of big correction coming.. down 15%"));
        Assert.assertEquals("en", identify("$AAPL this could get ugly real fast"));
        Assert.assertEquals("en", identify("$AAPL IMHO gap down Monday, but also think this market has one more rally in it before a correction"));
        //Assert.assertEquals("en", identify("$AAPL CORRECTION?"));
        Assert.assertEquals("en", identify("$AAPL Deutsche Bank predicts 5%-9% correction for S&amp;P 500  http://stks.co/i2YyL    THEY HAVE BEEN RIGHT OFTEN!"));
        Assert.assertEquals("en", identify("$AAPL MM KEEPS POUDING this down below $128, disgusting crooks"));
        Assert.assertEquals("en", identify("Companies won't be buying back as much stock if Washington has anything to say about it $AAPL  http://stks.co/p2HiK"));
        Assert.assertEquals("en", identify("$AAPL been very weak price action lately sell days high vol buy days low vol aapl is clearly telling us something about broader market"));
        Assert.assertEquals("en", identify("$AAPL One last push up the DOWN DOWN DOWN!!  Fall off the cliff!! Shorted AAPL today!!"));
        Assert.assertEquals("en", identify("$AAPL I think they might use $1M of the buybacks when the stock hits $100.00, then drops from there"));
        //Assert.assertEquals("en", identify("$AAPL (H): Price &lt; ema50. OBV struggling. MACD still bearish"));
        Assert.assertEquals("en", identify("$AAPL The time to buy Apple was back in 2008. I would've but a real estate developer stole a million $ from me."));
        Assert.assertEquals("en", identify("$QQQ $aapl getting to June 9 low"));
        Assert.assertEquals("en", identify("$AAPL the only smart thing i did today was selling covered calls on shares i bought."));
        Assert.assertEquals("en", identify("$AAPL - Really taking it to the chin"));
        Assert.assertEquals("en", identify("$SPY $AAPL $FB feels like a flush coming"));
        Assert.assertEquals("en", identify("$AAPL Close below the 50dma this time sure looks a lot different than on June 9th....I guarantee this is lower on Monday"));
        Assert.assertEquals("en", identify("$AAPL Down 53% on my July $130 calls... What should I do?...Very stressed"));
        Assert.assertEquals("en", identify("$AAPL if you pull out yearly chart, it's doing the same thing it did between April 2012 and September 2012. Gained 10% off high then crashed"));
        Assert.assertEquals("en", identify("$AAPL triple top portends bearish reversal to the low 100s this summer"));
        Assert.assertEquals("en", identify("Needs AapleTV catalyst. Watch unveil and WWDC were lackluster affairs. Little spark. Have to wait for ER or TV to clear $132. $AAPL"));
        Assert.assertEquals("en", identify("$AAPL guess I should have sold in May and stayed away. Really don't want the tax bill but equally hate seeing gains evaporate over nothing."));
        Assert.assertEquals("en", identify("$AAPL Having evaluated the chart on various time frames, I am challenged to remain bullish. Any technical longs with a Bullish View?"));
        Assert.assertEquals("en", identify("@TheComplainer $AAPL http://stks.co/t2IDk Sorry longs, she's come undone! It was too late!!!!' Nope"));
        Assert.assertEquals("en", identify("$AAPL A broken stock in a broken year. It will be interesting to see if July can extend its winning streak to 7 years."));
        Assert.assertEquals("en", identify("$AAPL Too many bad vibes, a few weeks ago ppl were talking possible 150$, now below 100$ Stop loss and buying ambrella"));
        //Assert.assertEquals("en", identify("@GeorgeJung @TradeTopper $BABA is dead money till breakout same as $AAPL."));
        Assert.assertEquals("en", identify("$AAPL Im noticing a little bit of excessive insanity lately. Its always crazy but  more so recently. Thats how u can tell apple hasnt moved."));
        Assert.assertEquals("en", identify("$AAPL im just now wondering if I should sell and rebuy later"));
        Assert.assertEquals("en", identify("$AAPL if this cleanly breaks under 125.  119 will come swiftly."));
        Assert.assertEquals("en", identify("@SexOnTheBeach look at the market. Weak. Even $aapl can't completely overcome that."));
        Assert.assertEquals("en", identify("$AAPL market is expected 15 to 20 percent decline after one more rally. Apple will be 95 to 105"));
        Assert.assertEquals("en", identify("RT @OliverSnyders: Promising #Kickstarter Games: 4 of 5"));
        Assert.assertEquals("en", identify("A post-Brexit trade deal with Donald Trump will 'hurt rather than help' UK exporters, Plaid Cymru warn https://t.co/8tXDHlVQlY #ukpolitics"));
        Assert.assertEquals("en", identify("RT simonjkennedy: #Brexit Bulletin: Wiill Theresa May repeat David Cameron's Merkel mistake? https://t.co/hpQGY5AVI3 via business #trading"));
        Assert.assertEquals("en", identify("Karl G. Glassman Sells 75,388 Shares of Leggett &amp; Platt, Incorporated $LEG Stock https://t.co/fUQSy2Lshc"));
        Assert.assertEquals("en", identify("UK labour shortages reported as EU worker numbers fall https://t.co/b9tE2rssm4 &lt; While May &amp; her clowns watch NHS and society collapse."));
        Assert.assertEquals("en", identify("#Microsoft Windows 10 gets floating video player so you never get any work done. Read more: https://t.co/ZOphyDDgvU $MSFT"));
        Assert.assertEquals("sv", identify("Rapporten sista januari är inte så långt borta längre. Tar ett rejält grepp om vad alla & jag själv tror om🍎 http://gottodix.blogspot.se/2017/01/analytikerna-jag-om-apple-2017.html#more …  #aapl "));
        Assert.assertEquals("sv", identify("Vahastu har idag köpt en MacBook Air. Äger nu totalt 7 stycken. Äger inga aktier i AAPL dock. För dyrt. Vahastu köper bara billigt."));
        Assert.assertEquals("sv", identify("AAPL på 18 månadershögsta. Nu börjar analytikerkonferensen: http://www.apple.com/investor/earnings-call/ …"));
        Assert.assertEquals("sv", identify("Nasdaq, ATH, tongivande bolag därinom likaså vid ATH-område & motståndszoner,, #COMP  #AAPL #AMZN #FB"));
        Assert.assertEquals("sv", identify("Gillar inte riktigt att stora bolagtyp AAPL wobblar när vi är toppish i index. Kronan slaktas o det håller upp börsen. Men känns inte 100..."));
        Assert.assertEquals("sv", identify("Analyserat den här skönheten från $AAPL i ett dygn, helt klart en köprek. "));
        Assert.assertEquals("sv", identify("Brukar du söka på dina bolags cashtag för att få information på twitter? Tex $Aapl Själv använder jag den dagligen. Bra för US-aktier."));
        Assert.assertEquals("sv", identify("Google Pixel lanseras nu, av Alphabet och Apple aktierna att döma verkar investerare inte så imponerade $GOOG $AAPL"));
        Assert.assertEquals("sv", identify("Hur ska man tolka Tims Cook lilla uttag inför 7 sept, 550milj #wtf $AAPL #förhelvete"));
        Assert.assertEquals("sv", identify("Buffett ($BRK) sålde 15 miljoner $WMT-aktier nyligen. Man har visst även köpt drygt 5 miljoner $AAPL ..."));
        Assert.assertEquals("en", identify("$AAPL I miss those old AAPL Friday Zooms of  a field goal. $210B? Just sittin there? and AAPL's transmission is still slipping in 3rd gear?"));
        Assert.assertEquals("en", identify("$AAPL is not a worthy company, all they can sell is good image but their products ar not as good as the rest."));
        Assert.assertEquals("en", identify("$AAPL maturity 01/27/2017 Vol PutCallRatio of 0.95 puts=48,941 calls=51,545 . https://t.co/J56VbPyp4h https://t.co/jgMnB73dsK"));
        Assert.assertEquals("en", identify("Centre likely to reject #Apple Inc's demands for India unit: Report. Read more: https://t.co/rf3ojOqvBs $AAPL"));
        Assert.assertEquals("en", identify("Apple's Legal Assault on Qualcomm Is Part of Phone Margin Grab, potentially retroactively over 20 yrs $ QCOM $ AAPL https://t.co/FD8sdllsyi"));
        Assert.assertEquals("en", identify("RT @AnalystWire: Barclays Downgrades Apple AAPL to $ Equalweight, Concerned India / China Will not Emerge As Growth Catalysts https://t.co/jPJ..."));
        Assert.assertEquals("en", identify("$AAPL received a new alert. Find out why at https://t.co/nZwqReM0tj #stocks #daytrading #trading #mkt #NYSE #NASDAQ #markets 43"));
        Assert.assertEquals("en", identify("RT @The_Real_Fly: $AAPL downgraded at Barclays"));
        Assert.assertEquals("en", identify("Find #stocks to #trade with https://t.co/uAcamNRUPt $AAPL $MCUR +181% https://t.co/e2zXG3II89 $GLBS $MRNS $HMNY $ASTI $ACST $GMAN"));
        Assert.assertEquals("en", identify("RT @MarketCurrents: Qualcomm weighs countersuit against Apple https://t.co/4mmfqvJ01h $ QCOM $ AAPL"));
        //Assert.assertEquals("en", identify("RT @jmleray: Long-standing Apple bull steps back https://t.co/sAHCSr5ByD $AAPL"));

    }
}
