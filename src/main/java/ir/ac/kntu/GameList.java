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

    public void gameList(GameStuff gameStuff) {
        String[] temp = {"*", "*"};
        for (int i = 0; i < 3; i++) {
            if (i == 1) {
                if (gameStuff.getClass().getSimpleName().equals("GamingDevice")) {
                    temp[0] = "-";
                    temp[1] = "|";
                }
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

    public ArrayList<GameStuff> extractDevices(ArrayList<GameStuff> gameStuffs) {
        ArrayList<GameStuff> device = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals("Games")) {
                device.add((GamingDevice) gameStuffs.get(i));
            }
        }
        return device;
    }

    public ArrayList<GameStuff> extractDifferentDevices(ArrayList<GameStuff> gameStuffs, String className) {
        ArrayList<GameStuff> device = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals("className")) {
                device.add(gameStuffs.get(i));
            }
        }
        return device;
    }

    public void printGameingStuffInformation(GameStuff gameStuff) {
        String consoleOutPut;
        Scanner enter = new Scanner(System.in);
        String input=gameStuff.toString();
        while (input.length() > 20) {
            consoleOutPut = input.substring(0, 20);
            String output = enter.nextLine();
            if(output.equalsIgnoreCase("exit")){
                System.exit(0);
            } else if (output.equalsIgnoreCase("get back")) {
                break;
            }
            System.out.println(consoleOutPut);
            input = input.substring(20);
        }
        System.out.println("");
        System.out.println(input);
    }
}
