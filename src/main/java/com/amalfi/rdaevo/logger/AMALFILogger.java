package com.amalfi.rdaevo.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class AMALFILogger {
    private final Map<Class<?>, Logger> CLASS_LOGGER_MAPPING = Collections.synchronizedMap(new HashMap<>());

    //TODO - Move to property
    private static final String LINE_SEPARATOR = "\n";

    private Logger getRelatedClassLogger(Class<?> classForInitialization) {
        if (!CLASS_LOGGER_MAPPING.containsKey(classForInitialization)) {
            Logger logger = LoggerFactory.getLogger(classForInitialization);
            CLASS_LOGGER_MAPPING.put(classForInitialization, logger);
        }
        return CLASS_LOGGER_MAPPING.get(classForInitialization);
    }

    /**
     * Logs a message depending on the logLevel compared to property PropertyKeys.APPLICATION_LOGLEVEL
     *
     * @param sourceOfLog caller class
     * @param logLevel    severity of message
     * @param message     content to log
     */
    public void logMessage(@NonNull Class<?> sourceOfLog, @NonNull Level logLevel, String message) {
        Logger logger = getRelatedClassLogger(sourceOfLog);
        switch (logLevel) {
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case TRACE:
                logger.trace(message);
                break;
        }
    }

    /**
     * Logs an exception as ERORR LogLevel
     *
     * @param sourceOfLog    caller class
     * @param exceptionToLog exception to log
     */
    public void logException(@NonNull Class<?> sourceOfLog, Exception exceptionToLog) {
        StringBuilder stacktraceBuilder = new StringBuilder();
        stacktraceBuilder.append(exceptionToLog.getCause());
        stacktraceBuilder.append(LINE_SEPARATOR);
        stacktraceBuilder.append(exceptionToLog.getMessage());
        stacktraceBuilder.append(LINE_SEPARATOR);
        for (StackTraceElement element : exceptionToLog.getStackTrace()) {
            stacktraceBuilder.append(element.toString());
            stacktraceBuilder.append(LINE_SEPARATOR);
        }
        logMessage(sourceOfLog, Level.ERROR, stacktraceBuilder.toString());
    }

    /**
     * Desperate times require desperate solutions.
     * NOTE: This should never be used. Refer to logMessage(Class, CRIFLogLevel, String/Exception) instead
     *
     * @param logLevel
     * @param message
     */
    @Deprecated
    public static void logMessageBypassAll(Level logLevel, String message) {
        Logger SHOULD_NEVER_BE_USED_LOGGER = LoggerFactory.getLogger(AMALFILogger.class);
        switch (logLevel) {
            case INFO:
                SHOULD_NEVER_BE_USED_LOGGER.info(message);
                break;
            case WARN:
                SHOULD_NEVER_BE_USED_LOGGER.warn(message);
                break;
            case ERROR:
                SHOULD_NEVER_BE_USED_LOGGER.error(message);
                break;
            case DEBUG:
                SHOULD_NEVER_BE_USED_LOGGER.debug(message);
                break;
            case TRACE:
                SHOULD_NEVER_BE_USED_LOGGER.trace(message);
                break;
        }
    }
}
