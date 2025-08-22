
public class ContainerManager {

    private final Container first;
    private final Container second;

    public ContainerManager(Container first, Container second) {


        this.first = first;
        this.second = second;

    }


    public void addLiquid(int amount) {

        this.first.addAmount(amount);

    }

    public void moveLiquid(int amount) {

        int availableAmount = this.first.getAmount();
        int toMove = Math.min(amount, availableAmount);

        this.first.removeAmount(toMove);
        this.second.addAmount(toMove);

    }

    public void removeLiquid(int amount) {

        this.second.removeAmount(amount);


    }


}
