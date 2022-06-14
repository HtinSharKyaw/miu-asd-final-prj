package banking.application.creditcard.creditcarddao;

import java.util.HashMap;

import banking.application.framework.dao.AccountDAO;
import banking.application.framework.dataaccess.DataAccessHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

public class CreditCardDAOImpl implements AccountDAO {
	DataAccessHandler data = new DataAccessHandler();
	
	HashMap<String,Account> retrieveCreditCardAccounts(){
		return data.retrieveAccounts();
	};
	HashMap<String,Customer> retrieveCreditCardCustomers(){
		return data.retrieveCustomers();
	}
	void saveCreditCardAccount(Account account) {
		data.saveAccount(account);
	}
	void saveCreditCardCustomer(Customer customer) {
		data.saveCustomer(customer);
	}
}
