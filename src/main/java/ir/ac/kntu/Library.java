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
            listOfGames();
            gamesInformation();
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

   /* public ArrayList<Games> extractVideoGames() {

        ArrayList<Games> videoGame = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.getClass().getSimpleName().equals("Games")) {
                videoGame.add((Games) gameStuffs.get(i));
            }
        }
        return videoGame;
    }*/

    public ArrayList<Games> listOfOriginal() {
        ArrayList<Games> originals = new ArrayList<>();
        GameList gameList = new GameList();
        ArrayList<GameStuff> videoGame = gameList.extractVideoGames(gameStuffs);
        int index = 0;
        for (int i = 0; i < videoGame.size(); i++) {
            Games eachGame = (Games) videoGame.get(i);
            if (eachGame.getVersion().equals(Version.ORIGINAL)) {
                System.out.println((index + 1) + ":" + videoGame.get(i).getName() + "----" +
                        eachGame.getVersion() + " version");
                originals.add(eachGame);
            }
        }
        return originals;
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

    public void gamesInformation() {
        while (true) {
            System.out.println("Enter the related number to see each game's information");
            System.out.println("or you can just skip this by entering -1'.");
            int input = ScannerWrapper.getInt();
            if (input >= 1 && input <= gameStuffs.size()) {
                System.out.println(gameStuffs.get(input - 1).toString());
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
        ArrayList<Games> newGames = gameList.listOfOriginal(gameStuffs);
        if (newGames.size() > 0) {
            // listOfGames();
            //gameList.showList((newGames);
            while (true) {
                System.out.println("Enter the related number to see each game's review");
                System.out.println("or you can just skip this by entering -1'.");
                int input = ScannerWrapper.getInt();
                if (input >= 1 && input <= newGames.size()) {
                    newGames.get(input - 1).community();
                    addReview(newGames.get(input - 1));
                    break;
                } else if (input == -1) {
                    break;
                } else {
                    System.out.println("wrong input!please try again");
                }
            }
        } else {
            System.out.println("You dont have any original games in your library");
            System.out.println("**************************************************");
        }
    }

    public void addReview(GameStuff gameStuff) {
        System.out.println("would you like to add a review?");
        System.out.println("1_Yes");
        System.out.println("2_No");
        int input = ScannerWrapper.getInt();
        // sc.nextLine();
        while (true) {
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
    /*public void chooseToAddFeedBack() {
        if (games.size() > 0) {
            GameList.showList();
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
    }*/

    public void sendFeedBack(Games game) {
//send to the owner
    }


}
