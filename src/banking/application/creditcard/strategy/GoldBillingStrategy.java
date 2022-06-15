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
 
}
