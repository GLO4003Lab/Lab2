package ca.ulaval.glo4003.labodesignpatterns2.observer;

public interface AccountCreationObserver {

	public void listenUserCreated(String email, Account account);

}
