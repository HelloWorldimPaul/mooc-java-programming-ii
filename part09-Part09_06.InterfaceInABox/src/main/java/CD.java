public class CD implements Packable{

    private String artis;
    private String name;
    private int publicationYear;
    private double weight;

    public CD(String artist,String name, int publicationYear){

        this.artis = artist;
        this.name = name;
        this.publicationYear = publicationYear;
        this.weight = 0.1;

    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString(){

        return this.artis + ": " + this.name + " (" + this.publicationYear + ")";

    }
}
