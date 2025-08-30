import java.util.ArrayList;
import java.util.List;

public class Pipe <T>{

    List<T> pipe;

    public Pipe(){

        this.pipe = new ArrayList<>();
    }




    public void putIntoPipe(T value){


        this.pipe.add(value);
    }

    public T takeFromPipe(){

        if(this.pipe.isEmpty()){
            return null;
        }

        T oldvalue = this.pipe.get(0);

        this.pipe.remove(0);


        return oldvalue;

    }

    public boolean isInPipe(){


        return !this.pipe.isEmpty();
    }


}
