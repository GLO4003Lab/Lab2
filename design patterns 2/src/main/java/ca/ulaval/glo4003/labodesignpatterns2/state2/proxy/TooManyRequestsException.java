package ca.ulaval.glo4003.labodesignpatterns2.state2.proxy;

public class TooManyRequestsException extends RuntimeException {

	public TooManyRequestsException(String message) {
		super(message);
	}

	private static final long serialVersionUID = 1L;

}
