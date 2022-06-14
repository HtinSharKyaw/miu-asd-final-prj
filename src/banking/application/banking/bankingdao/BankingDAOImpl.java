package banking.application.banking.bankingdao;

import java.util.HashMap;

import banking.application.framework.dao.AccountDAO;
import banking.application.framework.dataaccess.DataAccessHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class BankingDAOImpl implements AccountDAO {
	DataAccessHandler data = new DataAccessHandler();
	
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
