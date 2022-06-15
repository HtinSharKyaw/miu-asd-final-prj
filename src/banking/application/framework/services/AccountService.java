package banking.application.framework.services;

import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;

import java.util.Collection;

public interface AccountService {
    Account createAccount(Account account, Customer customer);
    void deposit(String accountNumber,double amount, String description);
    void withdraw(String accountNumber,double amount );
    Collection<Account> getAllAccounts();
    Account getAccountById(String accountNumber);
    void setInterest();
    void generateReports();
}
