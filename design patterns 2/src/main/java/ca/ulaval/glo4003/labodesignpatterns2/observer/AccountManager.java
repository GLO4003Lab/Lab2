package ca.ulaval.glo4003.labodesignpatterns2.observer;

import java.util.HashMap;
import java.util.Map;

import ca.ulaval.glo4003.labodesignpatterns2.observer.Account.AccountType;
import ca.ulaval.glo4003.labodesignpatterns2.observer.exception.AccountDoesNotExistsException;

public class AccountManager extends AccountCreationObservable {

	public Map<String, Account> accounts = new HashMap<>();

	public void createAccount(String username, String email, AccountType type) {
		Account account = new Account(username, email, type);
		accounts.put(email, account);
		notifyUserCreated(account.getEmail(), account);
	}

	public void changeAccountType(String email, AccountType type)
			throws AccountDoesNotExistsException {

		Account account = accounts.get(email);
		if (account != null) {
			account.setAccountType(type);
			accounts.put(email, account);
		} else {
			throw new AccountDoesNotExistsException(
					"Add user before trying to change values.");
		}
	}

}
