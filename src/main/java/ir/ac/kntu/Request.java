package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class Request {
    private ArrayList<String> requests = new ArrayList<>();

    public ArrayList<String> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<String> requests) {
        this.requests = requests;
    }

    public void addRequest(String userName) {
        this.requests.add(userName);
        System.out.println("you have sent request succesfully.");
        System.out.println("**********************************");
    }

    public boolean hadRequested(String userName) {

        for (int i = 0; i < this.requests.size(); i++) {
            if (userName.equals(requests.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void showRequest(User user,AllUsers allUsers) {

        //sc.nextLine();
        while (true) {
            if (this.requests.size() > 0) {
                ArrayList<String> indexes = new ArrayList<>();
                System.out.println("You have requests from:");
                for (int i = 0; i < requests.size(); i++) {
                    System.out.println((i + 1) + "_" + requests.get(i));
                    indexes.add(Integer.toString(i + 1));
                }
                System.out.println("Enter the related number to see thier request.");
                String input;
                input = choose(indexes);
                if (!input.equalsIgnoreCase("exit")) {
                    acceptReq(user, Integer.parseInt(input),allUsers);
                    break;
                } else {
                    break;
                }
            } else {
                System.out.println("You dont have any requests.");
                break;
            }
        }
    }


    public String choose(ArrayList<String> index) {
        String input;

        //sc.nextLine();
        while (true) {
            System.out.println("you can get back by entering exit!");
            input = ScannerWrapper.getString();
            if (check(input, index) || input.equalsIgnoreCase("exit")) {
                return input;
            } else {
                System.out.println("Wrong input!Try again");
            }
        }
    }

    public boolean check(String input, ArrayList<String> index) {
        for (int i = 0; i < index.size(); i++) {
            if (input.equals(index.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void acceptReq(User user, int index,AllUsers allUsers) {
        System.out.println("messege from " + requests.get(index - 1) + ":will you be my friend?");
        System.out.println("1_yes");
        System.out.println("2_no");
        System.out.println("3_get back");
        int input;
        while (true) {

            input = ScannerWrapper.getInt();
            if (input == 1) {
                if (allUsers.findByName(requests.get(index - 1)) == -1) {
                    System.out.println("This user isnt available no longer");
                    requests.remove(index - 1);
                    break;
                } else {
                    if (user.isFriend(requests.get(index - 1))) {
                        System.out.println("You were his friend!");
                        requests.remove(index - 1);
                        break;
                    } else {
                        System.out.println(requests.get(index - 1) + " is your frined now.");
                        user.addFriend(requests.get(index - 1));
                        int otherUser = allUsers.findByName(requests.get(index - 1));
                        allUsers.getUsers().get(otherUser).addFriend(user.getProfile().getUserName());
                        requests.remove(index - 1);
                        break;
                    }

                }

            } else if (input == 2) {
                System.out.println("Request declined.");
                requests.remove(index - 1);
                break;
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }
}
