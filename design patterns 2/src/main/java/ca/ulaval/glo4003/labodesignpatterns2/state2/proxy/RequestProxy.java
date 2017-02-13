package ca.ulaval.glo4003.labodesignpatterns2.state2.proxy;

// Dans la définition du pattern, cette classe correspond au Contexte
public class RequestProxy {

	private ProxyState state;

	public RequestProxy() {
		state = new ProxyNormalState();
	}

	public ProxyResponse makeRequest(String url) {
		try {
			String response = state.callUrl(this, url);
			return new ProxyResponse(true, response);
		} catch (TooManyRequestsException ex) {
			return new ProxyResponse(false, ex.getMessage());
		}
	}

	void setState(ProxyState context) {
		this.state = context;
	}

}
