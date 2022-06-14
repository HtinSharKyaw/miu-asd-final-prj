package banking.application.framework.models;

import banking.application.banking.strategy.AccountInterestStrategy;
import banking.application.framework.enums.AccountType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable{
    //That will be in account service
//    abstract void depositMoney();
//    abstract void withdrawMoney();

    /**
	 * 
	 */
	private static final long serialVersionUID = 7998092388498016664L;
	private String accountNumber;//modify name of the id
    private Customer customer;
    private AccountType accountType;
    private List<AccountEntry> listOfAccountEntries;
    private Double balance;
    private AccountInterestStrategy accountInterestStrategy;

    public Account(String accountNumber, Customer customer, Double balance, AccountType accountType, AccountInterestStrategy accountInterestStrategy) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = balance;
        this.accountType = accountType;
        this.accountInterestStrategy = accountInterestStrategy;
    }

    public void addAccountEntry(AccountEntry accountEntry) {
        if (null == accountEntry) {
            listOfAccountEntries = new ArrayList<>();
        }
        this.listOfAccountEntries.add(accountEntry);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public List<AccountEntry> getListOfAccountEntries() {
        return listOfAccountEntries;
    }

    public double depositMoney(Double moneyAdded){
        balance += moneyAdded;
        return balance;
    }

    public double withdrawMoney(Double withdrawMoney){
        if(withdrawMoney > balance) {
            return -1;
        }
        return balance - withdrawMoney;
    }

    public void getReports(){
        System.out.println();
    }

    public Double getBalance() {
        // return listOfAccountEntries.stream().mapToDouble(e -> e.getAmount()).sum();
        return balance;
    }

    public void addInterest(){
        //TODO some operations
        accountInterestStrategy.calculateInterest(balance);
    }
}
