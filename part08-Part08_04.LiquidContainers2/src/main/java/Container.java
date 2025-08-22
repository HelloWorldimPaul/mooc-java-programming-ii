public class Container {

    private int amount;

    public Container(){

        this.amount = 0;

    }

    public int contains(){

        return this.amount;
    }

    public void remove(int amount){

        int toRemove = Math.min(amount, this.amount);
        this.amount -= toRemove;

    }

    public void add(int amount){
        if (amount < 0) {
            return;
        }

        this.amount += amount;
        if(this.amount > 100){
            this.amount = 100;
        }
    }

    public  void setAmount(int amount){

        this.amount = amount;
    }

    @Override
    public String toString(){

        return this.amount + "/100";
    }
}
