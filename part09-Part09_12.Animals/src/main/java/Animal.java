public abstract class Animal {

    String name;

    public Animal(String name){

        this.name = name;
    }



    public void sleep() {

        System.out.println(getName() + " sleeps");

    }

    public  void eat(){

        System.out.println(getName() + " eats");
    }

    public String getName(){

        return this.name;

    }


}
