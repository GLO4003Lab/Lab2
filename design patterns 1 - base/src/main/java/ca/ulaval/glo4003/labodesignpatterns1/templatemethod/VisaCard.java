package ca.ulaval.glo4003.labodesignpatterns1.templatemethod;

import java.time.LocalDate;

import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient;
import ca.ulaval.glo4003.labodesignpatterns1.tools.CreditStandingValidationClient.CreditCards;

public class VisaCard extends CreditCard {
	private String number;
	private int expirationYYYY;
	private int expirationMM;
	private int cvv;
	private CreditStandingValidationClient creditStandingValidationClient;

	public VisaCard(String name, String number, int expirationMM,
			int expirationYYYY, int cvv,
			CreditStandingValidationClient creditStandingValidationClient) {
		super(name);
		this.number = number;
		this.expirationMM = expirationMM;
		this.expirationYYYY = expirationYYYY;
		this.cvv = cvv;
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
		if (number.startsWith("4")) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isNumberOfDigitsValid() {
		if (number.length() == 13 || number.length() == 16) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean isAccountInGoodStanding() {
		return creditStandingValidationClient
				.validateCreditStandingByCardNumber(number, CreditCards.VISA);
	}

	@Override
	protected boolean isCvvValid() {
		if (cvv > 100 && cvv < 400) {
			return true;
		}
		return false;
	}
}
