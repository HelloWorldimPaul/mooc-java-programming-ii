

import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning 
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

    @Override
    public boolean equals(Object obj){

        if(this == obj){

            return true;
        }

        if(obj == null){

            return false;
        }

        if(!(obj instanceof LicensePlate)){

            return false;
        }

        LicensePlate compareObj = (LicensePlate) obj;

        if((Objects.equals(this.liNumber, compareObj.liNumber)) && (this.country.equals(compareObj.country))){

            return true;

        }else{

            return false;
        }

    }

    @Override
    public int hashCode(){

        int hash = 5;

        hash = 31 * hash + this.liNumber.hashCode();
        hash = 31 * hash +  this.country.hashCode();

        return hash;

    }

}
