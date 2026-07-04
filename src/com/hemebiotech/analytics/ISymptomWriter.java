package com.hemebiotech.analytics;

import java.util.Map;
import java.io.IOException;

/**
 * Anything that will write symptom data to a file
 * The important part is, the return value from the operation, which is a Map of strings and Integer.
 * No duplication
 * 
 * The implementation order the list.
 * 
 */
public interface ISymptomWriter {
	/**
	 * If no data is available, return an empty List
	 * 
	 * 
	 */
	void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
