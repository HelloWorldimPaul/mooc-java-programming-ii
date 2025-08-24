public class Book implements Comparable<Book> {

    String name;
    int ageRecommendation;

    public Book(String name, int ageRecommendation) {

        this.name = name;
        this.ageRecommendation = ageRecommendation;

    }

    public int getAgeRecommendation() {
        return this.ageRecommendation;
    }

    public String getName() {

        return this.name;
    }

    @Override
    public String toString() {

        return this.name + " (recommended for " + this.ageRecommendation + " year-olds or older)";

    }

    @Override
    public int compareTo(Book other) {

        if (this.ageRecommendation == other.ageRecommendation) {
            return this.name.compareTo(other.name);
        }

        return this.ageRecommendation - other.ageRecommendation;
    }

}

