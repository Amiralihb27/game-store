package ir.ac.kntu;

import java.time.Instant;
import java.util.ArrayList;

public class AllEmployes {

    private ArrayList<Employes> allEmployes;


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
        ArrayList<Developer> developers = allEmployes.extractDeveloper();
        Developer employe;
        if(gameForGettingFixed.getClass().getSimpleName().equals("Games")){
            employe = allEmployes.findTheLessBusyDeveloper(developers);
        }else{
             employe = allEmployes.findTheLessBusyDeveloper(developers);
        }



     //   int duration=ScannerWrapper.getInt();
        Expiration expiration=new Expiration(allEmployes,gameForGettingFixed,employe);
        Inbox inbox = new Inbox(gameForGettingFixed,expiration);
        //expiration.setExpirationTime(5);
        employe.addInbox(inbox);
        System.out.println("The message has been sent to " + employe.getProfile().getUserName());
        System.out.println("*************************************");
        expiration.start();


    }
}
