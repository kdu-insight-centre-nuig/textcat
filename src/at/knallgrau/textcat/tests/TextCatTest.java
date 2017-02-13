package at.knallgrau.textcat.tests;

import junit.framework.TestCase;
import at.knallgrau.textcat.TextCategorizer;

public class TextCatTest extends TestCase {
	
	private static final String test = "Java programming language" +
	"    * Why I Am Not A Java Programmer, by Michael G. Schwern.";
	
	public void testTextCat() {
		String str = TextCatTest.test + TextCatTest.test;
		str += str;
		
		long time = System.currentTimeMillis();
		TextCategorizer tc = new TextCategorizer();
		assertEquals("EN", tc.categorize(str));
		System.out.println("Time:" + (System.currentTimeMillis() - time));
	}	
}
