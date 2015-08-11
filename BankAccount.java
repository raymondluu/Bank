package hw5;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * This class represents a basic bank account.
 * 
 * invariant: the account interest rate is >= 0 invariant: the account balance
 * is >= 0
 * 
 * [It is based on code by Alan Fowler (acfowler@u.washington.edu)]
 * 
 * @author Ashish Bindra (abindra@uw.edu)
 * 
 * @version Fall 2011
 */
public class BankAccount {

    /**
     * A NumberFormat instance to use for formatted output.
     */
    private static final NumberFormat NF = NumberFormat.getCurrencyInstance();

    /**
     * The customer who owns this account.
     */
    private final Customer owner;

    /**
     * The interest rate for this account.
     */
    private double interestRate;

    /**
     * The account balance.
     */
    private BigDecimal balance;

    /**
     * The unique identifier for the account. No two accounts will have the same
     * id.
     */
    private final int id;

    /**
     * Initializes the fields of this object to the specified values. If the
     * specified interest rate is < 0 then the interest rate will be set to
     * zero. Other fields of this object are initialized to zero.
     * 
     * @param id
     *            the unique identifier for the account
     * @param nameOfOwner
     *            the name of the owner of this account
     * @param interestRate
     *            the interest rate for this account
     */
    public BankAccount(final int id, final Customer customer,
            final double interestRate) {
        this.id = id;
        owner = customer;
        this.interestRate = Math.max(0, interestRate);
        balance = new BigDecimal(0);
    }

    /**
     * @return the owner
     */
    public Customer getOwner() {
        return owner;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * Returns the interest rate for this BankAccount.
     * 
     * @return the annual interest rate
     */
    public final double getInterestRate() {
        return interestRate;
    }

    /**
     * Set the new interest rate;
     * 
     * @param interestRate
     */
    public void setInterestRate(final double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        }
    }

    /**
     * Returns the balance of this account.
     * 
     * @return the balance of this account.
     */
    public final BigDecimal getBalance() {
        return balance;
    }

    /**
     * Adds the specified amount of money to the calling BankAccount object.
     * However, if the amount of money is zero or negative, the deposit fails
     * (it's not possible to effectively withdraw money by depositing a negative
     * amount), the account balance is unchanged, and the method returns false.
     * Otherwise, if the amount of money is positive, the deposit succeeds and
     * the method returns true.
     * 
     * @param amount
     *            the amount to deposit to this account
     * @return true if amount > 0; false otherwise
     */
    public boolean processDeposit(final BigDecimal amount) {
        boolean success = false;

        if (amount.doubleValue() > 0) {
            balance = balance.add(amount);
            success = true;
        }

        return success;
    }

    /**
     * Subtracts the specified amount of money from the calling BankAccount
     * object. However, if the amount of money is negative or more than the
     * current balance of the account, the withdraw fails, the account balance
     * is unchanged, and the method returns false. Otherwise, the withdrawal
     * succeeds, the record of successful withdrawals made in the current month
     * is incremented, and the method returns true.
     * 
     * @param amount
     *            the amount to withdraw from this account
     * @return true if (amount > 0 && amount <= balance); false otherwise.
     */
    public boolean processWithdrawal(final BigDecimal amount) {
        boolean success = false;

        if (amount.doubleValue() > 0
                && amount.doubleValue() <= balance.doubleValue()) {
            balance = balance.subtract(amount);
            success = true;
        }

        return success;
    }

    /**
     * Calculates the earned interest on the balance of the calling BankAccount
     * object.
     * 
     * @return the interest on this account for one month
     */
    public final BigDecimal calculateInterest() {
        return balance.multiply(new BigDecimal(interestRate / 12));
    }

    /**
     * Deducts any services charges accrued during the current month, calls the
     * calculateInterest method and adds the interest, and resets the the number
     * of withdrawals and service charge amount to 0 for the calling BankAccount
     * object. This method will not reduce the balance to a number less than
     * zero.
     */
    public void performMonthlyProcess() {
        balance = balance.add(calculateInterest());
    }

    


    /**
     * Returns a String representation of this BankAccount object.
     * 
     * @return a String representation of this BankAccount object
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[owner: ");
        sb.append(owner);
        sb.append(", balance: ");
        sb.append(NF.format(balance));
        sb.append(", interest rate: ");
        sb.append(String.format("%.2f%s", interestRate * 100, "%"));
        sb.append("]");
        return sb.toString();
    }

    /* 
     * Since id is unique we simply use that as our hash code.
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id;
    }

    /* 
     * Two BankAccount objects are equal if and only if
     * they have the same id.
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;     
        if(other instanceof BankAccount){
            BankAccount theOtherAccount = (BankAccount) other;
            if (this.id == theOtherAccount.id) {
                 result = true;
            }
        }           
        return result;
    }
    
    

} // end class BankAccount
