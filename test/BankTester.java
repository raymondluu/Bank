package hw5.test;

import hw5.Bank;
import hw5.BankAccount;
import hw5.Customer;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


public class BankTester {
    private static Bank myBank = new Bank();
    
    private static Set<Customer> customerSet = new HashSet<Customer>();
    private static Set<BankAccount> accountSet = new HashSet<BankAccount>();
    
    private static Boolean valid = false;
    
    public static void main(String[] args) {
        Customer john = new Customer(1000, "John");
        BankAccount johnAcc = new BankAccount(1000, john, 0.1);
        customerSet.add(john);
        accountSet.add(johnAcc);
        
        Customer andy = new Customer(2000, "Andy");
        BankAccount andyAcc = new BankAccount(2000, andy, 0.1);
        customerSet.add(andy);
        accountSet.add(andyAcc);
        
        Customer ray = new Customer(3000, "Ray");
        BankAccount rayAcc = new BankAccount(3000, ray, 0.1);
        customerSet.add(ray);
        accountSet.add(rayAcc);
        
        Customer brendan = new Customer(4000, "Brenden");
        BankAccount brendanAcc = new BankAccount(4, brendan, 0.1);
        customerSet.add(brendan);
        accountSet.add(brendanAcc);
        
        Customer bob = new Customer(5000, "Bob");
        BankAccount bobAcc = new BankAccount(5, bob, 0.1);
        customerSet.add(bob);
        accountSet.add(bobAcc);
        
        if(test_addCustomer()) {
            System.out.println("test_addCustomer passed!");
        } else {
            System.out.println("test_addCustomer failed!");
        }
        
        if(test_addAccount()) {
            System.out.println("test_addAccount passed!");
        } else {
            System.out.println("test_addAccount failed!");
        }
        
        if(test_getCustomer()) {
            System.out.println("test_getCustomer passed!");
        } else {
            System.out.println("test_getCustomer failed!");
        }
        
        if(test1_getCustomerAccounts()) {
            System.out.println("test1_getCustomerAccounts passed!");
        } else {
            System.out.println("test1_getCustomerAccounts failed!");
        }
        
        if(test2_getCustomerAccounts()) {
            System.out.println("test2_getCustomerAccounts passed!");
        } else {
            System.out.println("test2_getCustomerAccounts failed!");
        }
        
        if(test_getAccount()) {
            System.out.println("test_getAccount passed!");
        } else {
            System.out.println("test_getAccount failed!");
        }
        
        if(test_getAccounts()) {
            System.out.println("test_getAccounts passed!");
        } else {
            System.out.println("test_getAccounts failed!");
        }
        
        if(test_getCustomers()) {
            System.out.println("test_getCustomers passed!");
        } else {
            System.out.println("test_getCustomers failed!");
        }
    }
    //tests the addCustomer code
    public static boolean test_addCustomer() {
        for(Customer person : customerSet) {
            if(myBank.addCustomer(person)) {
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    }
    //tests the addAccount code
    public static boolean test_addAccount() {
        for(BankAccount acc : accountSet) {
            if(myBank.addAccount(acc)) {
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    }
    //tests the getAccount code
    public static boolean test_getAccounts() {
        BigDecimal max = new BigDecimal(1);
        BigDecimal min = new BigDecimal(-1);
        Set<BankAccount> temp = myBank.getAccounts(min, max);
        if(temp == null) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
    //tests the getCustomers code
    public static boolean test_getCustomers() {
        BigDecimal max = new BigDecimal(1);
        BigDecimal min = new BigDecimal(-1);
        Set<Customer> temp = myBank.getCustomers(min, max);
        if(temp == null) {
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }
    //tests the getCustomer code
    public static boolean test_getCustomer() {
        for(Customer person : customerSet) {
            Customer temp = myBank.getCustomer(person.getID());
            if(temp == null) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
    //tests the getCustomerAccounts
    public static boolean test1_getCustomerAccounts() {
        for(Customer person : customerSet) {
            Set<BankAccount> temp = myBank.getCustomerAccounts(person);
            if(temp == null) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
    //tests the getCustomerAccounts
    public static boolean test2_getCustomerAccounts() {
        for(Customer person : customerSet) {
            Set<BankAccount> temp = myBank.getCustomerAccounts(person.getID());
            if(temp == null) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
    //tests the getAccount code
    public static boolean test_getAccount() {
        for(BankAccount acc : accountSet) {
            BankAccount temp = myBank.getAccount(acc.getId());
            if(temp == null) {
                valid = false;
            } else {
                valid = true;
            }
        }
        return valid;
    }
}