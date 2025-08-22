import java.util.*;

public class Warehouse {


    private Map<String, Integer> productsPrice;
    private Map<String, Integer> productsStocks;
    //private String product;
    //private int price;
    //private int stock;

    public Warehouse() {

        this.productsPrice = new HashMap<>();
        this.productsStocks = new HashMap<>();

    }


    public void addProduct(String product, int price, int stock) {

        this.productsPrice.put(product, price);
        this.productsStocks.put(product, stock);

    }

    public int price(String product) {

        return productsPrice.getOrDefault(product, -99);

    }

    public int stock(String product) {

        return this.productsStocks.getOrDefault(product, 0);


    }

    public boolean take(String product) {

        if(!this.productsStocks.containsKey(product)){

            return false;
        }

        int stock = this.productsStocks.get(product);

        if(stock > 0){

            stock--;
            this.productsStocks.put(product, stock);
            return true;
        }else{
            return false;
        }


    }

    public Set<String> products(){

        return  this.productsPrice.keySet();

    }
}
