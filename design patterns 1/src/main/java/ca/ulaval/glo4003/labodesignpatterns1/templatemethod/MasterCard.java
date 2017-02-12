package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

import java.time.LocalDate;

import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient;
import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient.CreditCards;

public class MasterCard extends CreditCard {

	private final CreditStandingValidationClient creditStandingValidationClient;
	
	public MasterCard(String name, String number, int expirationMM,
			int expirationYYYY, int cvv,
			CreditStandingValidationClient creditStandingValidationClient) {
		super(name,  number,  expirationMM, expirationYYYY,  cvv);
		this.creditStandingValidationClient = creditStandingValidationClient;
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
		int prefix = Integer.parseInt(number.substring(0, 2));
		if (prefix >= 51 && prefix <= 55) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isNumberOfDigitsValid() {
		if (number.length() == 16) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isAccountInGoodStanding() {
		return creditStandingValidationClient
				.validateCreditStandingByCardNumber(number,
						CreditCards.MASTERCARD);
	}

	@Override
	protected boolean isCvvValid() {
		if (cvv > 300 && cvv < 400) {
			return true;
		}
		return false;
	}
}
