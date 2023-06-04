package ir.ac.kntu;

import java.util.ArrayList;
//import java.util.Scanner;

public class Library {
    private ArrayList<GameStuff> gameStuffs = new ArrayList<>();



    public void setGames(ArrayList<GameStuff> games) {
        this.gameStuffs = games;
    }

    public ArrayList<GameStuff> getGames() {
        return gameStuffs;
    }

    public void library(Library library) {
        this.gameStuffs = library.getGames();
    }

    public void addGame(GameStuff games) {
        this.gameStuffs.add(games);
    }

    public void showGames() {
        if (gameStuffs.size() > 0) {
            GameList gameList = new GameList();
            gameList.showList(gameStuffs);
            // listOfGames();
            gamesInformation(gameList);
        } else {
            System.out.println("You dont have any games in your library");
            System.out.println("**************************************************");

        }

    }

    public void listOfGames() {

        for (int i = 0; i < gameStuffs.size(); i++) {
            System.out.println((i + 1) + ":" + this.gameStuffs.get(i).getName() + "----");
            if (this.gameStuffs.get(i).getClass().getSimpleName().equals("Games")) {
                Games games = (Games) gameStuffs.get(i);
                System.out.println((games.getVersion() + " version"));
            }

        }
    }




   /* public ArrayList<Games> listOfBeta() {
        ArrayList<Games> beta = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getVersion().equals(Version.BETA)) {
                System.out.println((index + 1) + ":" + this.games.get(i).getName() + "----" +
                        this.games.get(i).getVersion() + " version");
                beta.add(this.games.get(i));
            }
        }
        return beta;
    }*/

    public void gamesInformation(GameList gameList) {
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= gameStuffs.size()) {
                // System.out.println(gameStuffs.get(input - 1).toString());
                gameList.printGameingStuffInformation(gameStuffs.get(input - 1));
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
        GameList gameList = new GameList();
        ArrayList<GameStuff> newStuffs = gameList.gamesWithCommunity(gameStuffs);

        if (newStuffs.size() > 0) {
            // listOfGames();
            //gameList.showList((newGames);
            while (true) {
                System.out.println("Enter the related number to see each game's review");
                System.out.println("or you can just skip this by entering -1'.");
                int input = ScannerWrapper.getInt();
                if (input >= 1 && input <= newStuffs.size()) {
                    newStuffs.get(input - 1).community();
                    addReview(newStuffs.get(input - 1));
                    break;
                } else if (input == -1) {
                    break;
                } else {
                    System.out.println("wrong input!please try again");
                }
            }
        } else {
            System.out.println("You dont have any original games in your library to see thier community.");
            System.out.println("**************************************************");
        }
    }

    public void addReview(GameStuff gameStuff) {
        System.out.println("would you like to add a review?");
        System.out.println("1_Yes");
        System.out.println("2_No");

        // sc.nextLine();
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                String review = ScannerWrapper.getString();
                gameStuff.addReview(review);
                isVideoGame(gameStuff);

                break;
            } else if (input == 2) {
                isVideoGame(gameStuff);
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }

    public void isVideoGame(GameStuff gameStuff) {
        if (gameStuff.getClass().getSimpleName().equals("Games")) {
            addRating((Games) gameStuff);
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


    //    public void
    public void chooseToAddFeedBack() {
        GameList gameList = new GameList();
        ArrayList<Games> games = gameList.listOfBeta(gameStuffs);
        if (games.size() > 0) {
            // gameList.showVideoGames(games);
            while (true) {
                System.out.println("Enter the related number to send feedback");
                System.out.println("or you can just skip this by entering -1'.");
                int input = ScannerWrapper.getInt();
                if (input >= 1 && input <= games.size()) {
                    sendFeedBack(games.get(input - 1));
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

    public void sendFeedBack(Games game) {
        while (true) {
            System.out.println("Enter a message to be sent to this game's creator.");
            System.out.println("You can getback by entering exit. ");
            String input = ScannerWrapper.getString();
            System.out.println("Feed back added.");
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            game.addFeedBack(input);
            break;
        }
    }
}
