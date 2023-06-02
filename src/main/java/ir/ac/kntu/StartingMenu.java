package ir.ac.kntu;

import java.util.ArrayList;
//import java.util.Scanner;

public class StartingMenu {

    public StartingMenu() {

    }

    public static void choose(ArrayList<User> users,Store store) {
        while (true) {
            System.out.println("Choose your role:");
            System.out.println("1_Admin");
            System.out.println("2_User");
            System.out.println("3_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                adminMenu(users,store);
            } else if (input == 2) {
                userMenu(users,store);
            } else if (input == 3) {
                break;
            } else {
                System.out.println("wrong input!try again!");
            }
        }
    }

    public static void adminMenu(ArrayList<User> users,Store store) {
        while (true) {
            System.out.println("You can get back by entering exit.");
            System.out.println("enter username:");
            String userName = ScannerWrapper.getString();
            if (userName.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("enter password:");
            String passWord = ScannerWrapper.getString();
            Admin admin = new Admin();
            if (userName.equals(admin.getUserName()) && passWord.equals(admin.getPassWord())) {
                adminOptions(users, admin,store);
                break;
            } else {
                System.out.println("there is no admin with this username or password!Try again.");
            }
        }

    }

    public static void adminOptions(ArrayList<User> users, Admin admin,Store store) {

        while (true) {
            System.out.println("welcomme dear admin!");
            System.out.println("Which part do you wana go?");
            System.out.println("1_Users");
            System.out.println("2_Games");
            System.out.println("3_get back");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                admin.userChanges(users);
            } else if (input == 2) {
                admin.gameChanges(store);
            } else if (input == 3) {
                break;
            } else if (input == 4) {
                System.exit(0);
            } else {
                System.out.println("Wrong input!Try agian.");
            }
        }
    }

    public static void userMenu(ArrayList<User> users,Store store) {
        while (true) {
            System.out.println("1_sign out");
            System.out.println("2_sign in");
            System.out.println("3_get back");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                SignOutMenu.signOut(users);
            } else if (input == 2) {
                SignInMenu.signIn(users,store);
            } else if (input == 3) {
                break;
            } else if (input == 4) {
                System.exit(0);
            } else {
                System.out.println("wrong input!try again.");
            }
        }
    }

}



