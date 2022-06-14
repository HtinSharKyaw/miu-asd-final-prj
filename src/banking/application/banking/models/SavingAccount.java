package banking.application.banking.models;

import banking.application.banking.strategy.AccountInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType, AccountInterestStrategy accountInterestStrategy) {
        super(accountNumber, customer, balance, accountType, accountInterestStrategy);
    }
}
