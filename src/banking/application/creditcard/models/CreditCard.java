package banking.application.creditcard.models;

import banking.application.banking.strategy.AccountInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.enums.CreditCardType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class CreditCard extends Account {

    private Double minimumPaymentAmount;
    private CreditCardType creditCardType;

    public CreditCard(String accountNumber, Customer customer, Double balance,
                      AccountType accountType, AccountInterestStrategy accountInterestStrategy, CreditCardType creditCardType) {
        super(accountNumber, customer, balance, accountType, accountInterestStrategy);
        this.creditCardType = creditCardType;
    }

    //TODO
}
