package banking.application.framework.dataaccess;

import java.util.HashMap;

import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;


public interface DataAccess { 
	HashMap<String,Account> retrieveAccounts();
	HashMap<String,Customer> retrieveCustomers();
	void saveAccount(Account book);
	void saveCustomer(Customer customer);
}
