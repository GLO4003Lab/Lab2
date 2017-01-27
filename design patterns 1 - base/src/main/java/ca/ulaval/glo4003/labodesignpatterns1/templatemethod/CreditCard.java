package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

public abstract class CreditCard {
	protected final String name;
	protected final String number;
	protected final int expirationYYYY;
	protected final int expirationMM;
	protected final int cvv;
	
	protected CreditCard(final String name, final String number, final int expirationMM,
			int expirationYYYY, int cvv) {
		this.name = name;
		this.number = number;
		this.expirationMM = expirationMM;
		this.expirationYYYY = expirationYYYY;
		this.cvv = cvv;
	}

	protected abstract boolean isExpirationDateValid();

	protected abstract boolean hasValidChars();

	protected abstract boolean isValidPrefix();

	protected abstract boolean isNumberOfDigitsValid();

	protected abstract boolean isAccountInGoodStanding();

	protected abstract boolean isCvvValid();

	public boolean isValid(){
		if (!isExpirationDateValid()) {
			System.out.println(name + ": Invalid expiration date");
			return false;
		}
		if (!hasValidChars()) {
			System.out.println(name + ": Invalid characters in card number");
			return false;
		}
		if (!isValidPrefix()) {
			System.out.println(name + ": Invalid card prefix");
			return false;
		}
		if (!isNumberOfDigitsValid()) {
			System.out.println(name
					+ ": Invalid number of digits in card number");
			return false;
		}
		if (!isAccountInGoodStanding()) {
			System.out.println(name + ": Account is not in good standing");
			return false;
		}
		if (!isCvvValid()) {
			System.out.println(name + ": Invalid CVV number");
			return false;
		}

		System.out.println(name + ": Credit card is valid.");
		return true;
	}
}
