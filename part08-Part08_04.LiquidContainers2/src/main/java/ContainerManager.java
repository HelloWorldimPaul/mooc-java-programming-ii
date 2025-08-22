
public class ContainerManager {

    private final Container first;
    private final Container second;

    public ContainerManager(Container first, Container second) {


        this.first = first;
        this.second = second;

    }


    public void addLiquid(int amount) {

        this.first.add(amount);

    }

    public void moveLiquid(int amount) {

        int availableAmount = this.first.contains();
        int toMove = Math.min(amount, availableAmount);

        this.first.remove(toMove);
        this.second.add(toMove);

    }

    public void removeLiquid(int amount) {

        this.second.remove(amount);


    }


}
