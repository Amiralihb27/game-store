package ir.ac.kntu;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private static ArrayList<GameStuff> gameStuffs = new ArrayList<>();


    public static ArrayList<GameStuff> getGames() {
        return gameStuffs;
    }


    public static void setGames(ArrayList<GameStuff> games) {
        gameStuffs = games;
    }

    public static void showList(User user) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> newGameStuff = videoGameOrDevice();
        if(newGameStuff.size()>0){
            gameList.showList(newGameStuff);
            chooseGame(user, newGameStuff);
        }else {
            System.out.println("There is no such stuff in the store");
            System.out.println("*************************************");
        }

    }

    public static void chooseGame(User user, ArrayList<GameStuff> newGameStuff) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = sc.nextInt();
            if (input >= 1 && input <= newGameStuff.size()) {
                System.out.println(newGameStuff.get(input - 1).toString());
                buy(user, sc, newGameStuff.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }

    }

    public static void buy(User user, Scanner sc, GameStuff game) {
        System.out.println("Do you want to buy a game?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        while (true) {
            int input = sc.nextInt();
            if (input == 1) {
                double price = discount(game, user);
                if (levelComparison(game, user)) {
                    break;
                }
                if (user.getProfile().getWalletCash() >= price) {
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

    public static boolean levelComparison(GameStuff gameStuff, User user) {
        if (gameStuff.getClass().getSimpleName().equals("Games")) {

            Games newGame = (Games) gameStuff;
            if (user.getLevel() != newGame.getLevel()) {
                System.out.println("You cant buy this game due to the level.");
                System.out.println("Expected level: " + newGame.getLevel() + " your score: " + user.getScore());
                return true;
            }
            return false;
        }
        return false;
    }

    public static double discount(GameStuff gamingStuff, User user) {
        if (gamingStuff.getClass().getSimpleName().equals("Games")) {
            return gamingStuff.getPrice() * (100 + user.getDiscount()) / 100;
        } else {
            return gamingStuff.getPrice();
        }
    }

    public static ArrayList<GameStuff> videoGameOrDevice() {
        System.out.println("What do you expect from Store to show you?");
        System.out.println("1_Video Games");
        System.out.println("2_Devices");
        System.out.println("3_All stuffs");
        int index;
        GameList gameList = new GameList();
        while (true) {
            index = ScannerWrapper.getInt();
            switch (index) {
                case 1:

                    return gameList.videoGames(gameStuffs);

                case 2:
                    return gameList.devices(gameStuffs);
                case 3:
                    return gameStuffs;
                default:
                    System.out.println("Wrong input!try again.");
            }
        }
    }


    public static void chooseSorted(ArrayList<GameStuff> sortedGames, User user) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = sc.nextInt();
            if (input >= 1 && input <= sortedGames.size()) {
                System.out.println(sortedGames.get(input - 1).toString());
                buy(user, sc, sortedGames.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }
    }

    public static void searchByName(String name, User user) {
        int index = 1;
        ArrayList<GameStuff> sortedGames = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getName().startsWith(name)) {
                System.out.println(index + ":" + gameStuffs.get(i).getName());
                index++;
                sortedGames.add(gameStuffs.get(i));
            } else if (i == gameStuffs.size() - 1 && sortedGames.size() < 1) {
                System.out.println("No games found with that name!");
            }
        }
        if (sortedGames.size() >= 1) {
            chooseSorted(sortedGames, user);
        }


    }

    public static void searchByPrice(double min, double max, User user) {

        int foundedGames = 0;
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getPrice() <= max && gameStuffs.get(i).getPrice() >= min) {
                System.out.println((i + 1) + "_" + gameStuffs.get(i).getName());
                foundedGames++;
            }
        }
        if (foundedGames >= 1) {
            chooseGame(user,gameStuffs);
        } else {
            System.out.println("No games found.");
        }


    }

}
