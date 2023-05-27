package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class GameChanges {

    public static void showOptions(ArrayList<Games> games) {
        while (true) {
            System.out.println("Which part do you wana go?");
            System.out.println("1_Add games");
            System.out.println("2_Edit game");
            System.out.println("3_Delet game");
            System.out.println("4_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                addGame(games);
            } else if (input == 2) {
                change(games);
            } else if (input == 3) {
                deletGame(games);
            } else {
                break;
            }
        }

    }

    public static void change(ArrayList<Games> games) {
        //sc.nextLine();
        while (true) {

            System.out.println("You can get back to previos action by entering exit.");
            System.out.println("Enter the name of the Game:");
            String name = ScannerWrapper.getString();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            if (doesExist(games, name)!=-1) {
                System.out.println("which game do you wana choose?");
                ArrayList<String> uniqueNum = new ArrayList<>();
                for (int i = 0; i < games.size(); i++) {
                    if (games.get(i).getName().equals(name)) {
                        System.out.println((i + 1) + "_" + games.get(i).toString());
                        uniqueNum.add(Integer.toString(i + 1));
                    }

                }
                System.out.println("Enter the related number of the game.");
                toChange(games, uniqueNum);
                break;

            } else {
                System.out.println("Wrong input!Try again.");
            }

        }


    }

    public static int doesExist(ArrayList<Games> games, String name) {
        for (int i = 0; i < games.size(); i++) {
            if (name.equals(games.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static void toChange(ArrayList<Games> games, ArrayList<String> uniqueNum) {

        String input;
        while (true) {
            System.out.println("You can get back by entering exit.");
            input = ScannerWrapper.getString();
            if (isEqual(input, uniqueNum)) {
                edit(games.get(Integer.parseInt(input) - 1));
                break;
            } else if (input.equals("exit")) {
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }
        }
    }

    public static boolean isEqual(String input, ArrayList<String> uniqueNum) {
        for (int i = 0; i < uniqueNum.size(); i++) {
            if (input.equalsIgnoreCase(uniqueNum.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void edit(Games game) {
        while(true){
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter the new name of game:");
            String name = ScannerWrapper.getString();
            if(name.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Enter the story of game:");
            String story = ScannerWrapper.getString();
            System.out.println("Enter the genere of new game:");
            String genere = ScannerWrapper.getString();
            System.out.println("Enter the one review for new game:");
            String review = ScannerWrapper.getString();
            game.setNumberOfRates(0);
            System.out.println("Enter the  new rating of the  game:");
            double rating = ScannerWrapper.getDouble();
            System.out.println("Enter the new price of game:");
            double price = ScannerWrapper.getDouble();
            game.setPrice(price);
            game.setGenre(genere);
            game.setName(name);
            game.setStory(story);
            game.setRating(rating);
            ArrayList<String> reviews = new ArrayList<>();
            reviews.add(review);
            game.setReviews(reviews);
            System.out.println("The game edited succesfully!");
            break;
        }


    }

    public static void addGame(ArrayList<Games> games) {
        //sc.nextLine();
        while(true){
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter the  name of new game:");
            String name = ScannerWrapper.getString();
            if(name.equalsIgnoreCase("exit")){
                break;
            }
            System.out.println("Enter the story of game:");
            String story = ScannerWrapper.getString();
            System.out.println("Enter the genere of new game:");
            String genere = ScannerWrapper.getString();
            System.out.println("Enter the one review for new game:");
            String review = ScannerWrapper.getString();
            System.out.println("Enter the rating of the  game:");
            double rating = ScannerWrapper.getDouble();
            System.out.println("Enter the  price of game:");
            double price = ScannerWrapper.getDouble();
            Games game = new Games(name, story, genere);
            game.setPrice(price);
            game.setRating(rating);
            game.addReview(review);
            games.add(game);
            System.out.println(game + " succesfully added!");
            break;
        }

    }

    public static void deletGame(ArrayList<Games> games) {
        //sc.nextLine();
        while (true) {
            System.out.println("You can get back to previous action by entering exit.");
            System.out.println("Enter the games name:");
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            int repeats = 0;

            for (int i = 0; i < games.size(); i++) {
                if (input.equals(games.get(i).getName())) {
                    System.out.println((i + 1) + "_" + games.get(i).toString());
                    repeats++;

                }
            }
            if (repeats == 0) {
                System.out.println("There is no game with this name!");
            } else {
                System.out.println("Enter the related number:");
                int index = ScannerWrapper.getInt();
                toDelete(index, games);
                break;
            }
        }

    }

    public static void toDelete(int index, ArrayList<Games> games) {

        while (true) {
            if (index <= games.size() && index > 0) {
                System.out.println(games.get(index - 1) + " deleted!");
                games.remove(index - 1);
                break;
            } else {
                System.out.println("wrong input!try again.");
            }
            index = ScannerWrapper.getInt();
        }
    }
}
