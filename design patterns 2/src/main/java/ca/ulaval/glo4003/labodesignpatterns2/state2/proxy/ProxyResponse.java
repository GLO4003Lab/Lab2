package ca.ulaval.glo4003.labodesignpatterns2.state2.proxy;

public class ProxyResponse {

	public final boolean succeeded;
	public final String response;

	public ProxyResponse(boolean succeeded, String response) {
		this.succeeded = succeeded;
		this.response = response;
	}

}
