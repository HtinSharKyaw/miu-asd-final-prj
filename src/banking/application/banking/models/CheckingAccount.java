package banking.application.banking.models;

import banking.application.banking.strategy.CheckingInterestStrategy;
import banking.application.framework.enums.AccountType;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class CheckingAccount extends Account {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4427169990573627458L;

	public CheckingAccount(String accountNumber, Customer customer, Double balance, AccountType accountType) {
        super(accountNumber, customer, balance, accountType);
        accountInterestStrategy = new CheckingInterestStrategy();
    }
}
