package com.hemebiotech.analytics;

import java.util.List;

/**
 * Anything that will write symptom data into a recipient
 * The input value from the operation, which is a list of strings,
 * that may contain many duplications
 *
 */
public interface ISymptomWriter {

    /**
     *
     * @param listOfSymptoms a list of strings (symptoms) ordered alphabetically
     */
    void writeSymptoms (List<String> listOfSymptoms);
}
