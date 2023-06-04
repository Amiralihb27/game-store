package ir.ac.kntu;

import java.util.ArrayList;

public class AllUsers {

    private  ArrayList<User> users;


    public AllUsers(){
        users = new ArrayList<>();
    }

    public  ArrayList<User> getUsers() {
        return users;
    }

    public  void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public  int findByName(String userName) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public  int findByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public  int findByPhone(String phoneNumber) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }


    public  void addUser(User user) {
        users.add(user);
    }

    public  void removeUser(User user) {
        if (findByName(user.getProfile().getUserName()) >= 0) {
            users.remove(findByName(user.getProfile().getUserName()));
        }
    }

    public  int existence(String userName, String passWord) {

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getProfile().getUserName().equals(userName) &&
                    users.get(i).getProfile().getPassWord().equals(passWord)) {
                return i;
            }
        }
        return -1;
    }

    public  boolean qualified(String passWord) {
        if (passWord.matches("(.*[0-9]+.*)") && passWord.matches("(.*[a-z]+.*)") &&
                passWord.matches("(.*[A-Z]+.*)") && passWord.length() >= 8) {
            return true;
        }
        return false;
    }
}
