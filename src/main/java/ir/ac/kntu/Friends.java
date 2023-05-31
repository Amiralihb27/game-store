package ir.ac.kntu;


import java.util.ArrayList;

public class Friends {


    public void usersFriends(User user) {

        if (user.getFriendList().size() >= 1) {
            for (int i = 0; i < user.getFriendList().size(); i++) {
                System.out.println((i + 1) + "_" + user.getFriendList().get(i));
            }
            chooseToSee(user);

        } else {
            System.out.println("You dont have any friends!");
        }

    }

    public void chooseToSee(User user) {
        int status;
        while (true) {
            System.out.println("Do you wana see your frinds games?");
            System.out.println("1_yes");
            System.out.println("2_No");
            status = ScannerWrapper.getInt();
            if (status == 1) {
                frindesGames(user);
            } else if (status == 2) {
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }


    public void frindesGames(User user) {
        int input;
        if (user.getFriendList().size() >= 1) {
            while (true) {
                System.out.println("Enter the related number which is shown near" +
                        " your frindes username to see thier game.");
                System.out.println("You can get back by entering -1.");
                input = ScannerWrapper.getInt();
                if (input == -1) {
                    break;
                } else if (input >= 1 && input <= user.getFriendList().size()) {
                    String userName = user.getFriendList().get(input - 1);
                    int index = AllUsers.findByName(userName);
                    User newUser = AllUsers.getUsers().get(index);
                    if (newUser.getLibrary() != null && newUser.getLibrary().getGames().size() > 0) {
                        newUser.getLibrary().listOfGames();
                        System.out.println("*********************");
                        break;
                    } else {
                        System.out.println("This user has no game.");
                        System.out.println("**********************");

                    }
                }

            }
        } else {
            System.out.println("You dont have any frinds.");
            System.out.println("*************************");
        }


    }

    public void findByName(User user) {
        //sc.nextLine();
        if (user.getFriendList().size() >= 1) {
            while (true) {
                System.out.println("you can get back by entering exit.");
                System.out.println("Enter the username:");
                String input = ScannerWrapper.getString();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                int countOfFounded = 0;
                if (user.getFriendList().size() >= 1) {
                    for (int i = 0; i < user.getFriendList().size(); i++) {
                        if (user.getFriendList().get(i).startsWith(input)) {
                            System.out.println((i + 1) + "_" + user.getFriendList().get(i));
                            countOfFounded++;
                        }

                    }
                    if (countOfFounded == 0) {
                        System.out.println("There is no user with this username in friendlist.");
                    }else{
                        chooseToSee(user);
                        break;
                    }
                    System.out.println("******************************************************");
                }
            }

        } else {
            System.out.println("You dont have any fiends.");
            System.out.println("*******************************************************");
        }


    }

    public void sendRequest(User user) {
        String input;
        // sc.nextLine();
        //ScannerWrapper.getString();
        while (true) {
            System.out.println("You can get back by entering 'exit'.");
            System.out.println("Enter the the username of whom you want him to be your friend.");
            input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            int index = AllUsers.findByName(input);
            if (index >= 0 && !input.equals(user.getProfile().getUserName())) {
                if (AllUsers.getUsers().get(index).getRequests() == null) {
                    Request request = new Request();
                    AllUsers.getUsers().get(index).setRequests(request);
                    AllUsers.getUsers().get(index).getRequests().addRequest(user.getProfile().getUserName());
                } else if (!AllUsers.getUsers().get(index).getRequests().hadRequested(user.getProfile().getUserName())
                        && !user.isFriend(input)) {
                    AllUsers.getUsers().get(index).getRequests().addRequest(user.getProfile().getUserName());
                } else {
                    System.out.println("You had sent him request before or You are this user's friend.");
                    System.out.println("****************************************");
                }

            } else {
                System.out.println("There is no username like this.Try again.");
                System.out.println("****************************************");
            }
        }
    }

    public void gift(User user) {
        if (user.getFriendList().size() >= 1 && user.getFriendList() != null) {
            while (true) {
                System.out.println("You can get back by entering exit.");
                System.out.println("Enter your friends username:");
                String input = ScannerWrapper.getString();
                if (input.equalsIgnoreCase("exit")) {
                    break;

                } else if (user.isFriend(input)) {
                    chooseToGift(user, input);
                } else {
                    System.out.println("There is no body with this username in your friendList.");
                }

            }
        } else {
            System.out.println("You dont have any friends.");
        }
    }

    public void chooseToGift(User user, String userName) {
        while (true) {
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter the games name:");
            String gamesName = ScannerWrapper.getString();
            if (gamesName.equalsIgnoreCase("exit")) {
                break;
            }
            ArrayList<GameStuff> games = Store.getGames();
            int status = GameChanges.doesExist(games, gamesName);
            if (status != -1) {
                if (user.getProfile().getWalletCash() >= games.get(status).getPrice()) {
                    double cash = user.getProfile().getWalletCash();

                    double gamesPrice = games.get(status).getPrice();
                    double currentAmount = cash - gamesPrice;
                    user.getProfile().setWalletCash(currentAmount);
                    int index = AllUsers.findByName(userName);
                    AllUsers.getUsers().get(index).getLibrary().addGame(games.get(status));
                    System.out.println("The game has been gifted");
                    System.out.println("*****************");
                    break;
                } else {
                    System.out.println("You dont have enough cash!");
                }
            } else {
                System.out.println("There is no game with this name.Try again.");
            }
        }


    }


}
