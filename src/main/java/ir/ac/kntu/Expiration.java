package ir.ac.kntu;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Expiration extends Thread {

    private AllEmployes allEmployes;

    private GameStuff gameStuff;

    private int expirationTime = 2;

    private Developer employee;

    private int numberOfReportSending = 1;

    private boolean hadAnswer = false;


    public Developer getEmployee() {
        return employee;
    }

    public void setEmployee(Developer employee) {
        this.employee = employee;
    }

    public int getNumberOfReportSending() {
        return numberOfReportSending;
    }

    public void setNumberOfReportSending(int numberOfReportSending) {
        this.numberOfReportSending = numberOfReportSending;
    }

    public boolean isHadAnswer() {
        return hadAnswer;
    }

    public Expiration() {

    }

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
        Instant start = Instant.now();
        while (!hadAnswer) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            if ((int) Integer.parseInt(String.valueOf(timeElapsed.toMillis())) / 1000 == expirationTime) {
                AllEmployes temporary = new AllEmployes();

                numberOfReportSending++;
                ArrayList<Employes> employes = new ArrayList<>(allEmployes.getAllEmployes());
                temporary.setAllEmployes(employes);
                int countOfDevelopers=allEmployes.extractDeveloper().size();
                if (numberOfReportSending % countOfDevelopers==0) {
                    setExpirationTime(expirationTime * 2);
                   // System.out.println("Time "+expirationTime);
                }
                int size = employee.getInboxes().size();
                employee.getInboxes().remove(size - 1);
                temporary.getAllEmployes().remove(this.employee);
                temporary.getAllEmployes().add(this.employee);
                if(!hadAnswer){
                    allEmployes.switchBetweenDevelopers(this, gameStuff, temporary);
                }

               /* temporary.getAllEmployes().add(this.employee);
                System.out.println("Test: "+this.employee.getProfile().getUserName());*/
                break;
            }
        }

    }


}
