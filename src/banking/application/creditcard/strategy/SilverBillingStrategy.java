package banking.application.creditcard.strategy;

public class SilverBillingStrategy implements CreditCardBillingStrategy{

	@Override
	public double minimumPayment(double withdrawalAmount) {
		return withdrawalAmount * 0.12;
	}

	@Override
	public double monthlyPayment(double amountOwing, double amountPaying) {
		return (amountOwing - amountPaying) * 0.08;
	}
 

}
