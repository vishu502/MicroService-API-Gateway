package com.msa.order.error;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * This class contains the error code and error message.
 *
 * @author vishalTyagi
 * @version $Revision: 1.10 $
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Error {

	/**
	 * The errorCode.
	 */
	private String errorCode;

	/**
	 * The errorMessage.
	 */
	private String errorMessage;

}
