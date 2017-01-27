package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

public abstract class CreditCard {
	protected String name;
	
	protected CreditCard(String name){
		this.name = name;
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
