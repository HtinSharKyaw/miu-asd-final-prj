package banking.application.banking.services;

import banking.application.framework.models.Account;
import banking.application.framework.models.Customer;
import banking.application.framework.services.AccountService;

import java.util.Collection;

public class BankingServiceImpl implements AccountService {
    @Override
    public Account saveAccount(Account account, Customer customer) {
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
