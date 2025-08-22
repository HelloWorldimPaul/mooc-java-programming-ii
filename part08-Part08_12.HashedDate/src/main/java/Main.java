
public class Main {

    public static void main(String[] args) {
        // make test programs here

        SimpleDate simpleDate1 = new SimpleDate(1, 1, 2000);
        SimpleDate simpleDate2 = new SimpleDate(2, 2, 2001);

        int hash1 = simpleDate1.hashCode();
        int hash2 = simpleDate2.hashCode();

        System.out.println(hash1);
        System.out.println(hash2);

    }
}
