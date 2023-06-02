package ir.ac.kntu;

public class Inbox {
    private GameStuff gameStuff;

    private double duration;


    public GameStuff getGameStuff() {
        return gameStuff;
    }

    public void setGameStuff(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Inbox(GameStuff games, double duration) {
        this.gameStuff = games;
        this.duration = duration;
    }

    public Inbox(){

    }
}
