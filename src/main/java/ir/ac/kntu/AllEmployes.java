package ir.ac.kntu;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class AllEmployes {

    private ArrayList<Employes> allEmployes;

    private boolean hasStarted = false;


    public void setAllEmployes(ArrayList<Employes> allEmployes) {
        this.allEmployes = allEmployes;
    }

    public AllEmployes(ArrayList<Employes> employes) {
        this.allEmployes = employes;
    }

    public AllEmployes() {
        allEmployes = new ArrayList<>();
    }

    public ArrayList<Employes> getAllEmployes() {
        return (allEmployes);
    }

    public void addEmploye(Employes employes) {
        this.allEmployes.add(employes);
    }

    public int doesExist(String userName, String passWord) {
        for (int i = 0; i < this.allEmployes.size(); i++) {
            if (allEmployes.get(i).getProfile().getUserName().equals(userName) &&
                    allEmployes.get(i).getProfile().getPassWord().equals(passWord)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Developer> extractDeveloper() {
        ArrayList<Developer> developers = new ArrayList<>();
        for (int i = 0; i < this.allEmployes.size(); i++) {
            if (allEmployes.get(i).getClass().getSimpleName().equals("Developer")) {
                Developer temp = (Developer) allEmployes.get(i);
                developers.add(temp);
            }
        }
        return developers;
    }

    public Developer findTheLessBusyDeveloper(ArrayList<Developer> developers) {
        int max = 1000;
        Developer developer = new Developer();
        for (int i = 0; i < developers.size(); i++) {
            if (developers.get(i).getScheduledEvents().size() < max) {
                max = developers.get(i).getScheduledEvents().size();
                developer = developers.get(i);
            }

        }
        return developer;
    }

    public void sendTheReportMessage(AllEmployes allEmployes, GameStuff gameForGettingFixed) {

        //   int duration=ScannerWrapper.getInt();
        System.out.println("Enter the expiration time for the message:");
        int time = ScannerWrapper.getInt();
        Expiration expiration = new Expiration();
        expiration.setExpirationTime(time);
        hasStarted = true;
        switchBetweenDevelopers(expiration, gameForGettingFixed, allEmployes);
    }

    public void sendReportByDeveloper(AllEmployes allEmployes,Expiration expiration,GameStuff gameStuff){
        switchBetweenDevelopers(expiration,gameStuff,allEmployes);
    }

    public void switchBetweenDevelopers(Expiration expiration, GameStuff gameForGettingFixed, AllEmployes allEmployes) {

        ArrayList<Developer> developers = allEmployes.extractDeveloper();
        /*if (expiration.getNumberOfReportSending() % developers.size() == 0) {
            developers = extractDeveloper();
        }*/
        Developer employe;
        expiration.setAllEmployes(allEmployes);
        expiration.setGameStuff(gameForGettingFixed);
        employe = allEmployes.findTheLessBusyDeveloper(developers);
        expiration.setEmployee(employe);
        //expiration.setExpirationTime(5);
        System.out.println("The message has been sent to " + employe.getProfile().getUserName());
        System.out.println("*************************************");
        Expiration newExpirtion = new Expiration(allEmployes, gameForGettingFixed, employe);
        newExpirtion.setExpirationTime(expiration.getExpirationTime());
        newExpirtion.setNumberOfReportSending(expiration.getNumberOfReportSending());
        Inbox inbox = new Inbox(gameForGettingFixed, newExpirtion);
        // inbox.getDuration().setHadAnswer(true);
        employe.addInbox(inbox);
        newExpirtion.start();

    }
}
