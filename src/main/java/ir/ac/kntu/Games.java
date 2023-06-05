package ir.ac.kntu;

import java.util.ArrayList;

public class Games extends GameStuff {


    private Level level = Level.LEVEL_1;

    private int score;

    private Version version;

    private String genre;

    private double rating;

    private int numberOfRates;

    private ArrayList<String> feedBack=new ArrayList<>();


    public void setScore(int base){

        switch (this.getLevel()) {
            case LEVEL_1 -> this.score = 0;
            case LEVEL_2 -> this.score = base;
            case LEVEL_3 -> this.score = base + base + 10;
            case LEVEL_4 -> this.score = base + base + 20;
            default -> this.score = base;
        }
    }

    public void setScore(){
        switch (this.getLevel()) {
            case LEVEL_1 -> this.score = 0;
            case LEVEL_2 -> this.score = 20;
            case LEVEL_3 -> this.score = 50;
            case LEVEL_4 -> this.score = 100;
            default -> this.score = 20;
        }
    }

    public int getScore() {
        return score;
    }

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

    public ArrayList<String> getFeedBack() {
        return feedBack;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void  setLevelPerNumber(int number){
        if(number<1){
            this.level=Level.LEVEL_1;
        } else if (number>4) {
            this.level=Level.LEVEL_4;
        }else{
            this.level=Level.values()[number-1];
        }
    }

    public void setVersionByNumber(int number){
        if(number<1){
            this.version=Version.BETA;
        } else if (number>2) {
            this.version= Version.ORIGINAL;
        }else{
            this.version=Version.values()[number-1];
        }
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

    public void addFeedBack(String feedBack){
        if(this.version.equals(Version.BETA)){
            this.feedBack.add(feedBack);
        }
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
