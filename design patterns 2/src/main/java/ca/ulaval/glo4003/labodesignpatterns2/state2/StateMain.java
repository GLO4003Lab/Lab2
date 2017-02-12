package ca.ulaval.glo4003.labodesignpatterns2.state2;

import ca.ulaval.glo4003.labodesignpatterns2.state2.proxy.ProxyResponse;
import ca.ulaval.glo4003.labodesignpatterns2.state2.proxy.RequestProxy;

public class StateMain {

	public static void main(String[] args) {

		RequestProxy proxy = new RequestProxy();

		log(proxy.makeRequest("http://google.com"));
		log(proxy.makeRequest("http://yahoo.com"));
		log(proxy.makeRequest("http://amazon.com"));
		log(proxy.makeRequest("http://ebay.com"));
		log(proxy.makeRequest("http://facebook.com"));

		// On attend 6 secondes pour être sur que le délai de 5 secondes soit passé.
		sleep(6000);

		log(proxy.makeRequest("http://wikipedia.org"));

	}

	private static void log(ProxyResponse response) {
		System.out.println("Request succeeded : " + response.succeeded + ". Message: " + response.response);
	}

	private static void sleep(int durationInMillis) {
		try {
			System.out.println("Sleeping for " + durationInMillis + "ms");
			Thread.sleep(durationInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
