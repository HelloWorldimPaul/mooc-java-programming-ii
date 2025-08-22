public class TripleTacoBox implements TacoBox {


    int tacos;

    public TripleTacoBox(){

    this.tacos = 3;

    }



    public void eat(){

        if(this.tacos > 0){

            this.tacos--;
        }

    }

    public int tacosRemaining(){


        return this.tacos;
    }
}



