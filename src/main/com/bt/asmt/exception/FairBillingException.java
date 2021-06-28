package main.com.bt.asmt.exception;
/*
 * This custom exception class represents fair billing application specific exception
 */
public class FairBillingException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String message;

	public FairBillingException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
