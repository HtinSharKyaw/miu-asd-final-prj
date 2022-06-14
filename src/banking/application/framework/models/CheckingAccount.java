package banking.application.framework.models;

import banking.application.framework.enums.AccountType;

public class CheckingAccount extends Account{
    public CheckingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType, AccountInterestStrategy accountInterestStrategy) {
        super(accountNumber, customer, balance, accountType, accountInterestStrategy);
    }
}
