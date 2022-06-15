package banking.application.banking.models;

import banking.application.banking.strategy.SavingInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class SavingAccount extends Account {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2193623630809619207L;

	public SavingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType) {
        super(accountNumber, customer, balance, accountType);
        accountInterestStrategy = new SavingInterestStrategy();
    }
}
