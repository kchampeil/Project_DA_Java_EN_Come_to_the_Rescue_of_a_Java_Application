package com.hemebiotech.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Read the symptoms file, line by line, and return the list of symptoms
 *
 * @see ISymptomReader
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Read the symptoms file, line by line,
	 * add each line to the list of symptoms
	 * and return the list of symptoms.
	 *
	 * @return List of symptoms (list of strings)
	 */
	@Override
	public List<String> getSymptoms() {
		List<String> result = new ArrayList<>();

		if (filepath != null) {
			BufferedReader reader = null;

			try {
				reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				/* read symptoms in the file until the end, line by line
					and copy them in the list of strings */
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException e) {
				System.out.println(e.getMessage());

			} finally {
				// if reader has been instantiated, we must close it
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException e) {
						System.out.println("Couldn't close the reader");
						System.out.println(e.getMessage());
					}
				}
			}
		}
		
		return result;
	}

}
