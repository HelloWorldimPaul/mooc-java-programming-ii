public class CustomTacoBox implements TacoBox{

    int initialTacos;


    public CustomTacoBox(int initialTacos){

        this.initialTacos = initialTacos;

    }

    public void eat(){

        if(this.initialTacos > 0){

            this.initialTacos--;
        }

    }

    public int tacosRemaining(){


        return this.initialTacos;
    }

}
