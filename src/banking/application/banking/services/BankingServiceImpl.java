package banking.application.banking.services;

import banking.application.framework.dataaccess.AccountDAO;
import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;
import banking.application.framework.services.AccountService;

import java.util.Collection;

public class BankingServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public BankingServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account createAccount(Account account, Customer customer) {
        //accountService.saveAccount(account,customer);
        accountDAO.saveAccount(account);
        accountDAO.saveCustomer(customer);
        return null;
    }

    @Override
    public void deposit(String accountNumber, double amount, String description) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    public Account getAccountById(String accountNumber) {
        return null;
    }

    @Override
    public void setInterest() {

    }

    @Override
    public void generateReports() {

    }
}
