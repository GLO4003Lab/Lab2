package ca.ulaval.glo4003.labodesignpatterns2.observer;

public class UserNotifier implements AccountCreationObserver {

	@Override
	public void listenUserCreated(String email, Account account) {
		System.out.println("User notifier: email sent to address " + email);
	}

}
