package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StartingMenu a = new StartingMenu();
        ScannerWrapper scanner = new ScannerWrapper();
        Profile info1 = new Profile("amirali", "Amirali8227",
                "09112222222", "amir@gmail.com");
        Profile info2 = new Profile("ali", "Aliali8227",
                "09113245627", "ali75@gmail.com");
        Profile info3 = new Profile("amir", "Amir8827",
                "09114562727", "amiramir75@gmail.com");
        Profile info4 = new Profile("kimia", "miaKimio827",
                "09114772755", "kimia@gmail.com");
        Games zed = new Games("zed", "its about zed", "action");
        zed.addReview("good game!");
        zed.addReview("good !");
        zed.addReview("not bad!");
        zed.addReview("awfull");
        zed.setRating(10);
        zed.rate(10);
        zed.rate(9);
        zed.rate(7.25);
        zed.setPrice(10);
        Games witcher = new Games("witcher", "its about geralt of rivia", "RPG");
        witcher.setVersion(Version.BETA);
        witcher.setRating(10);
        witcher.setPrice(12.2);
        witcher.addReview("Awli");
        Games game3 = new Games("darkSouls", "its about a chosen guard", "Action");
        game3.setPrice(5);
        game3.setRating(9.8);
        game3.addReview("Binazir");
        ArrayList<GameStuff> games = new ArrayList<>();
        games.add(zed);
        games.add(witcher);
        games.add(game3);
        Store store=new Store();
        store.setGames(games);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(info1));
        users.add(new User(info2));
        users.add(new User(info3));
        users.add(new User(info4));
        AllUsers.setUsers(users);
        users.get(1).getProfile().setWalletCash(50);
        createEmployes(users,store,a);
    }

    public static void createEmployes(ArrayList<User> users, Store store, StartingMenu start){
        Profile info1 = new Profile("Amir", "Amir8227",
                "0911112244", "amir82@gmail.com");
        Profile info2 = new Profile("aliB", "Aliali8227",
                "0911112245", "ali93@gmail.com");
        Profile info3 = new Profile("amirA", "Amir08827",
                "0911112247", "amiramir75@gmail.com");
        Profile info4 = new Profile("miaplays", "miaKimio827",
                "0917712244", "kimia@gmail.com");
        Admin admin1 = new Admin(info1);
        Admin admin2 =new Admin(info2);
        Developer developer1=new Developer(info3);
        Developer developer2=new Developer(info4);

        AllEmployes allEmployes=new AllEmployes();
        allEmployes.addEmploye(admin1);
        allEmployes.addEmploye(developer2);
        allEmployes.addEmploye(developer1);
        allEmployes.addEmploye(admin2);
        start.choose(users,store,allEmployes);

    }
}
