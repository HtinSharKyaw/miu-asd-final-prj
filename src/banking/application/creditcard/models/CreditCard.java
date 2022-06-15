package banking.application.creditcard.models;

import banking.application.creditcard.strategy.CreditCardInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.enums.CreditCardType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class CreditCard extends Account {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5544177350265007172L;
	
	private Double minimumPaymentAmount;
    private CreditCardType creditCardType;

    public CreditCard(String accountNumber, Customer customer, Double balance,
                      AccountType accountType, CreditCardType creditCardType) {
        super(accountNumber, customer, balance, accountType);
        this.creditCardType = creditCardType;
        accountInterestStrategy = new CreditCardInterestStrategy();
    }

    //TODO
}
