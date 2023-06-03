package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class GameList {

    public void showList(ArrayList<GameStuff> gameStuff) {
        for (int i = 0; i < gameStuff.size(); i++) {
            System.out.println((i + 1) + ":");
            gameList(gameStuff.get(i));
        }
    }

    public void showVideoGames(ArrayList<Games> videGames) {
        for (int i = 0; i < videGames.size(); i++) {
            System.out.println((i + 1) + ":");
            gameList(videGames.get(i));
        }
    }

    public void gameList(GameStuff gameStuff) {
        String[] temp = new String[2];
        String className = gameStuff.getClass().getSimpleName();
        if (className.equals("GamingDevice") || className.equals("Controler") || className.equals("Monitor")) {
            temp[0] = "-";
            temp[1] = "|";
        } else {
            temp[0] = "*";
            temp[1] = "*";
        }
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                System.out.println(temp[1] + gameStuff.getName() + temp[1]);
            } else {
                starPrinting(gameStuff, temp[0]);
            }
        }
    }

    public void starPrinting(GameStuff gameStuff, String temp) {
        for (int i = 0; i < gameStuff.getName().length() + 2; i++) {
            System.out.print(temp);
        }
        System.out.println();
    }

    public ArrayList<GameStuff> extractVideoGames(ArrayList<GameStuff> gameStuffs) {
        ArrayList<GameStuff> games = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals("Games")) {
                games.add((Games) gameStuffs.get(i));
            }
        }
        return games;
    }

    public ArrayList<Games> listOfOriginal(ArrayList<GameStuff> gameStuffs) {
        ArrayList<Games> originals = new ArrayList<>();
        ArrayList<GameStuff> videoGame = extractVideoGames(gameStuffs);
        ArrayList<GameStuff> newGameStuffs = new ArrayList<>();
        // int index = 0;
        for (int i = 0; i < videoGame.size(); i++) {
            Games eachGame = (Games) videoGame.get(i);
            if (eachGame.getVersion().equals(Version.ORIGINAL)) {
                newGameStuffs.add(videoGame.get(i));
                originals.add(eachGame);
            }
        }
        showList(newGameStuffs);
        return originals;
    }

    public ArrayList<Games> listOfBeta(ArrayList<GameStuff> gameStuffs) {
        ArrayList<Games> betas = new ArrayList<>();
        ArrayList<GameStuff> videoGame = extractVideoGames(gameStuffs);
        ArrayList<GameStuff> newGameStuffs = new ArrayList<>();
        // int index = 0;
        for (int i = 0; i < videoGame.size(); i++) {
            Games eachGame = (Games) videoGame.get(i);
            if (eachGame.getVersion().equals(Version.BETA)) {
                newGameStuffs.add(videoGame.get(i));
                betas.add(eachGame);
            }
        }
        showVideoGames(betas);
        return betas;
    }

    public ArrayList<GameStuff> extractDevices(ArrayList<GameStuff> gameStuffs) {
        ArrayList<GameStuff> device = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            String className = gameStuffs.get(i).getClass().getSimpleName();
            if (className.equals("GamingDevice") || className.equals("Controler") || className.equals("Monitor")) {
                device.add(gameStuffs.get(i));
            }
        }
        return device;
    }

    public ArrayList<GameStuff> extractDifferentDevices(ArrayList<GameStuff> gameStuffs, String className) {
        ArrayList<GameStuff> device = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals(className)) {
                device.add(gameStuffs.get(i));
            }
        }
        return device;
    }

    public void printGameingStuffInformation(GameStuff gameStuff) {
        String consoleOutPut;
        Scanner enter = new Scanner(System.in);
        String input = gameStuff.toString();
        System.out.println("You can get back to menu by entering get back or" +
                " buy emtering the Enter you can see the next line");
        while (input.length() > 40) {
            int index = index(input);
            consoleOutPut = input.substring(0, index + 1);
            String output = enter.nextLine();
            if (output.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else if (output.equalsIgnoreCase("get back")) {
                break;
            }
            System.out.println(consoleOutPut);
            input = input.substring(index + 1);
            //System.out.println(input);
        }
        System.out.println("");
        System.out.println(input);
    }

    public int index(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '=') {
                return i;
            }
        }

        return 40;
    }
}
