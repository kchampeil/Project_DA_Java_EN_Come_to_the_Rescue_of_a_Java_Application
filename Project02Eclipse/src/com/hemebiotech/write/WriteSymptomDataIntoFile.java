package com.hemebiotech.write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 *  Read the alphabetically-sorted map of symptoms/frequency and write them in a file.
 *  One line by symptom, mentioning symptom and its frequency.
 *
 * @see ISymptomWriter
 */
public class WriteSymptomDataIntoFile implements ISymptomWriter{

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to the output file
     */
    public WriteSymptomDataIntoFile (String filepath) {
        this.filepath = filepath;
    }

    /**
     * Read the alphabetically-sorted map of symptoms/frequency, element by element
     * and write in file each symptom and its frequency
     * One symptom by line
     *
     * @param consolidatedMapOfSymptoms a Map containing symptoms (String) and their frequencies (Integer)
     *                                   (ordered alphabetically on symptom names)
     */
    @Override
    public void writeSymptoms(Map<String, Integer> consolidatedMapOfSymptoms) {

        if (filepath != null) {
            FileWriter writer = null;

            try {
                writer = new FileWriter(filepath);

                /* browse the entries of the map one by one
                    and write in the output file the symptom, its frequency and a line break*/
                for (Map.Entry<String, Integer> symptom : consolidatedMapOfSymptoms.entrySet()) {
                    writer.write(symptom.getKey() + " " + symptom.getValue() + "\n");
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());

            } finally {
                // if writer has been instantiated, we must close it
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        System.out.println("Couldn't close the writer");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
