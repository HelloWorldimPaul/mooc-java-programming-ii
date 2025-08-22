
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, Item> items;

    public ShoppingCart() {

        this.items = new HashMap<>();
    }

    public void add(String product, int price) {

        this.items.putIfAbsent(product, new Item(product, 0, price));
        this.items.get(product).increaseQuantity();

    }

    public int price() {

        int totalPrice = 0;

        for(String key : this.items.keySet()){

           totalPrice += this.items.get(key).price();

        }

        return totalPrice;

    }


    public void print() {

        for(Item item : this.items.values()){

            System.out.println(item);
        }

    }


}
