package com.resideo.commons.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple log4j-style wrapper around SLF4J for FrameworkGlobalVariables.logger4J.
 * Provides logFatal() and logError() methods used by the project.
 */
public class Logger4JWrapper {

    private static final Logger logger = LoggerFactory.getLogger("FrameworkLogger");

    public void logFatal(String message) {
        logger.error("[FATAL] " + message);
    }

    public void logError(String message) {
        logger.error(message);
    }

    public void logWarn(String message) {
        logger.warn(message);
    }

    public void logInfo(String message) {
        logger.info(message);
    }

    public void logDebug(String message) {
        logger.debug(message);
    }
}
