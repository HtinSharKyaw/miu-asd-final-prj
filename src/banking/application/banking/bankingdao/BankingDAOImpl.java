package banking.application.banking.bankingdao;

import banking.application.framework.dataaccess.AccountDAO;
import banking.application.framework.dataaccess.AccountDAOHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

import java.util.HashMap;

public class BankingDAOImpl {

    AccountDAO data = new AccountDAOHandler();

    HashMap<String,Account> retrieveBankingAccounts(){
        return data.retrieveAccounts();
    };
    HashMap<String, Customer> retrieveBankingCustomers(){
        return data.retrieveCustomers();
    }
    void saveBankingAccount(Account account) {
        data.saveAccount(account);
    }
    void saveBankingCustomer(Customer customer) {
        data.saveCustomer(customer);
    }

}
