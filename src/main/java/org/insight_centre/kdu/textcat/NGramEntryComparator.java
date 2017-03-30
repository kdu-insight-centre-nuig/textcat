package org.insight_centre.kdu.textcat;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map.Entry;

/**
 * @author Thomas Hammerl
 * 
 * Comparator for NGram entries in the FingerPrint collection. sorts a set of
 * entries in a FingerPrint collection in descending order.
 * 
 */
class NGramEntryComparator implements Comparator<Entry<String, Integer>>, Serializable {

    /**
         * @param entry1 n NGram entry
         * @param entry2 another NGram entry
         * @return a number indicating the relation of entry1 to entry2
         */
    public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
		if (entry2.getValue() - entry1.getValue() == 0) {
			if (entry1.getKey().length() - entry2.getKey().length() == 0) {
			return entry1.getKey().compareTo(entry2.getKey());
			}
			return entry1.getKey().length() - entry2.getKey().length();
		}
		return entry2.getValue() - entry1.getValue();
    }

}
