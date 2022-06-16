package banking.application.framework.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import banking.application.framework.dataaccess.AccountDAO;
import banking.application.framework.dataaccess.AccountDAOHandler;
import banking.application.framework.models.Account;
import banking.application.framework.models.AccountEntry;

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



	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public static AccountService getInstance() {
		
		if (accountService == null)
			accountService = new AccountServiceImpl();
		
		return accountService;
	}
    @Override
    public String generateReport(String accountNumber) {
        String result="";
        List<AccountEntry> List = new ArrayList<>();
        Account account = getAccountById(accountNumber);
        List= account.getListOfAccountEntries();
        for(AccountEntry e: List){
            result+=(e.toString()+ " \n");
        }
        System.out.println(result);
        return result;
    }
    public String[] getAccountDetails(Account account)
    {
        String code= account.getAccountNumber();
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
