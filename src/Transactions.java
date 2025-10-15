/* Creating the Transactions object; for every transaction,
there will be these 5 pieces of information. */

public class Transactions {

private String date;
private String time;
private String description;
private String vendor;
private double amount; // 'double' used for $

// ----- CONSTRUCTOR ----- //

    /* 'this' refers to structure. It stores the value passed (the items in the parenthesis)
    inside this object's variable. Think: giving Java reference and instructions. */

    public Transactions(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

// ----- GETTERS AND SETTERS ----- //

    /* Exactly as the name implies: data access outside this class.
    Think: I will fetch this information and return it to you! */

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getVendor() {
        return vendor;
    }

    public double getAmount() {
        return amount;
    }

// ----- toString() METHOD ----- //

    /* For 'sout' (System.out.println) control. Otherwise, the Transactions object
    will print "ugly" data: 'Transaction@6d06d69c'. The compiler generates memory
    information - where the object is stored. We need neat, pretty console display! */

    @Override
    public String toString() {
        return date + " | " + time + " | " + description + " | " + vendor + " | " + amount;
    }

}
