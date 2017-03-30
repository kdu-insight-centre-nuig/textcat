package org.insight_centre.kdu.textcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Thomas Hammerl
 * 
 * TextCategorizer is able to categorize texts by computing the similarity of
 * the FingerPrint of a text with a collection of the FingerPrints of the
 * categories.
 * 
 */
public class TextCategorizer implements ITextCategorizer {

	private File confFile = null;

	private final static int UNKNOWN_LIMIT = 20;

	private static final String JAR_CONF_PATH = "textcaTweet.conf";

	private Collection<FingerPrint> fingerprints = new ArrayList<FingerPrint>();

	private final Pattern filePattern = Pattern.compile(".*\\-(.*)\\.lm$");

	public TextCategorizer() {
		this.loadCategories();
	}

	public TextCategorizer(Collection<FingerPrint> fingerprints) {
		this.fingerprints = fingerprints;
	}

	/**
	 * creates a new TextCategorizer with the given configuration file. the
	 * configuration file maps paths to FingerPrint files to categories which
	 * are used to categorize the texts passed to the TextCategorizer.
	 * 
	 * @param confFile
	 *            the path to the configuration file
	 * @throws FileNotFoundException
	 *             thrown when given configuration file does not exist
	 */
	public TextCategorizer(String confFile) throws FileNotFoundException {
		this.changeContext(confFile);
	}

	/**
	 * sets the configuration file path.
	 * 
	 * @param confFile
	 *            the path to the configuration file
	 * @throws FileNotFoundException
	 *             thrown when given configuration file does not exist
	 */
	private void changeContext(String confFile) throws FileNotFoundException {
		this.confFile = new File(confFile);
		if (!this.confFile.exists()) {
			this.confFile = null;
			throw new FileNotFoundException(
					"The given configuration file does not exist.");
		}
		this.loadCategories();
	}

	/**
	 * clears the categories-collection and fills it with the FingerPrints given
	 * in the configuration file.
	 */
	private void loadCategories() {
		this.fingerprints.clear();
		MyProperties properties = new MyProperties();
		if (this.confFile == null) {
			properties.load(TextCategorizer.class.getClassLoader()
					.getResourceAsStream(TextCategorizer.JAR_CONF_PATH));
		} else {
			FileInputStream fis;
			try {
				fis = new FileInputStream(this.confFile);
				properties.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
		}
		for (Entry<String, String> entry : properties.entrySet()) {
			FingerPrint fp;
			try {
				if (this.confFile == null) {
					String encoding = null;
					Matcher matcher = filePattern.matcher(entry.getKey());
					if (matcher.matches()) {
						encoding = matcher.group(1);
					}

					InputStream is = TextCategorizer.class.getClassLoader()
							.getResourceAsStream(entry.getKey());

					if (encoding != null) {
						fp = new FingerPrint(is, encoding);
					} else {
						fp = new FingerPrint(is);
					}

				} else {
					File fpFile = new File(entry.getKey());
					if (fpFile.isAbsolute()) {
						fp = new FingerPrint(entry.getKey());
					} else {
						String confPath = this.confFile.getParentFile()
								.getAbsolutePath();
						fp = new FingerPrint(confPath + "/" + entry.getKey());
					}
				}
				fp.setCategory(entry.getValue());
				this.fingerprints.add(fp);
			} catch (FingerPrintFileException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * categorizes the text passed to it
	 * 
	 * @param text
	 *            text to be categorized
	 * @return the category name given in the configuration file
	 */
	@Override
	public String categorize(String text) {
		if (text.length() < UNKNOWN_LIMIT) {
			return "unknown";
		}
		FingerPrint fp = new FingerPrint();
		fp.create(text);
		fp.categorize(fingerprints);

		return fp.getCategory();
	}

	/**
	 * categorizes only a certain amount of characters in the text. recommended
	 * when categorizing large texts in order to increase performance.
	 * 
	 * @param text
	 *            text to be analysed
	 * @param limit
	 *            number of characters to be analysed
	 * @return the category name given in the configuration file
	 */
	@Override
	public String categorize(String text, int limit) {
		if (text.length() < UNKNOWN_LIMIT) {
			return "unknown";
		}
		if (limit > (text.length() - 1)) {
			return this.categorize(text);
		}
		return this.categorize(text.substring(0, limit));
	}

	/**
	 * categorizes a text but returns a map containing all categories and their
	 * distances to the text.
	 * 
	 * @param text
	 *            text to be categorized
	 * @return HashMap with categories as keys and distances as values
	 */
	@Override
	public Map<String, Integer> getCategoryDistances(String text) {
		if (this.fingerprints.isEmpty()) {
			loadCategories();
		}
		FingerPrint fp = new FingerPrint();
		fp.create(text);
		fp.categorize(fingerprints);
		return fp.getCategoryDistances();
	}

	/**
	 * reads from stdin til EOF is read. prints the determined category of the
	 * input and terminates afterwards.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		char[] data = new char[1024];
		StringBuffer s = new StringBuffer("");
		if (args.length == 0 || args[0].equals("-categorize")) {
			try {
				InputStreamReader reader = new InputStreamReader(System.in);
				int read;
				while ((read = reader.read(data)) != (-1)) {
					s.append(new String(data, 0, read));
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			TextCategorizer guesser = new TextCategorizer();
			System.out.println(guesser.categorize(s.toString()));
		} else if (args.length > 1 && args[0].equals("-createfp")) {
			FingerPrint fp = new FingerPrint();
			try {
				fp.create(new File(args[1]));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return;
			}
			if (args.length > 2) {
				fp.setCategory(args[2]);
			} else {
				fp.setCategory(args[1].replaceAll("\\..*", ""));
			}
			fp.save();
		} else {
			System.out
					.println("Options:\n\n\t-categorize\tdetermines language of stdin\n\t-createfp <file> <category>\tcreates fingerprint from file");
		}
	}
}
