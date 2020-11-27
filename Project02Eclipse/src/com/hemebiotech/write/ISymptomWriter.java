package com.hemebiotech.write;

import java.util.Map;

/**
 * Anything that will write symptom data into a recipient
 * The input value of the operation is a map of string/integer, containing unique values and ordered alphabetically
 *
 */
public interface ISymptomWriter {

    /**
     *
     * @param mapOfSymptoms a map containing symptoms (String) and their frequencies (Integer)
     */
    void writeSymptoms (Map<String,Integer> mapOfSymptoms);

}
