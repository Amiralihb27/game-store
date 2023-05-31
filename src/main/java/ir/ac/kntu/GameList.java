package ir.ac.kntu;

import java.util.ArrayList;

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

    public ArrayList<GameStuff> videoGames(ArrayList<GameStuff> gameStuffs) {
        ArrayList<GameStuff> games = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals("Games")) {
                games.add((Games) gameStuffs.get(i));
            }
        }
        return games;
    }

    public ArrayList<GameStuff> devices(ArrayList<GameStuff> gameStuffs) {
        ArrayList<GameStuff> device = new ArrayList<>();
        for (int i = 0; i < gameStuffs.size(); i++) {
            if (gameStuffs.get(i).getClass().getSimpleName().equals("Games")) {
                device.add((GamingDevice) gameStuffs.get(i));
            }
        }
        return device;
    }
}
