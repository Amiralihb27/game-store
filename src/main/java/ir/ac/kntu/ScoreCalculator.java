package ir.ac.kntu;

public class ScoreCalculator {


    public  void usersScore(User user){

        while (user.getTimeSpent()>=5){
            user.addScore();
            user.setTimeSpent(user.getTimeSpent()-5);
        }
    }
}
