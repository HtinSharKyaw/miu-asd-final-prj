package banking.application.framework.models;

public class Individual extends Customer{

//    public Personal(String id, Customer customer, Double balance, AccountType accountType, AccountInterestStrategy accountInterestStrategy) {
//        super(id, customer, balance, accountType, accountInterestStrategy);
//    }

    public Individual(String name, String email, String address) {
        super(name, email, address);
    }
}
