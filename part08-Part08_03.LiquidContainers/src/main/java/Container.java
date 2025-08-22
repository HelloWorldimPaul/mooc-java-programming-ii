public class Container {

    private int amount;

    public Container(){

        this.amount = 0;

    }

    public int getAmount(){

        return this.amount;
    }

    public void removeAmount(int amount){

        int toRemove = Math.min(amount, this.amount);
        this.amount -= toRemove;

    }

    public void addAmount(int amount){


        this.amount += amount;
        if(this.amount > 100){
            this.amount = 100;
        }
    }

    public  void setAmount(int amount){

        this.amount = amount;
    }





}
