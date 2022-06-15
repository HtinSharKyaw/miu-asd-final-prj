package banking.application.framework.services;

import java.util.Collection;
import java.util.HashMap;

import banking.application.framework.dataaccess.AccountDAO;
import banking.application.framework.dataaccess.AccountDAOHandler;
import banking.application.framework.models.Account;

public class AccountServiceImpl implements AccountService{
	private static AccountService accountService = null;
    AccountDAO accountDAO;


    private AccountServiceImpl() {
        this.accountDAO = new AccountDAOHandler();
    }

    @Override
    public void createAccount(Account account) {
        accountDAO.saveAccount(account);
    }

    @Override
    public void deposit(String accountNumber, double amount, String description) {

        Account account = getAccountById(accountNumber);
        if(null==account){
            System.out.println("Unsupported account");
        }else{
            account.depositMoney(amount);
            accountDAO.saveAccount(account);
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = getAccountById(accountNumber);
        if(null==account){
            System.out.println("Unsupported account");
        }else{
            account.withdrawMoney(amount);
            accountDAO.saveAccount(account);
        }
    }

    @Override
    public Collection<Account> getAllAccounts() {
        HashMap<String,Account> accounts = accountDAO.retrieveAccounts();
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

    public void addInterest(String accountNumber){
        Collection<Account> accounts=getAllAccounts();
        accounts.forEach(account -> account.addInterest());
    }

    public void generateReports(){

    }

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public static AccountService getInstance() {
		
		if (accountService == null)
			accountService = new AccountServiceImpl();
		
		return accountService;
	}
    
}
