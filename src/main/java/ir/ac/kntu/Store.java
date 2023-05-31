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
        if (newGameStuff.size() > 0) {
            gameList.showList(newGameStuff);
            chooseGame(user, newGameStuff);
        } else {
            System.out.println("There is no such stuff in the store");
            System.out.println("*************************************");
        }

    }

    public static void chooseGame(User user, ArrayList<GameStuff> newGameStuff) {
        // Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= newGameStuff.size()) {
                GameList gameList = new GameList();
                gameList.printGameingStuffInformation(newGameStuff.get(input - 1));
                if (GameChanges.isInLibrary(user.getLibrary().getGames(), newGameStuff.get(input - 1))) {
                    break;
                }
                chooseToBuy(user, newGameStuff.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }

    }

    public static void chooseToBuy(User user, GameStuff game) {
        System.out.println("Do you want to buy a game?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                double price = discount(game, user);
                if (user.getProfile().getWalletCash() >= price) {
                    double amount = user.getProfile().getWalletCash();
                    buyVideoGameOrDevice(user, game, amount);
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

    public static void buyVideoGameOrDevice(User user, GameStuff gameStuff, double amount) {
        double price = discount(gameStuff, user);
        if (gameStuff.getClass().getSimpleName().equals("Games")) {
            if (!levelComparison(gameStuff, user)) {
                buy(user, gameStuff, amount);
            }
        } else {
            GamingDevice gamingDevice = (GamingDevice) gameStuff;
            if (gamingDevice.getNumberOfComponents() > 0) {
                gamingDevice.sell();
                buy(user, gameStuff, amount);
            }

        }
    }

    public static void buy(User user, GameStuff gameStuff, double amount) {
        if (user.getLibrary() == null) {
            Library library = new Library();
            library.addGame(gameStuff);
            user.setLibrary(library);
        } else {
            user.getLibrary().addGame(gameStuff);
            user.setLibrary(user.getLibrary());
        }
        user.getProfile().setWalletCash(amount - gameStuff.getPrice());
        System.out.println("you have bought it succesfully");
    }

    public static boolean levelComparison(GameStuff gameStuff, User user) {

        Games newGame = (Games) gameStuff;
        if (user.getLevel() != newGame.getLevel()) {
            System.out.println("You cant buy this game due to the level.");
            System.out.println("Expected level: " + newGame.getLevel() + " your score: " + user.getScore());
            return true;
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
                    return gameList.extractVideoGames(gameStuffs);

                case 2:
                    return chooseBetweenTypeOfDevices(gameList.extractDevices(gameStuffs));
                case 3:
                    return gameStuffs;
                default:
                    System.out.println("Wrong input!try again.");
            }
        }
    }

    public static ArrayList<GameStuff> chooseBetweenTypeOfDevices(ArrayList<GameStuff> gameStuff) {
        System.out.println("What do you expect from Store to show you?");
        System.out.println("1_Controler");
        System.out.println("2_Monitor");
        System.out.println("3_All kind");
        int index;
        GameList gameList = new GameList();
        while (true) {
            index = ScannerWrapper.getInt();
            switch (index) {
                case 1:
                    return gameList.extractDifferentDevices(gameStuff, "Controler");
                case 2:
                    return gameList.extractDifferentDevices(gameStuff, "Monitor");
                case 3:
                    return gameStuff;
                default:
                    System.out.println("Wrong input!try again.");
            }
        }

    }


    /*public static void chooseSorted(ArrayList<GameStuff> sortedGames, User user) {
        //Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= sortedGames.size()) {
                System.out.println(sortedGames.get(input - 1).toString());
                buy(user, sortedGames.get(input - 1));
                break;
            } else if (input == -1) {
                break;
            } else {
                System.out.println("wrong input!please try again");
            }
        }
    }*/

    public static void searchByName(String name, User user) {
        int index = 1;
        ArrayList<GameStuff> sortedGames = videoGameOrDevice();
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
            chooseGame(user, sortedGames);
        }


    }

    public static void searchByPrice(double min, double max, User user) {

        ArrayList<GameStuff> sortedGames = videoGameOrDevice();
        int foundedGames = 0;
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getPrice() <= max && gameStuffs.get(i).getPrice() >= min) {
                System.out.println((i + 1) + "_" + gameStuffs.get(i).getName());
                foundedGames++;
                sortedGames.add(gameStuffs.get(i));
            }
        }
        if (foundedGames >= 1) {
            chooseGame(user, sortedGames);
        } else {
            System.out.println("No games found.");
        }


    }

}
