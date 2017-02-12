package ca.ulaval.glo4003.labodesignpatterns2.observer;

import java.util.ArrayList;
import java.util.List;

public class AccountCreationObservable {

	private List<AccountCreationObserver> observers = new ArrayList<>();

	public void register(AccountCreationObserver observer) {
		observers.add(observer);
	}

	public void unregister(AccountCreationObserver observer) {
		observers.remove(observer);
	}

	public void notifyUserCreated(String email, Account account) {
		for (AccountCreationObserver observer : observers) {
			observer.listenUserCreated(email, account);
		}
	}

}
