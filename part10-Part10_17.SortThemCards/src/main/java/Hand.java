import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> hands;

    public Hand() {

        this.hands = new ArrayList<>();
    }


    public void add(Card card) {
        this.hands.add(card);
    }

    public void print() {
        for (Card card : this.hands) {

            System.out.println(card);
        }
    }

    public void sort() {

        Collections.sort(this.hands);
    }

    @Override
    public int compareTo(Hand hands) {

        return this.getTotalValue() - hands.getTotalValue();

    }

    public int getTotalValue() {

        int totalValue = 0;

        for (Card card : this.hands) {

            totalValue += card.getValue();
        }
        return totalValue;
    }

    public void sortBySuit() {

        BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
        this.hands.sort(sortBySuitSorter);
    }

}
