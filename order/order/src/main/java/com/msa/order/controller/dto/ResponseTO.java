package com.msa.order.controller.dto;


import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.msa.order.error.Error;;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTO<T> implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 6472242732428902250L;

	/**
     * The error.
     */
    private boolean error;

    /**
     * The errors.
     */
    private List<Error> errors;

    /**
     * The data.
     */
    private T data;

    public ResponseTO(T result) {
    }

}

