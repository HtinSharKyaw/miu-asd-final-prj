package banking.application.banking.bankingdao;

import java.util.HashMap;

import banking.application.framework.dataaccess.AccountDAOHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class BankingDAOImpl{
	AccountDAOHandler data = new AccountDAOHandler();
	
	HashMap<String,Account> retrieveBankingAccounts(){
		return data.retrieveAccounts();
	};
	HashMap<String,Customer> retrieveBankingCustomers(){
		return data.retrieveCustomers();
	}
	void saveBankAccount(Account account) {
		data.saveAccount(account);
	}
	void saveBankCustomer(Customer customer) {
		data.saveCustomer(customer);
	}
	
}
