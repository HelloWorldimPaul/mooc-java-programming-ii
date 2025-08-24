import javax.annotation.processing.SupportedOptions;

public class LiteracyRate {

    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;


    public LiteracyRate(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {

        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;

    }

    public double getLiteracyPercent() {

        return this.literacyPercent;

    }

    @Override
    public String toString() {

        return this.country + " (" + this.year + "), " + this.gender + ", " + this.literacyPercent;

    }
}
