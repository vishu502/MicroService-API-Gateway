/**
 * 
 */
package com.msa.user.exception;


import lombok.Data;

/**
 * 
 *
 * @author atul.kumar01
 * @version $Revision: 1.10 $
 */
@Data
public class RecordNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * The serialVersionUID.
     */

    private Object[] arguments;


    public RecordNotFoundException(String code,String className,String methodName, Object... args) {
        this.arguments = args;
    }

   

    public RecordNotFoundException(String code,String className,String methodName,Throwable cause, Object... args) {
        this.arguments = args;
    }


}
