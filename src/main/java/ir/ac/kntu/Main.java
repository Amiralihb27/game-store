package ir.ac.kntu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StartingMenu menu = new StartingMenu();
        ScannerWrapper scanner = new ScannerWrapper();
        Profile info1 = new Profile("amirali", "Amirali8227",
                "09112222222", "amir@gmail.com");
        Profile info2 = new Profile("ali", "Aliali8227",
                "09113245627", "ali75@gmail.com");
        Profile info3 = new Profile("amir", "Amir8827",
                "09114562727", "amiramir75@gmail.com");
        Profile info4 = new Profile("kimia", "miaKimio827",
                "09114772755", "kimia@gmail.com");

        ArrayList<User> users = new ArrayList<>();
        users.add(new User(info1));
        users.add(new User(info2));
        users.add(new User(info3));
        users.add(new User(info4));
        AllUsers allUsers = new AllUsers();
        allUsers.setUsers(users);
        users.get(1).getProfile().setWalletCash(50);
        System.out.println("Enter the base score for buying level 2 games:");
        int[] base = new int[3];
        base[0] = ScannerWrapper.getInt();
        System.out.println("Enter the base discount for buying level 2 games:");
        base[1] = ScannerWrapper.getInt();
        System.out.println("Enter the time for reaching score");
        base[2] = ScannerWrapper.getInt();
        storeCreation(menu, allUsers, base);
    }

    public static void storeCreation(StartingMenu start, AllUsers allUsers, int[] base) {


        Games zed = new Games("zed", "its about zed", "action");
        zed.addReview("good game!");
        zed.addReview("good !");
        zed.addReview("not bad!");
        zed.addReview("awfull");
        zed.setLevel(Level.LEVEL_2);
        zed.setRating(10);
        zed.rate(10);
        zed.rate(9);
        zed.rate(7.25);
        zed.setPrice(10);
        zed.setScore(base[0]);
        Games witcher = new Games("witcher", "its about geralt of rivia", "RPG");
        witcher.setVersion(Version.BETA);
        witcher.setLevel(Level.LEVEL_3);
        witcher.setRating(10);
        witcher.setPrice(12.2);
        witcher.setScore(base[0]);
        witcher.addReview("Awli");
        Games game3 = new Games("darkSouls", "its about a chosen guard", "Action");
        game3.setPrice(5);
        game3.setRating(9.8);
        game3.addReview("Binazir");
        game3.setScore(base[0]);
        Games game4 = new Games("dota2", "its about a heroes", "fantasy");
        game4.setVersion(Version.BETA);
        game4.setPrice(6.3);
        game4.setRating(10);
        game4.setScore(base[0]);
        game4.addReview("fogholade");
        ArrayList<GameStuff> games = new ArrayList<>();
        games.add(zed);
        games.add(witcher);
        games.add(game3);
        games.add(game4);
        deviceCreation(games);
        Store store = new Store();
        store.setGames(games);
        createEmployes(store, start, allUsers, base);
    }

    public static void deviceCreation(ArrayList<GameStuff> gameStuffs) {
        GamingDevice controler = new Controler(5,
                12.2, Type.REMOTE, "good for playing ps4", "ps4 controler");
        GamingDevice controler2 = new Controler(1,
                10.3, Type.WIRED, "good for playing ", "playing controllerx20");
        GamingDevice controler3 = new Controler(2,
                20, Type.WIRED, "good for playing pc", "pc controler");
        GamingDevice controler4 = new Monitor(60,
                32, 50);
        controler4.setPrice(10);
        controler4.setExplenation("it was used only once");
        controler4.addReview("its greate for gaming.");
        controler4.setName("Razor Monitor");
        gameStuffs.add(controler);
        gameStuffs.add(controler2);
        gameStuffs.add(controler3);
        gameStuffs.add(controler4);


    }

    public static void createEmployes(Store store, StartingMenu start, AllUsers allUsers, int[] base) {
        Profile info1 = new Profile("Amir", "Amir8227",
                "0911112244", "amir82@gmail.com");
        Profile info2 = new Profile("aliB", "Aliali8227",
                "0911112245", "ali93@gmail.com");
        Profile info3 = new Profile("amirA", "Amir08827",
                "0911112247", "amiramir75@gmail.com");
        Profile info4 = new Profile("miaplays", "miaKimio827",
                "0917712244", "kimia@gmail.com");
        Profile info5 = new Profile("mohammad", "mohammad8227",
                "0915512244", "mohammad@gmail.com");
        Profile info6 = new Profile("akbar", "akbar27",
                "0978712244", "akbar@gmail.com");
        Profile info7 = new Profile("erfan", "Erfan555",
                "091112244", "erfan@gmail.com");
        Profile info8 = new Profile("amin", "Amin272",
                "09778881244", "amin@gmail.com");
        Admin admin1 = new Admin(info1);
        Admin admin2 = new Admin(info2);
        Developer developer1 = new Developer(info3);
        Developer developer2 = new Developer(info4);
        Developer developer3 = new Developer(info7);
        Developer developer4 = new Developer(info8);
        Seller seller1 = new Seller(info5);
        Seller seller2 = new Seller(info6);
        AllEmployes allEmployes = new AllEmployes();
        allEmployes.addEmploye(admin1);
        allEmployes.addEmploye(developer2);
        allEmployes.addEmploye(developer1);
        allEmployes.addEmploye(developer3);
        allEmployes.addEmploye(developer4);
        allEmployes.addEmploye(admin2);
        allEmployes.addEmploye(seller1);
        allEmployes.addEmploye(seller2);
        start.choose(store, allEmployes, allUsers, base);

    }
}
