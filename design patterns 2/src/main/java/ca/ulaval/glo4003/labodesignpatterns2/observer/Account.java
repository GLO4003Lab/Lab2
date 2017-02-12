package ca.ulaval.glo4003.labodesignpatterns2.observer;


public class Account {
	public enum AccountType {
		USER, ADMIN
	};

	private AccountType accountType;
	private String username;
	private String email;

	public Account(String username, String email, AccountType type) {
		this.username = username;
		this.email = email;
		accountType = type;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
