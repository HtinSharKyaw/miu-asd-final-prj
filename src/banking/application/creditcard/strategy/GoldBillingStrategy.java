package banking.application.creditcard.strategy;

public class GoldBillingStrategy implements CreditCardBillingStrategy{

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
