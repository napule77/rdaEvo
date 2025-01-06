package com.amalfi.rdaevo.service;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
/**
 * Class response for front end and internal services
 * NOTE: EVERY PROPERTY EDIT MUST BE SYNCED WITH FRONT END
 */
public class DTOServiceResult<T>  extends DTOBase implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DTOServiceResultMessage message;
    private T data;

    /**
     * Creates a new result
     * @param data wrapped data
     * @param type message 'severity'
     * @param messages message content
     */
    public DTOServiceResult(T data, DTOServiceResultMessage.Type type, String... messages) {
        this.data = data;
        this.message = new DTOServiceResultMessage(messages, type);
    }

}