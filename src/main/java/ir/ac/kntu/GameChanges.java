package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GameChanges {

    public static void showOptions(ArrayList<GameStuff> games, Store store, Employes employe, AllEmployes allEmployes) {
        while (true) {
            System.out.println("Which part do you wana go?");
            System.out.println("1_Add games");
            System.out.println("2_Edit game");
            System.out.println("3_Delet game");
            System.out.println("4_Feed Back");
            System.out.println("5_Give accses");
            System.out.println("6_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                addGame(games, store);
            } else if (input == 2) {
                change(games);
            } else if (input == 3) {
                deletGame(games, store);
            } else if (input == 4) {
                feedBack(games);
            } else if (input == 5) {

                findADeveloperToGiveAccess(allEmployes, employe, store);

            } else {
                break;
            }
        }

    }

    public static void change(ArrayList<GameStuff> games) {
        //sc.nextLine();
        while (true) {
            System.out.println("You can get back to previos action by entering exit.");
            System.out.println("Enter the name of the stuff:");
            String name = ScannerWrapper.getString();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            if (doesExist(games, name) != -1) {
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
                System.out.println("There is no game like this!try again.");
            }

        }


    }

    public static int doesExist(ArrayList<GameStuff> games, String name) {
        for (int i = 0; i < games.size(); i++) {
            if (name.equals(games.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isInLibrary(ArrayList<GameStuff> games, GameStuff gameStuff) {
        for (int i = 0; i < games.size(); i++) {
            if (gameStuff.equals(games.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void toChange(ArrayList<GameStuff> games, ArrayList<String> uniqueNum) {

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

    public static void edit(GameStuff game) {
        while (true) {
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter the new name of game:");
            String name = ScannerWrapper.getString();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }
            if (game.getClass().getSimpleName().equals("Games")) {
                Games newGame = (Games) game;
                System.out.println("Enter the story of game:");
                String story = ScannerWrapper.getString();
                System.out.println("Enter the genere of new game:");
                String genere = ScannerWrapper.getString();
                System.out.println("Enter the one review for new game:");
                String review = ScannerWrapper.getString();
                newGame.setNumberOfRates(0);
                System.out.println("Enter the  new rating of the  game:");
                double rating = ScannerWrapper.getDouble();
                System.out.println("Enter the new price of game:");
                double price = ScannerWrapper.getDouble();
                newGame.setPrice(price);
                newGame.setGenre(genere);
                newGame.setName(name);
                newGame.setExplenation(story);
                newGame.setRating(rating);
                ArrayList<String> reviews = new ArrayList<>();
                reviews.add(review);
                newGame.setReviews(reviews);
                newGame = versionAndLevel(newGame);
                System.out.println("The game edited succesfully!");
                break;
            }
        }
    }

    public static void addGame(ArrayList<GameStuff> gameStuffs, Store store) {
        //ArrayList<GameStuff> games=store.getGames();
        while (true) {
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter the  name of new game:");
            String name = ScannerWrapper.getString();
            if (name.equalsIgnoreCase("exit")) {
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
            game = versionAndLevel(game);
            store.addGames(game);
            if (gameStuffs != store.getGames()) {
                gameStuffs.add(game);
            }
            System.out.println(game + " succesfully added!");
            break;
        }

    }

    public static Games versionAndLevel(Games videoGame) {
        System.out.println("Enter the number between 1_4 inorder to declare the game level");
        int input = ScannerWrapper.getInt();
        videoGame.setLevelPerNumber(input);
        System.out.println("Enter 1 for Beta and 2 for Original.(declaring game version)");
        input = ScannerWrapper.getInt();
        videoGame.setVersionByNumber(input);
        System.out.println("Enter a base score for this game's level 2.");
        int base=ScannerWrapper.getInt();
        videoGame.setScore(base);
        return videoGame;
    }

    public static void deletGame(ArrayList<GameStuff> games, Store store) {
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
                toDelete(index, games, store);
                break;
            }
        }

    }

    public static void toDelete(int index, ArrayList<GameStuff> games, Store store) {

        while (true) {
            if (index <= games.size() && index > 0) {
                System.out.println(games.get(index - 1) + " deleted!");
                GameStuff shouldBeDeleted = games.get(index - 1);
                if (games != store.getGames()) {
                    games.remove(index - 1);
                }
                store.getGames().remove(shouldBeDeleted);


                break;
            } else {
                System.out.println("wrong input!try again.");
            }
            index = ScannerWrapper.getInt();
        }
    }

    public static void feedBack(ArrayList<GameStuff> games) {
        GameList gameList = new GameList();

        ArrayList<Games> videoGames = gameList.listOfBeta(games);
        if (videoGames.size() > 0) {
            System.out.println("Enter the related number to see each game's feedBack ");
            while (true) {
                String input = ScannerWrapper.getString();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= videoGames.size()) {
                    if (videoGames.get(Integer.parseInt(input) - 1).getFeedBack().size() > 0) {
                        System.out.println(videoGames.get(Integer.parseInt(input) - 1).getFeedBack());
                        break;
                    } else {
                        System.out.println("This game has no feedBack");
                        break;
                    }

                } else {
                    System.out.println("Wrong input!Try again.");
                }
            }
        } else {
            System.out.println("There is no Beta game.");
        }


    }

    public static void findADeveloperToGiveAccess(AllEmployes allEmployes, Employes employe, Store store) {

        System.out.println("Whom do you want to give accsess?");
        System.out.println("You can get back by entering exit.");
        while (true) {
            System.out.println("Enter the userName: ");
            String userName = ScannerWrapper.getString();
            if (userName.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter the passWord: ");
            String passWord = ScannerWrapper.getString();
            int index = allEmployes.doesExist(userName, passWord);
            if (index != -1 && allEmployes.getAllEmployes().get(index).getClass().getSimpleName().equals("Developer")) {
                Developer developer = (Developer) allEmployes.getAllEmployes().get(index);
                findGameToGiveAccses(developer, employe, store);
                break;
            } else {
                System.out.println("There is no username with this profile.");
            }
        }
    }

    public static void findGameToGiveAccses(Developer developer, Employes employe, Store store) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> gameStuffs = new ArrayList<>();
        if (employe.getClass().getSimpleName().equals("Admin")) {
            gameStuffs = store.getGames();
            gameStuffs = gameList.extractVideoGames(gameStuffs);
        } else {
            Developer theDeveloper = (Developer) employe;
            gameStuffs = theDeveloper.getExclusiveGames();
        }
        if (gameStuffs.size() > 0) {
            System.out.println("Enter the related number of the videoGames that you created:");
            System.out.println("You can get back by entering 'exit'. ");
            gameList.showList(gameStuffs);
            while (true) {
                int input = ScannerWrapper.getInt();
                if (input == -1) {
                    System.out.println("*******************");
                    break;
                }
                if (input > 0 && input <= gameStuffs.size()) {
                    developer.addExclusiveGames(gameStuffs.get(input - 1));
                    System.out.println("Accses of" + gameStuffs.get(input - 1).getName() + " has been given to");
                    break;
                } else {
                    System.out.println("Wrong input!try again.");
                }

            }
        } else {
            System.out.println("You didnt have created any games.");
        }

    }


}
