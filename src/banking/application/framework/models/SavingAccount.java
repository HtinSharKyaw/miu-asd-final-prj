package banking.application.framework.models;

import banking.application.framework.enums.AccountType;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType, AccountInterestStrategy accountInterestStrategy) {
        super(accountNumber, customer, balance, accountType, accountInterestStrategy);
    }
}
