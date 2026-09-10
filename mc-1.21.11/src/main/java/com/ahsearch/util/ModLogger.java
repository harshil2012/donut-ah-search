package com.ahsearch.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModLogger {
    private static final Logger LOGGER = LoggerFactory.getLogger("AHSearch");

    public static void info(String message, Object... args) {
        LOGGER.info("[AH Search+] " + String.format(message, args));
    }

    public static void warn(String message, Object... args) {
        LOGGER.warn("[AH Search+] " + String.format(message, args));
    }

    public static void error(String message, Throwable throwable) {
        LOGGER.error("[AH Search+] " + message, throwable);
    }

    public static void error(String message, Object... args) {
        LOGGER.error("[AH Search+] " + String.format(message, args));
    }
}
