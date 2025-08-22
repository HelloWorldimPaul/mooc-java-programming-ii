import java.util.Objects;

public class Item {

    private final String product;
    private int qty;
    private final int unitPrice;


    public Item(String product, int qty, int unitPrice) {

        this.product = product;
        this.qty = qty;
        this.unitPrice = unitPrice;


    }

    public int price() {


        return this.unitPrice * this.qty;
    }

    public void increaseQuantity() {

        this.qty++;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == this) {

            return true;
        }

        if (obj == null) {

            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;


        }
        Item comparedItem = (Item) obj;

        return this.product.equals(comparedItem.product) && this.unitPrice == comparedItem.unitPrice;

    }

    @Override
    public int hashCode() {

        int hash = 9;

        hash = 31 * hash + Objects.hashCode(this.product);
        hash = 33 * hash + this.unitPrice;

        return hash;

    }


    @Override
    public String toString() {

        return this.product + ": " + this.qty;

    }


}
