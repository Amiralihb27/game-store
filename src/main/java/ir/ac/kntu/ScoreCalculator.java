package ir.ac.kntu;

public class ScoreCalculator {


    public  void usersScore(User user,int[] base){

        while (user.getTimeSpent()>=base[2]){
            user.addScore(base);
            user.setTimeSpent(user.getTimeSpent()-5);
        }
    }
}
