
import java.util.ArrayList;
import java.util.List;

public class Hideout<T> {

   private T hidden;

    public Hideout(){

        this.hidden = null;
    }



    public void putIntoHideout(T toHide){


        this.hidden = toHide;

    }

    public T takeFromHideout(){

        T toTake = this.hidden;

        this.hidden = null;

        return toTake;


    }

    public boolean isInHideout(){

       return this.hidden != null;

    }

}
