package banking.application.creditcard.strategy;

public class BronzeBillingStrategy implements CreditCardBillingStrategy {

    @Override
    public double minimumPayment(double withdrawalAmount) {
        return withdrawalAmount * getMinimumPayment();

    }

    @Override
    public double monthlyPayment(double amountOwing, double amountPaying) {
        return (amountOwing - amountPaying) * getMonthlyInterest();
    }

    @Override
    public double getMonthlyInterest() {
        return 0.1;
    }

    @Override
    public double getMinimumPayment() {
        return 0.14;
    }


}
