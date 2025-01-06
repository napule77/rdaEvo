package com.amalfi.rdaevo.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DTOServiceResultMessage extends DTOBase {
    public enum Type {
        /**
         * Correct execution, all is fine
         **/
        OK,
        /**
         *  Warning message, not blocking but nice to be aware of (warning message to user?)
         */
        WARNING,
        /**
         * Workflow execution blocked due to error
         */
        ERROR,
        /**
         * All hope is lost, run for your life!
         */
        FATAL
    }

    String[] texts;
    Type type;
}