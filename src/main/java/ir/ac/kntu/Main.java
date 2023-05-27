package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        //Store store = new Store();
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
        witcher.setRating(10);
        witcher.setPrice(12.2);
        witcher.addReview("Awli");
        Games game3 = new Games("darkSouls", "its about a chosen guard", "Action");
        game3.setPrice(5);
        game3.setRating(9.8);
        game3.addReview("Binazir");
        ArrayList<Games> games = new ArrayList<>();
        games.add(zed);
        games.add(witcher);
        games.add(game3);
        Store.setGames(games);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(info1));
        users.add(new User(info2));
        users.add(new User(info3));
        users.add(new User(info4));
        AllUsers.setUsers(users);
        users.get(1).getProfile().setWalletCash(50);
        //Admin ad = new Admin();
        a.choose(users);
    }
}
