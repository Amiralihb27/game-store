package ir.ac.kntu;

public class Inbox {
    private GameStuff gameStuff;

    private Expiration duration;


    public GameStuff getGameStuff() {
        return gameStuff;
    }

    public void setGameStuff(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    public Expiration getDuration() {
        return duration;
    }

    public void setDuration(Expiration duration) {
        this.duration = duration;
    }

    public Inbox(GameStuff games, Expiration expiration) {
        this.gameStuff = games;

        this.duration=expiration;
    }

    public Inbox(GameStuff gameStuff){
        this.gameStuff = gameStuff;
    }

    public Inbox(){

    }
}
