package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;

public class ShowTheMosts {

    public void showOptions(Store store, User user) {

        while (true) {
            System.out.println("1_Show the bestselling stuff");
            System.out.println("2_calculate the price of a list");
            System.out.println("3_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                ArrayList<GameStuff> gameStuffs;
                gameStuffs = new ArrayList<>(store.videoGameOrDevice(store.getGames()));
                sortByCountOfSold(gameStuffs);
            } else if (input == 2) {
                chooseBetweenLibraryAndStore(store, user);
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input.try again");
            }
        }

    }

    public void chooseBetweenLibraryAndStore(Store store, User user) {

        System.out.println("What games do you wana calculate");
        System.out.println("1_Games in store");
        System.out.println("2_Games in your library");
        System.out.println("3_get back");
        while (true) {
            int input = ScannerWrapper.getInt();
            ArrayList<GameStuff> gameStuffs;
            if (input == 1) {
                gameStuffs = new ArrayList<>(store.videoGameOrDevice(store.getGames()));
                calculateThePriceOfTheList(gameStuffs);
                break;
            } else if (input == 2) {
                gameStuffs = new ArrayList<>(store.videoGameOrDevice(user.getLibrary().getGames()));
                calculateThePriceOfTheList(gameStuffs);
                break;
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input.Try again");
            }
        }
    }

    public void calculateThePriceOfTheList(ArrayList<GameStuff> gameStuffs) {
        if (gameStuffs.size() > 0) {
            double price = 0;
            for (int i = 0; i < gameStuffs.size(); i++) {
                price += gameStuffs.get(i).getPrice();
            }
            System.out.println("Total cost of this list: "+price);
        } else {
            System.out.println("There is no stuff in this list.");
            System.out.println("*************************************");
        }

    }

    public void sortByCountOfSold(ArrayList<GameStuff> gameStuff) {

        for (int i = 0; i < gameStuff.size() - 1; i++) {
            for (int j = i + 1; j < gameStuff.size(); j++) {
                if (gameStuff.get(i).getCountOfSold() < gameStuff.get(j).getCountOfSold()) {
                    Collections.swap(gameStuff, i, j);

                }
            }
        }
        printMostSolds(gameStuff);
    }

    public void printMostSolds(ArrayList<GameStuff> gameStuff) {
        for (int i = 0; i < gameStuff.size(); i++) {
            System.out.println(gameStuff.get(i).getName() + "  CountOfSold: " + gameStuff.get(i).getCountOfSold());
        }
        System.out.println("******************************");
    }

    public void sortByScore(ArrayList<User> allUsers) {

        for (int i = 0; i < allUsers.size() - 1; i++) {
            for (int j = i + 1; j < allUsers.size(); j++) {
                if (allUsers.get(i).getScore() < allUsers.get(j).getScore()) {
                    Collections.swap(allUsers, i, j);
                }
            }
        }
        printMostOnlines(allUsers);
    }

    public void printMostOnlines(ArrayList<User> allUsers) {
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println(allUsers.get(i).getProfile().getUserName() + "  Score: " + allUsers.get(i).getScore());
        }
        System.out.println("******************************");
    }
}
