package banking.application.creditcard.strategy;

import banking.application.banking.strategy.AccountInterestStrategy;

public class CreditCardInterestStrategy implements AccountInterestStrategy {

	@Override
	public double calculateInterest(double balance) {
		return 0;
	}

}
