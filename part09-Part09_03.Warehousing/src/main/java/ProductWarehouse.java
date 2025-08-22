public class ProductWarehouse extends Warehouse {

    private String productName;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = productName;

    }

    public String getName() {

        return this.productName;
    }

    public void setName(String newName) {

        this.productName = newName;
    }

    @Override
    public String toString() {

        // return String.format("Juice: balance = %.1f, sapce left %f", this.getBalance(), this.howMuchSpaceLeft());
           return this.productName + ": " + super.toString();
    }
}
