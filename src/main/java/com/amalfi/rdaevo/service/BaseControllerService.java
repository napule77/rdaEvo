package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.logger.AMALFILogger;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class BaseControllerService extends BaseService {

    @Autowired
    protected AMALFILogger crifLogger;

    /**
     * Creates a service result
     *
     * @param resultData wrapped return data
     * @param type       type of result
     * @param text       array of messages
     * @param <T>        type of resultData
     * @return
     */
    protected <T> DTOServiceResult<T> createServiceResult(T resultData, DTOServiceResultMessage.Type type, String... text) {
        if (text != null && text.length > 0) {
            logApplicationResultMessage(text);
        }
        return new DTOServiceResult<>(resultData, type, text);
    }

    protected <T> DTOServiceResult<T> createServiceResult(DTOServiceResultMessage.Type type, String... text) {
       return createServiceResult(null, type, text);
    }


    /**
     * Convenience method - creates a successful service result.
     *
     * @param resultData wrapped return data
     * @param <T>        type of resultData
     * @return DTOServiceResult with DTOServiceResultMessage.Type.OK
     */
    protected <T> DTOServiceResult<T> createServiceResult(T resultData) {
        return createServiceResult(resultData, DTOServiceResultMessage.Type.OK);
    }
    protected <T> DTOServiceResult<T> createServiceResult() {
        return createServiceResult(null);
    }

    private void logApplicationResultMessage(String... text) {
        Arrays.asList(text).forEach(logMessage -> crifLogger.logMessage(this.getClass(), Level.DEBUG, logMessage));
    }

}
