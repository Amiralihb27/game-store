package ir.ac.kntu;

import java.time.Instant;
import java.util.ArrayList;

public class SignInMenu {

    public static void signIn(ArrayList<User> users,Store store) {
        while (true) {
            System.out.println("Sign in");
            System.out.println("You can get bac to previous action by entering exit.");
            System.out.println("Enter username:");
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter password:");
            String passInput;
            passInput = ScannerWrapper.getString();
            int index = AllUsers.existance(input, passInput);
            if (index != -1) {
                Instant start = Instant.now();
                userInterface(input, users.get(index),store);
                Instant end = Instant.now();
                int totalTime = TimeCalculator.timeDifference(start, end);
                System.out.println(totalTime);
                users.get(index).addTime(totalTime);
                ScoreCalculator.usersScore(users.get(index));
                System.out.println(users.get(index).getTimeSpent());
                System.out.println(users.get(index).getScore());
                break;
            }
            System.out.println("there is no such username or password!Try again!");
        }
    }

    public static void userInterface(String username, User user,Store store) {
        System.out.println("welcome " + username);
        while (true) {
            System.out.println("which part do you wana check? ");
            int input = printUI();
            switch (input) {
                case 1:
                    profile(user);
                    break;
                case 2:
                    store(user,store);
                    break;
                case 3:
                    library(user);
                    break;
                case 4:
                    FriendsMenu.showOptions(user,store);
                case 5:
                    break;
                default:
                    System.exit(0);
                    break;
            }
            if (input == 5) {
                break;
            }
        }


    }

    public static void profile(User user) {
        while (true) {
            System.out.println("which part do you wana go?");
            System.out.println("1_showing the Personal information");
            System.out.println("2_editing informations");
            System.out.println("3_get back");
            System.out.println("4_add cash");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    user.getProfile().show();
                    break;
                case 2:
                    user.getProfile().edit(user);
                    break;
                case 3:
                    break;
                case 4:
                    user.getProfile().addCash();
                    break;
                default:
                    System.out.println("wrong input!try again.");
                    break;
            }
            if (input == 3) {
                break;
            }
        }


    }

    public static void store(User user,Store store) {
        while (true) {
            System.out.println("which part do you wana go?");
            System.out.println("1_showing the list of games");
            System.out.println("2_search by name");
            System.out.println("3_search buy price");
            System.out.println("4_get back");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    store.showList(user);
                    break;
                case 2:
                    System.out.println("enter the name");
                    // sc.nextLine();
                    String name = ScannerWrapper.getString();
                    store.searchByName(name, user);
                    break;
                case 3:
                    System.out.println("enter the min price");
                    double min = ScannerWrapper.getDouble();
                    System.out.println("enter the max price");
                    double max = ScannerWrapper.getDouble();
                    store.searchByPrice(min, max, user);
                case 4:
                    break;
                default:
                    System.out.println("wrong input!try again.");
                    break;
            }
            if (input == 4) {
                break;
            }

        }
    }

    public static int printUI() {
        System.out.println("1_profile ");
        System.out.println("2_store ");
        System.out.println("3_library ");
        System.out.println("4_friends ");
        System.out.println("5_get back ");
        int input = ScannerWrapper.getInt();
        return input;

    }

    public static void library(User user) {
        while (true) {
            System.out.println("which part do you wana see?");
            System.out.println("1_Users Games");
            System.out.println("2_Community");
            System.out.println("3_FeedBack");
            System.out.println("4_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
               /* Library newLibrary = new Library();
                if (user.getLibrary() == null) {
                    user.setLibrary(newLibrary);
                }*/
                user.getLibrary().showGames();
            } else if (input == 2) {
               /* Library newLibrary = new Library();
                if (user.getLibrary() == null) {
                    user.setLibrary(newLibrary)
                }*/
                user.getLibrary().community();
            } else if (input==3) {
                //user.getLibrary().chooseToAddFeedBack();
                break;
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Wong input!try again");
            }
        }

    }

}
