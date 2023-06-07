package ir.ac.kntu;

//import java.util.Scanner;

public class StartingMenu {

    public StartingMenu() {

    }

    public void choose(Store store, AllEmployes allEmployes, AllUsers allUsers,int[] base) {
        while (true) {
            System.out.println("Choose your role:");
            System.out.println("1_Admin");
            System.out.println("2_User");
            System.out.println("3_Developers");
            System.out.println("4_Seller");
            System.out.println("5_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                adminMenu(allUsers, store, allEmployes);
            } else if (input == 2) {
                userMenu(store, allUsers,base);
            } else if (input == 3) {
                adminMenu(allUsers, store, allEmployes);
            } else if (input == 4) {
                adminMenu(allUsers, store, allEmployes);
            } else if (input == 5) {
                System.exit(0);
            } else {
                System.out.println("wrong input!try again!");
            }
        }
    }

    public void adminMenu(AllUsers allUsers, Store store, AllEmployes allEmployes) {
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
                        adminOptions(allUsers, admin, store, allEmployes);
                        break;
                    case "Developer":
                        Developer developer = (Developer) allEmployes.getAllEmployes().get(index);
                        developerOptions(developer, store, allEmployes);
                        break;
                    case "Seller":
                        Seller seller = (Seller) allEmployes.getAllEmployes().get(index);
                        sellerOptions(seller, store, allEmployes);
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

    public void adminOptions(AllUsers allUsers, Admin admin, Store store, AllEmployes allEmployes) {
        while (true) {
            System.out.println("welcomme dear admin!");
            System.out.println("Which part do you wana go?");
            System.out.println("1_Users");
            System.out.println("2_Games");
            System.out.println("3_Report Crashes");
            System.out.println("4_Accessories");
            System.out.println("5_Profile");
            System.out.println("6_get Back");
            System.out.println("7_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                admin.userChanges(allUsers);
            } else if (input == 2) {
                admin.gameChanges(store, allEmployes);
            } else if (input == 3) {
                admin.crashReport(store, allEmployes);
            } else if (input == 4) {
                DeviceChanges deviceChanges = new DeviceChanges();
                deviceChanges.showOptions(store.getGames(), store, admin, allEmployes);
            } else if (input == 5) {
                ProfileChanges profileChanges = new ProfileChanges();
                profileChanges.employees(allEmployes, admin);
            } else if (input == 6) {
                break;
            } else if (input == 7) {
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
                    ProfileChanges profileChanges = new ProfileChanges();
                    profileChanges.showOptions(allEmployes, developer);
                    break;
                case 2:
                    developer.gameChanges(store, allEmployes);
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

    public void sellerOptions(Seller seller, Store store, AllEmployes allEmployes) {
        while (true) {
            System.out.println("welcomme " + seller.getProfile().getUserName() + " the developer!");
            System.out.println("Which part do you wana go?");
            System.out.println("1_Profile");
            System.out.println("2_Devices");
            System.out.println("3_getBack");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            switch (input) {
                case 1:
                    ProfileChanges profileChanges = new ProfileChanges();
                    profileChanges.showOptions(allEmployes, seller);
                    break;
                case 2:
                    //DeviceChanges deviceChanges=new DeviceChanges();

                    seller.deviceChanges(store, allEmployes);
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Wrong input!Try agian.");
                    break;
            }
            if (input == 3) {
                break;
            }
        }
    }

    public void userMenu(Store store, AllUsers allUsers,int[] base) {
        while (true) {
            System.out.println("1_sign out");
            System.out.println("2_sign in");
            System.out.println("3_get back");
            System.out.println("4_Exit");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                SignUp signUp=new SignUp();
                signUp.signUp(allUsers);
            } else if (input == 2) {
                SignInMenu signInMenu=new SignInMenu();
                signInMenu.signIn(store, allUsers,base);
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



