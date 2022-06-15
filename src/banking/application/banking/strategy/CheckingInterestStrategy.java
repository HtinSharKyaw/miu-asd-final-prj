package banking.application.banking.strategy;

public class CheckingInterestStrategy implements AccountInterestStrategy {
    @Override
    public double calculateInterest(double balance) {
        return 0.15 * balance;
    }
}
