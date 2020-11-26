package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
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
     * @param listOfSymptoms a list of strings (symptoms) ordered alphabetically
     */
    @Override
    public void writeSymptoms(List<String> listOfSymptoms) {

        if (filepath != null) {
            try {
                FileWriter writer = new FileWriter(filepath);

                String previousSymptomInList = "";

                for (int i = 0; i < listOfSymptoms.size(); i++) {
                    //tests to remove at the end
                    System.out.println(listOfSymptoms.get(i));
                    System.out.println("previousSymptomInList : " + previousSymptomInList);

                    if (!previousSymptomInList.equals(listOfSymptoms.get(i))) {
                        System.out.println("'" + listOfSymptoms.get(i) + " " + Collections.frequency(listOfSymptoms, listOfSymptoms.get(i)) + "'" + " written in file \n");
                        writer.write(listOfSymptoms.get(i) + " " + Collections.frequency(listOfSymptoms, listOfSymptoms.get(i)) + "\n");
                        previousSymptomInList = listOfSymptoms.get(i);
                    }
                    //tests to remove at the end
                    else System.out.println("nothing to do, go to next symptom to analyze \n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
