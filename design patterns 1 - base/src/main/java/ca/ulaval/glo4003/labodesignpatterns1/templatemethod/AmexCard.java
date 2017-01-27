package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

import java.time.LocalDate;

public class AmexCard extends CreditCard {
	private String number;
	private int expirationYYYY;
	private int expirationMM;
	private int cvv;

	public AmexCard(String name, String number, int expirationMM,
			int expirationYYYY, int cvv) {
		super(name);
		this.number = number;
		this.expirationMM = expirationMM;
		this.expirationYYYY = expirationYYYY;
		this.cvv = cvv;
	}

	@Override
	protected boolean isExpirationDateValid() {
		if (expirationMM >= 1 && expirationMM <= 12) {
			int validityTime = expirationYYYY - LocalDate.now().getYear();
			if (validityTime <= 3 && validityTime >= 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean hasValidChars() {
		try {
			Long.parseLong(number);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	@Override
	protected boolean isValidPrefix() {
		if (number.startsWith("34") || number.startsWith("37")) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isNumberOfDigitsValid() {
		if (number.length() == 15) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isAccountInGoodStanding() {
		return true;
	}

	@Override
	protected boolean isCvvValid() {
		if (cvv > 100 && cvv < 500) {
			return true;
		}
		return false;
	}

}
