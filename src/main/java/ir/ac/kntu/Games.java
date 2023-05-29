package ir.ac.kntu;

import java.util.ArrayList;

public class Games {
    private String name;

    private Level level=Level.LEVEL_1;

    private String story;

    private String genre;

    private ArrayList<String> reviews = new ArrayList<>();

    private double rating;

    private double price;

    private int numberOfRates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
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

        this.name = name;
        this.story = story;
        this.genre = genre;

    }

    public Games(String name, String story, String genre, Level level) {

        this.name = name;
        this.story = story;
        this.genre = genre;
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfRates() {
        return numberOfRates;
    }

    public void setNumberOfRates(int numberOfRates) {
        this.numberOfRates = numberOfRates;
    }

    public void addReview(String review) {
        this.reviews.add(review);
    }

    public void rate(double score) {
        //TODO
        setNumberOfRates(getNumberOfRates() + 1);
        this.rating = (this.getRating() * (getNumberOfRates() - 1) + score) / this.getNumberOfRates();

    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", story='" + story + '\'' +
                ", price='" + price + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", reviews=" + reviews +
                ", numberOfRates=" + numberOfRates +
                '}';

    }
}
