package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.logger.AMALFILogger;
import com.amalfi.rdaevo.logger.PropertyManager;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected AMALFILogger crifLogger;

    @Autowired
    protected PropertyManager propertyManager;
    /***
     * Extracts user of request from SecurityContextHolder
     * @param userRequired whether the user presence is required or not
     * @return optional wrapping the user if present, empty optional otherwise
     */

}
