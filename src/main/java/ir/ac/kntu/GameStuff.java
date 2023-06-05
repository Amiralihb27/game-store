package ir.ac.kntu;

import java.util.ArrayList;

public class GameStuff {
    private String name;

    private double price;

    private ArrayList<String> reviews = new ArrayList<>();

    private String explenation;

    private int countOfSold = 0;

    public int getCountOfSold() {
        return this.countOfSold;
    }

    public String getExplenation() {
        return explenation;
    }

    public void setExplenation(String explenation) {
        this.explenation = explenation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public void addReview(String review) {
        this.reviews.add(review);
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", price=" + price +
                ", reviews=" + reviews +
                ", explenation='" + explenation + '\'' +
                '}';
    }

    public void community() {
        if (this.getClass().getSimpleName().equals("Games")) {
            GameStuff newStuff = this;
            Games games = (Games) newStuff;
            if (games.getVersion() == Version.BETA) {
                System.out.println("Beta games has no community!");
            }
        }
        if (this.getReviews() == null) {
            System.out.println("there is no review about this game!");
        } else {
            System.out.println(this.getReviews());
        }
    }

    public void addCountOfSold() {
        countOfSold++;
    }

    public void feedBack() {
        //send feed back;
    }
}
