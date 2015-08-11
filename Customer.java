package hw5;


/**
 * Customer.java
 * @author Ashish Bindra (abindra@uw.edu)
 * Oct 1, 2011
 */

/**
 * Represents a Bank Customer. A customer is identified by an integer ID that is
 * unique across all instances.
 * 
 * @author Ashish Bindra (abindra@uw.edu)
 * 
 */
public class Customer {

    /**
     * Unique customer id.
     */
    private final int id;

    /**
     * Customer name;
     */
    private final String name;

    /**
     * Constructor.
     * 
     * @param theID
     *            The ID of the customer.
     * @param theName
     *            The name of the customer.
     */
    public Customer(final int theID, final String theName) {
        id = theID;
        name = theName;
    }



    /**
     * @return the ID
     */
    public final int getID() {
        return id;
    }

    /**
     * @return the Name
     */
    public final String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + "]";
    }

    /*
     * Since id is unique we simply use that as our hash code. (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /*
     * Two BankAccount objects are equal if and only if they have the same id.
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Customer) {
            Customer theOtherCustomer = (Customer) other;
            if (this.id == theOtherCustomer.id) {
                result = true;
            }
        }
        return result;
    }

}
