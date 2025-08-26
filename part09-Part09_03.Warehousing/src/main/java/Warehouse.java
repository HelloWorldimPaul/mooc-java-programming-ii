

public class Warehouse {

    private final double capacity;
    private double balance;

    public Warehouse(double capacity) {

        this.capacity = Math.max(capacity, 0.0);
        this.balance = 0.0;
    }

    public double getBalance() {
        return this.balance;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double howMuchSpaceLeft() {
        return this.capacity - this.balance;
    }

    public void addToWarehouse(double amount) {
        if(amount < 0) return;
        this.balance = Math.min(this.balance + amount, this.capacity);
    }

    public double takeFromWarehouse(double amount) {

        if (amount < 0) return 0.0;

        return Math.max(this.balance - amount, this.capacity);


        /*
        if (amount > this.balance) {
            double allThatWeCan = this.balance;
            this.balance = 0.0;
            return allThatWeCan;
        }

        this.balance = this.balance - amount;
        return amount;

         */
    }

    public String toString() {

        return String.format("balance = %.1f, space left %.1f", getBalance(), howMuchSpaceLeft());
    }
}
