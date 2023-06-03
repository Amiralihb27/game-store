package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Developer extends Employes {

    private ArrayList<Inbox> inboxes = new ArrayList<>();

    private ArrayList<GameStuff> exclusiveGames = new ArrayList<>();

    private ArrayList<GameStuff> scheduledEvents = new ArrayList<>();

    private boolean willingToRepair;


    public Developer() {

    }

    public void addExclusiveGames(GameStuff  newGameStuff){
        this.exclusiveGames.add(newGameStuff);
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

    public void checkingInbox(AllEmployes allEmployes) {
        if (this.inboxes.size() > 0) {
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
                    System.out.println(this.inboxes.get(Integer.parseInt(input) - 1).getGameStuff().getName());
                    chooseToAccept(this.inboxes.get(Integer.parseInt(input) - 1), allEmployes);
                    break;
                } else {
                    System.out.println("Wrong input!Try again.");
                }
            }
        } else {
            System.out.println("You dont have any message in your inbox!");
        }

    }

    public void chooseToAccept(Inbox message, AllEmployes allEmployes) {

        while (true) {
            System.out.println("Do u wana fix this game?");
            System.out.println("1_Yes");
            System.out.println("2_No");
            System.out.println("3_getBack");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    setWillingToRepairt(true, message.getGameStuff());
                    this.inboxes.remove(message);
                    break;
                case 2:
                    setWillingToRepairt(false, message.getGameStuff());
                    AllEmployes temporary = new AllEmployes();
                    Collections.copy(temporary.getAllEmployes(), allEmployes.getAllEmployes());
                    if (temporary.getAllEmployes().size() > 0) {
                        temporary.sendTheReportMessage(temporary, message.getGameStuff());
                    } else {
                        message.setDuration(message.getDuration() * 2);
                        temporary.sendTheReportMessage(temporary, message.getGameStuff());
                    }

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Wrong input!Try again.");
            }
            if (input <= 3 && input > 0) {
                break;
            }

        }
    }

    public void setWillingToRepairt(boolean status, GameStuff gameStuff) {
        this.willingToRepair = status;
        if (willingToRepair == true) {
            this.scheduledEvents.add(gameStuff);
        }

    }


    public void scheduledEvents(Store store) {
        if (this.scheduledEvents.size() > 0) {
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
                    store.addGames(this.scheduledEvents.get(Integer.parseInt(input) - 1));
                    this.scheduledEvents.remove(Integer.parseInt(input) - 1);
                    break;
                } else {
                    System.out.println("Wrong input!Try again.");
                }
            }
        } else {
            System.out.println("You dont have any games to fix in your list.");
        }

    }

    public void findADeveloperToGiveAccess(AllEmployes allEmployes) {
        if (this.exclusiveGames.size() > 0) {
            System.out.println("Whom do you want to give accsess?");
            System.out.println("You can get back by entering exit.");
            while (true){
                System.out.println("Enter the userName: ");
                String userName = ScannerWrapper.getString();
                if(userName.equalsIgnoreCase("exit")){
                    break;
                }
                System.out.println("Enter the passWord: ");
                String passWord = ScannerWrapper.getString();
                int index = allEmployes.doesExist(userName, passWord);
                if (index != -1 && allEmployes.getAllEmployes().get(index).getClass().getSimpleName().equals("Developer")) {
                    Developer developer = (Developer) allEmployes.getAllEmployes().get(index);
                    findGameToGiveAccses(developer);
                    break;
                } else{
                    System.out.println("There is no username with this profile.");
                }
            }


        }
    }

    public void findGameToGiveAccses(Developer developer) {
        System.out.println("Enter the related number of the videoGames that you created:");
        System.out.println("You can get back by entering 'exit'. ");
        System.out.println("video games you've created:");
        GameList gameList=new GameList();
        gameList.showList(this.exclusiveGames);
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input==-1) {
                System.out.println("***************");
                break;
            }
            if(input>0 && input<=this.exclusiveGames.size()){
                developer.addExclusiveGames(this.exclusiveGames.get(input-1));
                break;
            }else{
                System.out.println("Wrong input!try again.");
            }

        }
    }




}
