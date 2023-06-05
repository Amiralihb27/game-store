package ir.ac.kntu;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<GameStuff> gameStuffs = new ArrayList<>();


    public ArrayList<GameStuff> getGames() {
        return gameStuffs;
    }


    public void setGames(ArrayList<GameStuff> games) {
        gameStuffs = games;
    }


    public void addGames(GameStuff gameStuff) {
        this.gameStuffs.add(gameStuff);
    }

    public void addDevice(GamingDevice gamingDevice) {
        this.gameStuffs.add(gamingDevice);
    }

    public void showList(User user) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> newGameStuff = videoGameOrDevice(this.gameStuffs);
        if (newGameStuff.size() > 0) {
            gameList.showList(newGameStuff);
            chooseGame(user, newGameStuff);
        } else {
            System.out.println("There is no such stuff in the store");
            System.out.println("*************************************");
        }

    }

    public void chooseGame(User user, ArrayList<GameStuff> newGameStuff) {
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= newGameStuff.size()) {
                GameList gameList = new GameList();
                gameList.printGameingStuffInformation(newGameStuff.get(input - 1));
                if (GameChanges.isInLibrary(user.getLibrary().getGames(), newGameStuff.get(input - 1)) &&
                        newGameStuff.get(input - 1).getClass().getSimpleName().equals("Games")) {
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

    public void chooseToBuy(User user, GameStuff game) {
        System.out.println("Do you want to buy this?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                double price = discount(game, user);
                if (user.getProfile().getWalletCash() >= price) {
                  //  double amount = user.getProfile().getWalletCash();
                    buyVideoGameOrDevice(user, game);
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

    public void buyVideoGameOrDevice(User user, GameStuff gameStuff) {
        double price = discount(gameStuff, user);
        if (gameStuff.getClass().getSimpleName().equals("Games")) {
            if (!levelComparison(gameStuff, user)) {
                buy(user, gameStuff, price);
            }
        } else {
            GamingDevice gamingDevice = (GamingDevice) gameStuff;
            if (gamingDevice.getNumberOfComponents() > 0) {
                gamingDevice.sell();
                buy(user, gameStuff, price);
            } else {
                System.out.println("We ran out of this product");
            }

        }
    }

    public void buy(User user, GameStuff gameStuff, double price) {


        user.getLibrary().addGame(gameStuff);
        user.setLibrary(user.getLibrary());
        user.getProfile().setWalletCash(user.getProfile().getWalletCash() - price);
        gameStuff.addCountOfSold();
        System.out.println("you have bought it succesfully");
        if (!gameStuff.getClass().getSimpleName().equals("Games")) {
            GamingDevice device = (GamingDevice) gameStuff;
            if (device.getNumberOfComponents() == 0) {
                this.getGames().remove(gameStuff);
            }
        }
    }

    public boolean levelComparison(GameStuff gameStuff, User user) {

        Games newGame = (Games) gameStuff;
        if (user.getScore() < newGame.getScore()) {
            System.out.println("You cant buy this game due to the level.");
            System.out.println("Expected level: " + newGame.getLevel() + "( Expected Score: " + newGame.getScore() + ")"
                    + " your score: " + user.getScore());
            return true;
        }
        return false;
    }

    public double discount(GameStuff gamingStuff, User user) {
        if (gamingStuff.getClass().getSimpleName().equals("Games")) {
            return gamingStuff.getPrice() * (100 - user.getDiscount()) / 100;

        } else {
            return gamingStuff.getPrice();
        }
    }

    public ArrayList<GameStuff> videoGameOrDevice(ArrayList<GameStuff> gameStuff) {
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
                    return gameList.extractVideoGames(gameStuff);

                case 2:
                    return chooseBetweenTypeOfDevices(gameList.extractDevices(gameStuff));
                case 3:
                    return gameStuff;
                default:
                    System.out.println("Wrong input!try again.");
            }
        }
    }

    public ArrayList<GameStuff> chooseBetweenTypeOfDevices(ArrayList<GameStuff> gameStuff) {
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

    public void searchByName(User user) {
        int index = 1;
        ArrayList<GameStuff> sortedGames = videoGameOrDevice(this.gameStuffs);
        ArrayList<GameStuff> filterdByPriceGames = new ArrayList<>();
        System.out.println("enter the name:");
        GameList gameList = new GameList();
        String name = ScannerWrapper.getString();
        for (int i = 0; i < sortedGames.size(); i++) {
            if (sortedGames.get(i).getName().startsWith(name)) {
                System.out.println(index + ":");
                gameList.gameList(sortedGames.get(i));
                index++;
                filterdByPriceGames.add(sortedGames.get(i));
            } else if (i == sortedGames.size() - 1 && filterdByPriceGames.size() < 1) {
                System.out.println("No games found with that name!");
            }
        }
        if (filterdByPriceGames.size() >= 1) {
            chooseGame(user, filterdByPriceGames);
        }


    }

    public void searchByPrice(double min, double max, User user) {

        ArrayList<GameStuff> sortedGames = videoGameOrDevice(this.gameStuffs);
       // System.out.println(sortedGames);
        ArrayList<GameStuff> filterdByPriceGames = new ArrayList<>();
        GameList gameList = new GameList();
        int foundedGames = 0;
        for (int i = 0; i < sortedGames.size(); i++) {
            if (sortedGames.get(i).getPrice() <= max && sortedGames.get(i).getPrice() >= min) {
                System.out.println((foundedGames + 1) + ":");
                gameList.gameList(sortedGames.get(i));
                foundedGames++;
                filterdByPriceGames.add(sortedGames.get(i));
            }
        }
        if (foundedGames >= 1) {
            chooseGame(user, filterdByPriceGames);
        } else {
            System.out.println("No games found.");
        }


    }

}
