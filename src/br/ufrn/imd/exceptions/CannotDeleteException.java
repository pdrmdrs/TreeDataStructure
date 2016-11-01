package br.ufrn.imd.exceptions;

public class CannotDeleteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3507353714336337005L;
	
	public CannotDeleteException() {}
	
	public CannotDeleteException(String message) {
		super(message);
	}
}
