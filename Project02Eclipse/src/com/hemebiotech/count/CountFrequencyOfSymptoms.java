package com.hemebiotech.count;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * Count the frequency of symptoms in a list and return a map symptom/frequency, ordered alphabetically
 *
 * @see ICount
 */
public class CountFrequencyOfSymptoms implements ICount {

    private List<String> listOfSymptoms;

    /**
     *
     * @param listOfSymptoms a list of strings containing symptoms.
     *                       It may contain many duplications and is not necessary sorted.
     */

    public CountFrequencyOfSymptoms (List<String> listOfSymptoms) {
        this.listOfSymptoms = listOfSymptoms;
    }

    /**
     * Read a list of symptoms and write the symptom (key) and its frequency (value)
     * in consolidatedMapOfSymptoms map.
     * Symptoms are ordered alphabetically in the map.
     *
     * @return a map containing symptoms (key) and their frequencies (value)
     *          ordered alphabetically on symptom names
     */
    @Override
    public Map<String, Integer> count() {

        Map<String, Integer> consolidatedMapOfSymptoms = new TreeMap<>();

        /* read symptoms in the list, one by one and:
            -> add it to the map with value 1 if never seen before (j==null)
            or
            -> add 1 to existing value if already seen (j!=null)
         */
        for (String i : listOfSymptoms) {
            Integer j = consolidatedMapOfSymptoms.get(i);
            consolidatedMapOfSymptoms.put(i, (j == null) ? 1 : j+1);
        }

        return consolidatedMapOfSymptoms;
    }
}
