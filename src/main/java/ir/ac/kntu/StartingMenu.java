package ir.ac.kntu;

import java.util.ArrayList;
//import java.util.Scanner;

public class StartingMenu {

    public StartingMenu() {

    }

    public void choose(ArrayList<User> users, Store store, AllEmployes allEmployes) {
        while (true) {
            System.out.println("Choose your role:");
            System.out.println("1_Admin");
            System.out.println("2_User");
            System.out.println("3_Developers");
            System.out.println("4_get back");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                adminMenu(users, store, allEmployes);
            } else if (input == 2) {
                userMenu(users, store);
            } else if (input == 3) {
                adminMenu(users, store, allEmployes);
            } else if (input == 4) {
                break;
            } else if (input == 5) {
                System.exit(0);
            } else {
                System.out.println("wrong input!try again!");
            }
        }
    }

    public void adminMenu(ArrayList<User> users, Store store, AllEmployes allEmployes) {
        while (true) {
            System.out.println("You can get back by entering exit.");
            System.out.println("enter username:");
            String userName = ScannerWrapper.getString();
            if (userName.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("enter password:");
            String passWord = ScannerWrapper.getString();
            int index = allEmployes.doesExist(userName, passWord);

            if (index != -1) {
                String className = allEmployes.getAllEmployes().get(index).getClass().getSimpleName();
                switch (className) {
                    case "Admin":
                        Admin admin = (Admin) allEmployes.getAllEmployes().get(index);
                        adminOptions(users, admin, store, allEmployes);
                        break;
                    case "Developer":
                        Developer developer = (Developer) allEmployes.getAllEmployes().get(index);
                        developerOptions(developer, store, allEmployes);
                        break;
                    default:
                        break;

                }
                break;
            } else {
                System.out.println("there is no employee with this username or password!Try again.");
            }
        }

    }

    public void adminOptions(ArrayList<User> users, Admin admin, Store store, AllEmployes allEmployes) {

        while (true) {
            System.out.println("welcomme dear admin!");
            System.out.println("Which part do you wana go?");
            System.out.println("1_Users");
            System.out.println("2_Games");
            System.out.println("3_Report Crashes");
            System.out.println("4_get back");
            System.out.println("5_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                admin.userChanges(users);
            } else if (input == 2) {
                admin.gameChanges(store);
            } else if (input == 3) {
                admin.crashReport(store, allEmployes);
            } else if (input == 4) {
                break;
            } else if (input == 5) {
                System.exit(0);
            } else {
                System.out.println("Wrong input!Try agian.");
            }
        }
    }

    public void developerOptions(Developer developer, Store store, AllEmployes allEmployes) {
        while (true) {
            System.out.println("welcomme " + developer.getProfile().getUserName() + " the developer!");
            System.out.println("Which part do you wana go?");
            System.out.println("1_Profile");
            System.out.println("2_Games");
            System.out.println("3_Inbox");
            System.out.println("4_Scheduled ");
            System.out.println("5_getBack");
            System.out.println("6_Exit");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    //
                    break;
                case 2:
                    developer.gameChanges(store);
                    break;
                case 3:
                    developer.checkingInbox(allEmployes);
                    break;
                case 4:
                    developer.scheduledEvents(store);
                    break;
                case 5:
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!Try agian.");
                    break;
            }
            if (input == 5) {
                break;
            }
        }
    }

    public void userMenu(ArrayList<User> users, Store store) {
        while (true) {
            System.out.println("1_sign out");
            System.out.println("2_sign in");
            System.out.println("3_get back");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                SignOutMenu.signOut(users);
            } else if (input == 2) {
                SignInMenu.signIn(users, store);
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



