package banking.application.framework.services;

import banking.application.framework.dataaccess.AccountDAO;
import banking.application.framework.dataaccess.AccountDAOHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.AccountEntry;
import banking.application.framework.models.Customer;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AccountServiceImpl implements AccountService {
    private static AccountService accountService = null;
    AccountDAO accountDAO;
//    Account account;

    private AccountServiceImpl() {
        this.accountDAO = new AccountDAOHandler();
    }

    @Override
    public void createAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    @Override
    public void createCustomer(Customer customer) {

    }

    @Override
    public void deposit(String accountNumber, double amount, String description) {

        Account account = getAccountById(accountNumber);
        if (null == account) {
            System.out.println("Unsupported account");
        } else {
            account.depositMoney(amount);
            accountDAO.saveAccount(account);
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = getAccountById(accountNumber);
        if (null == account) {
            System.out.println("Unsupported account");
        } else {
            account.withdrawMoney(amount);
            accountDAO.saveAccount(account);
        }
    }

    @Override
    public Collection<Account> getAllAccounts() {
        HashMap<String, Account> accounts = accountDAO.retrieveAccounts();
        return accounts.values();
    }

    @Override
    public Account getAccountById(String accountNumber) {
        HashMap<String, Account> accountList = accountDAO.retrieveAccounts();
        Account account;
        if (accountList.containsKey(accountNumber)) {
            account = accountList.get(accountNumber);
            return account;
        } else {
            throw new UnsupportedOperationException("No such account");
        }

    }


    public void addInterest(String accountNumber) {
        Collection<Account> accounts = getAllAccounts();
        accounts.forEach(Account::addInterest);
    }


    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public static AccountService getInstance() {

        if (accountService == null)
            accountService = new AccountServiceImpl();

        return accountService;
    }

    @Override
    public String generateReportForBankingAndSavingAccounts(String accountNumber) {
        StringBuilder result = new StringBuilder();
        List<AccountEntry> list = new ArrayList<>();
        Account account = getAccountById(accountNumber);
        list = account.getListOfAccountEntries();
        for (AccountEntry e : list) {
            result.append(e.toString()).append(" \n");
        }
        System.out.println(result);
        return result.toString();
    }

    @Override
    public String generateMonthlyBillingReportsForCreditCard(String accountNumber) {
        String result = "";
        List<AccountEntry> accountEntryList = new ArrayList<>();
        //get the particular account
        Account account = getAccountById(accountNumber);
        //get
        accountEntryList = account.getListOfAccountEntries();
        //getting the last month total balance from the account entry

        double previousBalance, allChargesForThisMonth, allPaymentForThisMonth, newBalance, totalDue;

        //balance for previous month
        previousBalance = accountEntryList.stream()
                .filter(e -> ((int) LocalDate.now().getMonthValue() - (int) e.getDate().getMonthValue()) == 1)
                .mapToDouble(AccountEntry::getAmount)
                .sum();
        //total charges
        allChargesForThisMonth = accountEntryList.stream()
                .filter(e -> LocalDate.now().getMonth().equals(e.getDate().getMonth()))
                .filter(v -> v.getDescription().contains("charge"))
                .mapToDouble(AccountEntry::getAmount)
                .sum();
        //total credits
        allPaymentForThisMonth = accountEntryList.stream()
                .filter(e -> LocalDate.now().getMonth().equals(e.getDate().getMonth()))
                .filter(v -> v.getDescription().contains("payment"))
                .mapToDouble(AccountEntry::getAmount)
                .sum();
        //newBalance = previousBalance - allChargesForThisMonth + allChargesForThisMonth + account.getAccountInterestStrategy()
        return null;
    }


    @Override
    public List<Account> getAllAccountsBasedOnTheSpecificCustomer(String customerName) {
        //get all the accounts from the dao
        HashMap<String, Account> accounts = accountDAO.retrieveAccounts();
        Collection<Account> accountList = accounts.values();
        //return all accounts based on the specific customerName
        return accountList.stream()
                .filter(value -> value.getCustomer().getName().equals(customerName))
                .collect(Collectors.toList());
    }

    public String[] getAccountDetails(Account account) {
        String code = account.getAccountNumber();
        String[] result = new String[6];
        result[0] = account.getCustomer().getName();
        result[1] = account.getAccountNumber();
        result[2] = account.getAccountType().toString();
        result[3] = account.getAccountType().toString();
        result[4] = String.valueOf(account.getBalance());
        result[5] = account.getCustomer().getAddress().getCity();
        System.out.println(account.getAccountNumber());
        return result;
    }


}
