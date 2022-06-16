package banking.application.creditcard.strategy;

import java.io.Serializable;

public class GoldBillingStrategy implements CreditCardBillingStrategy, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2968491727643379460L;

	@Override
	public double minimumPayment(double withdrawalAmount) {
		return withdrawalAmount * 0.1;
		
	}

	@Override
	public double monthlyPayment(double amountOwing, double amountPaying) {
		return (amountOwing - amountPaying) * 0.06;
		
	}

	@Override
	public double getMonthlyInterest() {
		return 0.06;
	}

	@Override
	public double getMinimumPayment() {
		return 0.1;
	}

}
