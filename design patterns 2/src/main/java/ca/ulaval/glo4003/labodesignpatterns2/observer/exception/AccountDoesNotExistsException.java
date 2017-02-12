package ca.ulaval.glo4003.labodesignpatterns2.observer.exception;

public class AccountDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountDoesNotExistsException(String message) {
		super(message);
	}

}
