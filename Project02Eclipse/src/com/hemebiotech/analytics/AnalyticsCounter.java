package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedpupilCount = 0;

	private static final String SYMPTOMSFILENAME = "C:\\tests\\P2\\symptoms.txt";
	private static final String RESULTSFILENAME = "C:\\tests\\P2\\results.out";

	public static void main(String[] args) throws Exception {
		try {
			// first get input

			BufferedReader reader = new BufferedReader (new FileReader(SYMPTOMSFILENAME));
			String line = reader.readLine();

			while (line != null) {
				System.out.println("symptom from file: " + line);
				switch (line) {
					case "headache":
						headacheCount++;
						break;
					case "rash":
						rashCount++;
						break;
					case "dialated pupils":
						dialatedpupilCount++;
						break;
				}

				line = reader.readLine();	// get another symptom
			}

			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("input file or folder for input file does not exist");
			return;
		}

		
		// next generate output
		try {
			FileWriter writer = new FileWriter(RESULTSFILENAME);
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dialated pupils: " + dialatedpupilCount + "\n");
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("folder for output file not available");
		}
	}
}
