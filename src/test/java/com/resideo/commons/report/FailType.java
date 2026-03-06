package com.resideo.commons.report;

/**
 * Local override of FailType from Core_Framework 1.0.1.
 * Adds missing PASSWITH_FAILURE constant that the project requires.
 */
public interface FailType {
    int NO_FAILURE = 0;
    int FUNCTIONAL_FAILURE = 1;
    int COSMETIC_FAILURE = 2;
    int FRAMEWORK_CONFIGURATION = 3;
    int FALSE_POSITIVE = 4;
    // Additional constant required by the project
    int PASSWITH_FAILURE = 5;
}
