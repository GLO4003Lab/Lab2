package ca.ulaval.glo4003.labodesignpatterns2.observer;

import ca.ulaval.glo4003.labodesignpatterns2.observer.Account.AccountType;

public class ObserverMain {

	public static void main(String[] args) {
		UserNotifier userNotifier = new UserNotifier();
		// TODO implement the communication logger
		// userNotifier.register(communicationLogger);
		AccountManager accountManager = new AccountManager();
		accountManager.register(userNotifier);
		// TODO implement the communication logger
		// accountManager.register(communicationLogger);

		accountManager.createAccount("Legolas", "legolas@mordor.me",
				AccountType.USER);

		accountManager.createAccount("Gimli", "gimli@mordor.me",
				AccountType.USER);

		accountManager.createAccount("Aragorn", "aragorn@mordor.me",
				AccountType.USER);

		accountManager
				.changeAccountType("aragorn@mordor.me", AccountType.ADMIN);
	}

}
