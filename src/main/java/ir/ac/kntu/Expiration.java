package ir.ac.kntu;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Expiration extends Thread {

    private AllEmployes allEmployes;

    private GameStuff gameStuff;

    private int expirationTime=20;

    private Developer employee;

    private boolean hadAnswer = false;

    public Expiration(AllEmployes allEmployes, GameStuff gameStuff, Developer employee) {
        this.allEmployes = allEmployes;
        this.gameStuff = gameStuff;
        this.employee = employee;
    }

    public AllEmployes getAllEmployes() {
        return allEmployes;
    }

    public void setAllEmployes(AllEmployes allEmployes) {
        this.allEmployes = allEmployes;
    }

    public GameStuff getGameStuff() {
        return gameStuff;
    }

    public void setGameStuff(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    public int getExpirationTime() {
        return expirationTime;
    }

    public void setHadAnswer(boolean hadAnswer) {
        this.hadAnswer = hadAnswer;
    }

    public void setExpirationTime(int expirationTime) {
        this.expirationTime = expirationTime;
    }

    public void run() {

        //setExpirationTime(duration);
        Instant start = Instant.now();
        while (!hadAnswer) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            if ((int) Integer.parseInt(String.valueOf(timeElapsed.toMillis())) / 1000 == expirationTime) {
                setExpirationTime(expirationTime * 2);
                System.out.println("Joon");
                AllEmployes temporary = new AllEmployes();
                //temporary = newAllEmployees();
                ArrayList<Employes> employes = new ArrayList<>(allEmployes.getAllEmployes());
                temporary.setAllEmployes(employes);
                //Collections.copy(temporary.getAllEmployes(), allEmployes.getAllEmployes());
                // System.out.println(allEmployes.getAllEmployes().toString());
                int size=employee.getInboxes().size();
                employee.getInboxes().remove(size-1);
                temporary.getAllEmployes().remove(this.employee);


                allEmployes.sendTheReportMessage(temporary, gameStuff);
                temporary.getAllEmployes().add(this.employee);
                break;
            }
        }

    }

    public AllEmployes newAllEmployees() {
        AllEmployes temp = new AllEmployes();
        for (int i = 0; i < allEmployes.getAllEmployes().size(); i++) {
            temp.getAllEmployes().add((allEmployes.getAllEmployes().get(i)));
        }
        return temp;
    }

}
