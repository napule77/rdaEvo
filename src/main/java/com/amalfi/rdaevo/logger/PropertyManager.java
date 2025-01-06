package com.amalfi.rdaevo.logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PropertyManager {

    @Autowired
    private Environment environment;



    public String getString(String name) {
        return environment.getProperty(name);
    }

    /**
     * Retrieves a Boolean from property file
     *
     * @param name property name
     * @return Boolean.TRUE if prop value is 'true', otherwise Boolean.FALSE
     */
    public Boolean getBoolean(String name) {
        String propertyValue = getString(name);
        return Boolean.parseBoolean(propertyValue);
    }

    public Long getLong(String name) {
        return Long.parseLong(getString(name));
    }

    private List<String> getList(String name, String delimiter) {
        String prop = getString(name);
        if(StringUtils.isNotEmpty(prop)){
            return Arrays.asList(prop.split(delimiter));
        }
        return new ArrayList<>();
    }

    /**
     * Retrieves a list of values from property file
     *
     * @param name property name
     * @return value of requested property, split by property 'crif.default.properties.delimiter'
     */
    public List<String> getList(String name) {
        return getList(name, getString(PropertyKeys.PROPERTIES_DEFAULT_DELIMITER));
    }

    /**
     * Retrieves an array of values from property file
     *
     * @param name property name
     * @return value of requested property, split by property 'crif.default.properties.delimiter'
     */
    public String[] getArray(String name) {
        return getList(name).toArray(new String[0]);
    }

    public Map<String, String> getMap(String name) {
        Map<String, String> requestedPropertymap = new HashMap<>();
        String mapEntryDelimiter = getString(PropertyKeys.PROPERTIES_DEFAULT_MAP_ENTRY_DELIMITER);
        getList(name).forEach(item -> {
            String key = item.split(mapEntryDelimiter)[0];
            String value = item.split(mapEntryDelimiter)[1];
            requestedPropertymap.put(key, value);
        });
        return requestedPropertymap;
    }

    /**
     * Retrieves a full url+path given the required property
     *
     * @param name property name
     * @return APPLICATION_URL +  value of the 'name' property
     */
    public String getApplicationUrl(String name) {
        String applicationUrl = getString(PropertyKeys.URL_BASE_APPLICATION);
        return applicationUrl + getString(name);
    }
}
