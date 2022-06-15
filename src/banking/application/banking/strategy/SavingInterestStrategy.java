package banking.application.banking.strategy;

public class SavingInterestStrategy implements AccountInterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return balance * 0.25;
    }
}
