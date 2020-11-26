package com.hemebiotech.analytics;

import java.util.*;

/**
 * Read a file containing symptoms (list of symptoms not sorted and may be duplicated),
 * count the number of occurrences for each symptom
 * and write in an output file an alphabetically sorted list of symptoms.
 * One line by symptom with its number of occurrences identified in the input file.
 *
 * @author Karine
 */
public class AnalyticsCounter {

	/**
	 * Filename (including relative filepath) of the input file containing the list of symptoms
	 */
	private static final String SYMPTOMSFILENAME = "Project02Eclipse\\tests\\symptoms.txt";

	/**
	 * Filename (including relative filepath) of the output file
	 */
	private static final String RESULTSFILENAME = "Project02Eclipse\\tests\\results.out";

	public static void main(String[] args) {

		// First, read file with symptoms and put
		ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(SYMPTOMSFILENAME);
		List<String> listOfSymptoms = readSymptomDataFromFile.getSymptoms();
		System.out.println("Symptom file contains : " + listOfSymptoms.size() + " occurrences \n");

		if (listOfSymptoms.size()!=0) {

			// tests to remove at the end
			System.out.println("first before sorting : " + listOfSymptoms.get(0));
			System.out.println("last before sorting : " + listOfSymptoms.get(listOfSymptoms.size()-1));

			// Then, sort alphabetically the listOfSymptoms
			Collections.sort(listOfSymptoms);

			// tests to remove at the end
			System.out.println("first after sorting : " + listOfSymptoms.get(0));
			System.out.println("last after sorting : " + listOfSymptoms.get(listOfSymptoms.size()-1));

			// Finally, generate output
			WriteSymptomDataIntoFile writeSymptomDataIntoFile = new WriteSymptomDataIntoFile(RESULTSFILENAME);
			writeSymptomDataIntoFile.writeSymptoms(listOfSymptoms);
		}
	}
}
