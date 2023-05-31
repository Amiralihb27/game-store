package ir.ac.kntu;

import java.util.ArrayList;

public class Games extends GameStuff {


    private Level level = Level.LEVEL_1;

    private Version version;

    private String genre;

    private double rating;

    private int numberOfRates;


    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
        if (this.numberOfRates == 0) {
            numberOfRates++;
        }
    }

    public Games(String name, String story, String genre) {

        super.setName(name);
        super.setExplenation(story);
        this.genre = genre;
        this.version=Version.ORIGINAL;

    }

    public Games(String name, String story, String genre, Level level) {

        super.setName(name);
        super.setExplenation(story);
        this.genre = genre;
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }


    public void rate(double score) {
        //TODO
        setNumberOfRates(getNumberOfRates() + 1);
        this.rating = (this.getRating() * (getNumberOfRates() - 1) + score) / this.getNumberOfRates();

    }

    @Override
    public String toString() {
        return "Games{" + super.toString() +
                "level=" + level +
                ", version=" + version +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", numberOfRates=" + numberOfRates +
                '}';
    }
}
