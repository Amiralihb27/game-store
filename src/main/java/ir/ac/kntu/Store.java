package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private static ArrayList<Games> games = new ArrayList<>();

    public static ArrayList<Games> getGames() {
        return games;
    }


    public static void setGames(ArrayList<Games> games) {
        Store.games = games;
    }

    public static void showList(User user) {
        for (int i = 0; i < games.size(); i++) {
            System.out.println((i + 1) + ":" + games.get(i).getName());
        }
        chooseGame(user);

    }

    public static void chooseGame(User user) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = sc.nextInt();
            if (input >= 1 && input <= games.size()) {
                System.out.println(games.get(input - 1).toString());
                buy(user, sc, games.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }

    }

    public static void buy(User user, Scanner sc, Games game) {
        System.out.println("Do you want to buy a game?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        while (true) {
            int input = sc.nextInt();
            if (input == 1) {
                if (user.getProfile().getWalletCash() >= game.getPrice()) {
                    double amount = user.getProfile().getWalletCash();
                    if (user.getLibrary() == null) {
                        Library library = new Library();
                        library.addGame(game);
                        user.setLibrary(library);
                    } else {
                        user.getLibrary().addGame(game);
                        user.setLibrary(user.getLibrary());
                    }
                    user.getProfile().setWalletCash(amount - game.getPrice());
                    System.out.println("you have bought it succesfully");
                    break;
                } else {
                    System.out.println("You dont have enough money");
                    break;
                }
            } else if (input == 2) {
                break;
            } else {
                System.out.println("wrong input!try again!");
            }
        }
    }


    public static void chooseSorted(ArrayList<Games> sortedGames,User user) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = sc.nextInt();
            if (input >= 1 && input <= sortedGames.size()) {
                System.out.println(sortedGames.get(input - 1).toString());
                buy(user,sc,sortedGames.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }
    }

    public static void searchByName(String name,User user) {
        int index = 1;
        ArrayList<Games> sortedGames = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getName().startsWith(name)) {
                System.out.println(index + ":" + games.get(i).getName());
                index++;
                sortedGames.add(games.get(i));
            } else if (i == games.size() - 1 && sortedGames.size()<1) {
                System.out.println("No games found with that name!");
            }
        }
        if (sortedGames.size() >= 1) {
            chooseSorted(sortedGames,user);
        }


    }

    public static void searchByPrice(double min, double max,User user) {

        int foundedGames=0;
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getPrice() <= max && games.get(i).getPrice() >= min) {
                System.out.println((i+1)+"_"+games.get(i).getName());
                foundedGames++;
            }
        }
        if (foundedGames>=1){
            chooseGame(user);
        }else{
            System.out.println("No games found.");
        }


    }

}
