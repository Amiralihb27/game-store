package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Developer extends Employes {

    private ArrayList<Inbox> inboxes = new ArrayList<>();

    private ArrayList<GameStuff> exclusiveGames = new ArrayList<>();

    private ArrayList<GameStuff> scheduledEvents = new ArrayList<>();

    private boolean willingToRepair;


    public Developer() {

    }

    public void addInbox(Inbox inbox) {
        this.inboxes.add(inbox);
    }

    public void setInboxes(ArrayList<Inbox> inboxes) {
        this.inboxes = inboxes;
    }

    public void setExclusiveGames(ArrayList<GameStuff> exclusiveGames) {
        this.exclusiveGames = exclusiveGames;
    }

    public void setScheduledEvents(ArrayList<GameStuff> scheduledEvents) {
        this.scheduledEvents = scheduledEvents;
    }

    public void setWillingToRepair(boolean willingToRepair) {
        this.willingToRepair = willingToRepair;
    }

    public ArrayList<Inbox> getInboxes() {
        return inboxes;
    }

    public ArrayList<GameStuff> getExclusiveGames() {
        return new ArrayList<>(exclusiveGames);
    }

    public ArrayList<GameStuff> getScheduledEvents() {
        return new ArrayList<>(scheduledEvents);
    }

    public boolean isWillingToRepair() {
        return willingToRepair;
    }

    public Developer(Profile profile) {
        super(profile);
    }

    public void gameChanges(Store store) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> games = gameList.extractVideoGames(exclusiveGames);
        GameChanges.showOptions(exclusiveGames, store);
    }

    public void checkingInbox() {
        System.out.println("enter the related number to see the messege from your inbox");
        System.out.println("You can getback by entering exit.");
        for (int i = 0; i < this.inboxes.size(); i++) {
            System.out.println((i + 1) + "_" + this.inboxes.get(i).getGameStuff().getName() + " is broken!");
        }

        while (true) {
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (Integer.parseInt(input) - 1 < this.inboxes.size() && Integer.parseInt(input) - 1 >= 0) {
                System.out.println(this.inboxes.get(Integer.parseInt(input) - 1));
                chooseToAccept(this.inboxes.get(Integer.parseInt(input) - 1));
            } else {
                System.out.println("Wrong input!Try again.");
            }
        }
    }

    public void chooseToAccept(Inbox message) {

        while (true) {
            System.out.println("Do u wana fix this game?");
            System.out.println("1_Yes");
            System.out.println("2_No");
            System.out.println("3_getBack");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    setWillingToRepairt(true, message.getGameStuff());
                    break;
                case 2:
                    setWillingToRepairt(false, message.getGameStuff());
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input!Try again.");
            }

        }
    }

    public void setWillingToRepairt(boolean status, GameStuff gameStuff) {
        this.willingToRepair = status;
        if (willingToRepair == true) {
            this.scheduledEvents.add(gameStuff);
        }

    }


    public void scheduledEvents() {
        for (int i = 0; i < this.scheduledEvents.size(); i++) {
            System.out.println((i + 1) + "_" + scheduledEvents.get(i));
        }
        System.out.println("***********************");
        System.out.println("Enter the related nuber to fix the game or you can enter 'exit' inorder to getback.");
        while (true) {
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (Integer.parseInt(input) - 1 < this.scheduledEvents.size() && Integer.parseInt(input) - 1 >= 0) {
                System.out.println(this.scheduledEvents.get(Integer.parseInt(input) - 1).getName() + " got fixed!");
                this.scheduledEvents.remove(Integer.parseInt(input) - 1);
            } else {
                System.out.println("Wrong input!Try again.");
            }
        }
    }


}
