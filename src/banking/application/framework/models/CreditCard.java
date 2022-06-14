package banking.application.framework.models;

import banking.application.framework.enums.AccountType;
import banking.application.framework.enums.CreditCardType;

public class CreditCard extends Account {

    private Double minimumPaymentAmount;
    private CreditCardType creditCardType;

    public CreditCard(String accountNumber, Customer customer, Double balance,
                      AccountType accountType, AccountInterestStrategy accountInterestStrategy,CreditCardType creditCardType) {
        super(accountNumber, customer, balance, accountType, accountInterestStrategy);
        this.creditCardType = creditCardType;
    }

    //TODO
}
