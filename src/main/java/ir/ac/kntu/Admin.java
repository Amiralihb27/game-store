package ir.ac.kntu;

import java.time.Instant;
import java.util.ArrayList;
//import java.util.Scanner;

public class Admin extends Employes {


    public Admin() {

    }

    public Admin(Profile profile) {
        super(profile);
    }

    public void gameChanges(Store store, AllEmployes allEmployes) {
        ArrayList<GameStuff> games = store.getGames();
        GameChanges.showOptions(games, store, this, allEmployes);

    }

    public void crashReport(Store store, AllEmployes allEmployes) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> newGameStuff = gameList.extractVideoGames(store.getGames());
        gameList.showList(newGameStuff);
        System.out.println("enter the relate number to report the crash!");
        System.out.println("You can get back by entering exit!");
        while (true) {
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            int index = Integer.parseInt(input) - 1;
            if (index >= 0 && index < newGameStuff.size()) {
                store.getGames().remove(newGameStuff.get(index));
                ArrayList<Developer> developers = allEmployes.extractDeveloper();
                //  Developer employe = allEmployes.findTheLessBusyDeveloper(developers);
                GameStuff gameForGettingFixed = newGameStuff.get(index);
                allEmployes.sendTheReportMessage(allEmployes, gameForGettingFixed);
                break;
            } else {
                System.out.println("Wrong input.Try again.");
            }
        }
    }


    public void usersInfo( AllUsers allUsers) {
        int index = searchUser(allUsers);
        if (index != -1) {
            allUsers.getUsers().get(index).getProfile().show();
        }
    }

    public void userChanges(AllUsers allUsers) {

        while (true) {
            System.out.println("What do you wana do?");
            System.out.println("1_delete user");
            System.out.println("2_change users informations");
            System.out.println("3_Show users information");
            System.out.println("4_Add user");
            System.out.println("5_See the most online users");
            System.out.println("6_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                deleteUser(allUsers);
            } else if (input == 2) {
                editUser(allUsers);

            } else if (input == 3) {
                usersInfo(allUsers);
            } else if (input == 4) {
                addUser(allUsers);
            }else if (input == 5) {
                ShowTheMosts showTheMosts=new ShowTheMosts();
                ArrayList<User> users;
                users=new ArrayList<>(allUsers.getUsers());
                showTheMosts.sortByScore(users);
            } else if (input == 6) {
                break;
            } else {
                System.out.println("Wrong input!Try agian.");
            }

        }
    }

    public int searchUser(AllUsers allUsers) {
        System.out.println("How do you wana find the user");
        System.out.println("1_by username");
        System.out.println("2_by email");
        System.out.println("3_by phone number");
        System.out.println("4_get back");
        while (true) {

            int input = ScannerWrapper.getInt();
            if (input == 1) {
                return findByName(allUsers);
            } else if (input == 2) {
                return findByEmail(allUsers);
            } else if (input == 3) {
                return findByNumber(allUsers);
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Wrong input!Try agian.");
            }

        }
        return -1;
    }

    public int findByName(AllUsers allUsers) {

        // sc.nextLine();
        while (true) {
            System.out.println("you can go back to previous action by entering exit.");
            System.out.println("Enter the username:");
            String name = ScannerWrapper.getString();
            if (name.equals("exit")) {
                break;
            }
            int index = allUsers.findByName(name);
            if (index != -1) {
                return index;
            }
            System.out.println("there is no such username try again.");
        }
        return -1;
    }

    public int findByNumber(AllUsers allUsers) {
        // sc.nextLine();
        while (true) {
            System.out.println("you can go back to previous action by entering exit.");
            System.out.println("Enter the phone-number:");
            String number = ScannerWrapper.getString();
            if (number.equals("exit")) {
                break;
            }
            int index = allUsers.findByPhone(number);
            if (index != -1) {
                return index;
            }
            System.out.println("there is no such phone number try again.");
        }
        return -1;
    }


    public int findByEmail(AllUsers allUsers) {

        //sc.nextLine();
        while (true) {
            System.out.println("you can go back to previous action by entering exit.");
            System.out.println("Enter the email:");
            String email = ScannerWrapper.getString();
            if (email.equals("exit")) {
                break;
            }
            int index = allUsers.findByEmail(email);
            if (index != -1) {
                return index;
            }
            System.out.println("there is no such email try again.");
        }

        return -1;
    }


    public void deleteUser(AllUsers allUsers) {

        int index = searchUser(allUsers);
        if (index != -1) {

            if (allUsers.getUsers().get(index).getFriendList() != null) {
                deletFriend( index, allUsers);
            }
            allUsers.removeUser(allUsers.getUsers().get(index));
            //users.remove(index);
            System.out.println("User deleted!");
        } else {
            System.out.println("There is no user with this information.");
        }

    }

    public void deletFriend(int index, AllUsers allUsers) {
        for (int i = 0; i < allUsers.getUsers().get(index).getFriendList().size(); i++) {
            String friendsName = allUsers.getUsers().get(index).getFriendList().get(i);

            int wichFriend = allUsers.findByName(friendsName);
            int friendIndex =
                    allUsers.getUsers().get(wichFriend).friendsIndex(allUsers.
                            getUsers().get(index).getProfile().getUserName());
            allUsers.getUsers().get(wichFriend).getFriendList().remove(friendIndex);
        }
    }

    public void addUser(AllUsers allUsers) {
        String userInput;
        String passInput;
        //sc.nextLine();
        while (true) {
            System.out.println("You can get back by entering 'exit'.");
            System.out.println("Enter new username:");
            userInput = ScannerWrapper.getString();
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }
            if (allUsers.findByName(userInput) != -1) {
                System.out.println("This username has already been taken.Try again! ");
                continue;
            }
            System.out.println("Enter new password:");
            passInput = ScannerWrapper.getString();
            if (!allUsers.qualified(passInput)) {
                System.out.print("not only your password must contain at least 1 capital and small letter. ");
                System.out.println("but also it sould be more than 8 characters.Try again! ");
                continue;
            }
            System.out.println("enter new email:");
            String email = ScannerWrapper.getString();
            System.out.println("enter new phon-number");
            String phoneNum = ScannerWrapper.getString();
            if (checkForAdd(email, phoneNum, allUsers)) {
                Profile newProfile = new Profile(userInput, passInput, phoneNum, email);
                User newUser = new User(newProfile);
                //users.add(newUser);
                allUsers.addUser(newUser);
                System.out.println("User added.");
                System.out.println("*****************************");
                break;
            }
        }
    }

    public boolean checkForAdd(String email, String phoneNum, AllUsers allUsers) {
        if (allUsers.findByEmail(email) != -1) {
            System.out.println("This email has been taken!Try again.");
            return false;
        } else if (allUsers.findByPhone(phoneNum) != -1) {
            System.out.println("This phone number has been taken!Try again.");
            return false;
        }
        return true;
    }


    public void editUser( AllUsers allUsers) {

        int index = searchUser(allUsers);
        if (index != -1) {
            String userInput;
            String passInput;
            while (true) {
                System.out.println("You can ge back by entering 'exit'.");
                System.out.println("Enter new username:");
                userInput = ScannerWrapper.getString();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Enter new password:");
                passInput = ScannerWrapper.getString();
                //AllInformations tempInput = new AllInformations();
                if (allUsers.findByName(userInput) != -1 &&
                        !allUsers.getUsers().get(index).getProfile().getUserName().equals(userInput)) {
                    System.out.println("This username has already been taken.Try again! ");
                } else if (!allUsers.qualified(passInput)) {
                    System.out.print("not only your password must contain at least 1 capital and small letter. ");
                    System.out.println("but also it sould be more than 8 characters.Try again! ");
                } else {
                    allUsers.getUsers().get(index).getProfile().setUserName(userInput);
                    allUsers.getUsers().get(index).getProfile().setPassWord(passInput);
                    emailAndPhone(allUsers.getUsers().get(index), allUsers);
                    break;
                }
            }
        }
    }

    public void emailAndPhone(User user, AllUsers allUsers) {
        while (true) {
            System.out.println("enter new email:");
            String email = ScannerWrapper.getString();
            System.out.println("enter new phon-number");
            String phoneNum = ScannerWrapper.getString();
            if (allUsers.findByEmail(email) != -1 && !user.getProfile().getEmail().equals(email)) {
                System.out.println("This email has been taken!Try again.");
            } else if (allUsers.findByPhone(phoneNum) != -1 && !user.getProfile().getPhoneNumber().equals(phoneNum)) {
                System.out.println("This phone number has been taken!Try again.");
            } else {
                user.getProfile().setEmail(email);
                user.getProfile().setPhoneNumber(phoneNum);
                break;
            }
        }

    }
}
