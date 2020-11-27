package com.hemebiotech.count;

import java.util.Map;

/**
 * Anything that will count values
 * The return value from the operation, which is a map of strings (key) and integers (values).
 *
 */
public interface ICount {

    Map<String, Integer> count();
}
