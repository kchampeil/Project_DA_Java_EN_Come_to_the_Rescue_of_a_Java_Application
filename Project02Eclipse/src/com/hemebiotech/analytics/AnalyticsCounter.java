package com.hemebiotech.analytics;

import com.hemebiotech.count.CountFrequencyOfSymptoms;
import com.hemebiotech.count.ICount;
import com.hemebiotech.read.ISymptomReader;
import com.hemebiotech.read.ReadSymptomDataFromFile;
import com.hemebiotech.write.ISymptomWriter;
import com.hemebiotech.write.WriteSymptomDataIntoFile;

import java.util.*;

/**
 * Read a file containing symptoms (list of symptoms not sorted and may be duplicated),
 * count the frequency of each symptom and store the couple in a map
 * then write in an output file the symptoms and their frequencies.
 *
 * Output file contains one line by symptom with its number of occurrences in the input file.
 *
 * @author Karine
 * @version 1.0
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

	/**
	 * First, read file with symptoms and put them in a list of strings listOfSymptoms.
	 * Then, count the frequency of each symptom and fill a map symptom/frequency mapOfSymptomsAndFrequencies.
	 * Finally, generate output file from the map mapOfSymptomsAndFrequencies.
	 *
	 * @param args
	 * @see ReadSymptomDataFromFile
	 * @see CountFrequencyOfSymptoms
	 * @see WriteSymptomDataIntoFile
	 */
	public static void main(String[] args) {
		// First, read file with symptoms and put them in listOfSymptoms
		ISymptomReader symptomReader = new ReadSymptomDataFromFile(SYMPTOMSFILENAME);
		List<String> listOfSymptoms = symptomReader.getSymptoms();

		if (listOfSymptoms.size()!=0) {

			//Then, count the frequency of each symptom and fill a sorted map symptom/frequency
			ICount count = new CountFrequencyOfSymptoms(listOfSymptoms);
			Map<String, Integer> mapOfSymptomsAndFrequencies = count.count();

			// Finally, generate output file from consolidatedListOfSymptoms
			ISymptomWriter symptomWriter = new WriteSymptomDataIntoFile(RESULTSFILENAME);
			symptomWriter.writeSymptoms(mapOfSymptomsAndFrequencies);

		} else System.out.println("No symptom in the input file");
	}
}
