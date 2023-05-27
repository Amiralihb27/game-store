package ir.ac.kntu;

import java.util.ArrayList;
//import java.util.Scanner;

public class Library {
    private ArrayList<Games> games = new ArrayList<>();

    public void setGames(ArrayList<Games> games) {
        this.games = games;
    }

    public ArrayList<Games> getGames() {
        return games;
    }

    public void library(Library library) {
        this.games = library.getGames();
    }

    public void addGame(Games games) {
        this.games.add(games);
    }

    public void showGames() {
        if (games.size() > 0) {
            listOfGames();
            gamesInformation();
        } else {
            System.out.println("You dont have any games in your library");
            System.out.println("**************************************************");

        }

    }

    public void listOfGames() {

        for (int i = 0; i < games.size(); i++) {
            System.out.println((i + 1) + ":" + this.games.get(i).getName());
        }
    }

    public void gamesInformation() {
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= games.size()) {
                System.out.println(games.get(input - 1).toString());
                System.out.println("***************************");
                community();
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }
    }

    public void community() {
        if (games.size() > 0) {
            listOfGames();
            while (true) {
                System.out.println("Enter the related number to see each game's review");
                System.out.println("or you can just skip this by entering -1'.");
                int input = ScannerWrapper.getInt();
                if (input >= 1 && input <= games.size()) {
                    if (games.get(input - 1).getReviews() == null) {
                        System.out.println("there is no review about this game!");
                    } else {
                        System.out.println(games.get(input - 1).getReviews());
                    }
                    addReview(games.get(input - 1));
                    break;
                } else if (input == -1) {
                    break;
                } else {
                    System.out.println("wrong input!please try again");
                }
            }
        } else {
            System.out.println("You dont have any games in your library");
            System.out.println("**************************************************");
        }
    }

    public void addReview(Games game) {
        System.out.println("would you like to add a review?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        int input = ScannerWrapper.getInt();
        // sc.nextLine();
        while (true) {
            if (input == 1) {
                String review = ScannerWrapper.getString();
                game.addReview(review);
                addRating(game);
                break;
            } else if (input == 2) {
                addRating(game);
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }

    public void addRating(Games game) {
        System.out.println("would you like to add a rating?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        int input = ScannerWrapper.getInt();
        while (true) {
            if (input == 1) {
                double score = ScannerWrapper.getDouble();
                game.rate(score);
                break;
            } else if (input == 2) {
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }

}
