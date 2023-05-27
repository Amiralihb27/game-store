package ir.ac.kntu;

import java.util.ArrayList;

public class AllUsers {

    private static ArrayList<User> users;


    public AllUsers(){
        users = new ArrayList<>();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        AllUsers.users = users;
    }

    public static int findByName(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public static int findByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public static int findByPhone(String phoneNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }


    public static void addUser(User user) {
        users.add(user);
    }

    public static void removeUser(User user) {
        if (findByName(user.getProfile().getUserName()) >= 0) {
            users.remove(findByName(user.getProfile().getUserName()));
        }
    }

    public static int existance(String userName, String passWord) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getUserName().equals(userName) &&
                    users.get(i).getProfile().getPassWord().equals(passWord)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean qualified(String passWord) {
        if (passWord.matches("(.*[0-9]+.*)") && passWord.matches("(.*[a-z]+.*)") &&
                passWord.matches("(.*[A-Z]+.*)") && passWord.length() >= 8) {
            return true;
        }
        return false;
    }
}
