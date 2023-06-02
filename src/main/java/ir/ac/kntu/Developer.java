package ir.ac.kntu;

import java.util.ArrayList;

public class Developer {

    private Profile profile;

    private ArrayList<Inbox> inboxes = new ArrayList<>();


    private ArrayList<GameStuff> exclusiveGames = new ArrayList<>();


    public void gameChanges(Store store) {
        //ArrayList<GameStuff> games = store.getGames();
        GameChanges.showOptions(exclusiveGames);

    }
    


}
