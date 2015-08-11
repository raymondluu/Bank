package hw5;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Bank {
    private Set<Customer> customers = new HashSet<Customer>();;
    private Set<BankAccount> accounts = new HashSet<BankAccount>();
    
    //Adds the customer if not already present and returns true. 
    //If the customer is already present it returns false without adding it.
    public boolean addCustomer(final Customer customer) {
        Boolean valid = false;
        if(!customers.contains(customer)) {
            customers.add(customer);
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }
    //Adds an account if not already present and returns true. 
    //If the account is already present it returns false without adding it. 
    //If the Customer who is the owner of the account is not already known to the Bank then a IllegalArgumentException must be thrown.
    public boolean addAccount(final BankAccount anAccount) {
        Boolean valid = false;
        if(!accounts.contains(anAccount)) {
            accounts.add(anAccount);
            valid = true;
        } else {
            valid = false;
        }
        return valid;
    }
    //Returns a set of bank accounts, from all the bank accounts, 
    //such that their balance is greater than or equal to minBalance and less than or equal to maxBalance. 
    //If no matching results are found, return an empty set and not a null set. [Note the usage of BigDecimal.]
    //A null value in minimum balance signals a –infinity value, while a null value in maximum balance signals a +infinity value. 
    //So the call getAccount(null, null) should return all the accounts.
    public Set<BankAccount> getAccounts(final BigDecimal minBalance, final BigDecimal maxBalance) {
        Set<BankAccount> accSet = new HashSet<BankAccount>();
        for(BankAccount account : accounts) {
            if(account.getBalance().compareTo(minBalance) >= 0 && account.getBalance().compareTo(maxBalance) <= 0) {
                accSet.add(account);
            } else if(minBalance == null && account.getBalance().compareTo(maxBalance) <= 0) {
                accSet.add(account);
            } else if(maxBalance == null&& account.getBalance().compareTo(minBalance) >= 0) {
                accSet.add(account);
            } else {
                return accounts;
            }
        }
        return accSet;
    }
    //Returns a set of Customers, from all customers, 
    //such that their total balance across all their accounts is greater than or equal to minBalance and less than or equal to maxBalance. 
    //If no matching results are found, return an empty set and not a null set. [Note the usage of BigDecimal.] 
    //A null value in minimum balance signals a –infinity value, while a null value in maximum balance signals a +infinity value. 
    //So the call getCustomers (null, null) should return all the customers.
    public Set<Customer> getCustomers(final BigDecimal minBalance, final BigDecimal maxBalance) {
        Set<Customer> cusSet = new HashSet<Customer>();

        for(Customer person : customers) {
            Set<BankAccount> cusTotalAccSet = new HashSet<BankAccount>();
            BigDecimal totalBalance = new BigDecimal(0);

            for(BankAccount acc : accounts) {
                if(acc.getOwner().equals(person)) {
                    cusTotalAccSet.add(acc);
                }
            }
            
            for(BankAccount i :  cusTotalAccSet ){
                totalBalance.add(i.getBalance());       
            }
            
            if(totalBalance.compareTo(minBalance) >= 0 && totalBalance.compareTo(maxBalance) <= 0) {
                cusSet.add(person);
            } else if(minBalance == null && totalBalance.compareTo(maxBalance) <= 0) {
                cusSet.add(person);
            } else if(maxBalance == null&& totalBalance.compareTo(minBalance) >= 0) {
                cusSet.add(person);
            }
           
        }
        
        return cusSet;
    }
    //The customer that matched theID or null if none matches.
    public Customer getCustomer(final int aCustomerID) {
        for(Customer person : customers) {
            if(person.getID() == aCustomerID) {
                return person;
            }
        }
        return null;
    }
    //Returns a set of all the accounts owned by the customer. 
    //If aCustomer is null, throw an IllegalArgumentException. 
    //If the customer is not found or no accounts are found, return an empty set, not a null value.
    public Set<BankAccount> getCustomerAccounts(final Customer aCustomer) {
        Set<BankAccount> matchingAccounts = new HashSet<BankAccount>();
        for(BankAccount account : accounts) {
            if(account.getId() == aCustomer.getID()) {
                matchingAccounts.add(account);
            }
        }
        return matchingAccounts;
    }
    //Returns a set of all the accounts owned by the customer. 
    //If the customer is not found or no accounts are found, return an empty set not a null value.
    public Set<BankAccount> getCustomerAccounts(final int aCustomerID) {
        Set<BankAccount> matchingAccounts = new HashSet<BankAccount>();
        for(BankAccount account : accounts) {
            if(account.getId() == aCustomerID) {
                matchingAccounts.add(account);
            }
        }
        return matchingAccounts;
    }
    //Return the bank account with id = anAccountID if found, else return null.
    public BankAccount getAccount(final int anAccountID) {
        for(BankAccount account : accounts) {
            if(account.getId() == anAccountID) {
                return account;
            }
        }
        return null;
    }
}