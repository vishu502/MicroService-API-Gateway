package com.msa.user.controller.dto;

import java.io.Serializable;
import java.util.List;
import com.msa.user.error.Error;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author vishaltyagi
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
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
