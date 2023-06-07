package ir.ac.kntu;

import java.util.ArrayList;

public class User {
    // private PII pII;

    private Profile profile;

    private Library library;

    private Request request;

    private ArrayList<String> friendList;

    private Level level = Level.LEVEL_1;

    private int discount = 0;

    private int score = 0;

    private int timeSpent = 0;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(int[] base) {
        if (this.score >= 0 && this.score < base[0]) {
            this.level = Level.LEVEL_1;
            setDiscount(0);
        } else if (this.score >= base[0] && this.score < base[0]*2+10) {
            this.level = Level.LEVEL_2;
            setDiscount(base[1]);
        } else if (this.score >= base[0]*2+10 && this.score < (base[0]*2+10)*2) {
            this.level = Level.LEVEL_3;
            setDiscount(2*base[1]);
        } else if (this.score >= (base[0]*2+10)*2) {
            this.level = Level.LEVEL_4;
            setDiscount(3*base[1]);
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score,int[] base) {
        this.score = score;
        setLevel(base);
    }

    public void addScore(int[] base) {
        this.score += 1;
        setLevel( base);
        //ezafe shodan emtiaz user be ezaie har 5 s.
    }

    public int totalTimeSpent() {
        return (this.score * 5 + this.timeSpent);
        //modat zaman koli ke user dar barname boode.
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void addTime(int duration) {
        this.timeSpent += duration;
    }

    public Request getRequests() {
        return request;
    }

    public void setRequests(Request requests) {
        this.request = requests;
    }

    private Request requests;

    public ArrayList<String> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<String> friendList) {
        this.friendList = friendList;
    }

    public int friendsIndex(String userName) {
        for (int i = 0; i < friendList.size(); i++) {
            if (this.friendList.get(i).equals(userName)) {
                return i;
            }
        }
        return -1;
    }


    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }


    public User() {

    }

    public User(String username, String password, String phonenumber, String email) {
        this.profile = new Profile(username, password, phonenumber, email);
        friendList = new ArrayList<>();
        request = new Request();
        library = new Library();
    }

    public boolean isFriend(String userName) {
        for (int i = 0; i < this.friendList.size(); i++) {
            if (userName.equals(this.friendList.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void addFriend(String name) {
        friendList.add(name);
    }

    public void setUserPass(String username, String password) {
        this.profile.setUserName(username);
        this.profile.setPassWord(password);
    }

    public void setPII(String username, String password, String phonenumber, String email) {
        this.profile = new Profile(username, password, phonenumber, email);
    }

    public User(Profile profile) {
        this.profile = profile;
        friendList = new ArrayList<>();
        library = new Library();
        request = new Request();
    }

    public boolean checkUserName(String userName) {
        if (userName.equals(this.profile.getUserName())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return this.profile.toString()+" /Score:"+this.score;
    }


}
