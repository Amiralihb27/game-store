package ir.ac.kntu;

public class Inbox {
    private String message;

    private double duration;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Inbox(String message, double duration) {
        this.message = message;
        this.duration = duration;
    }

    public Inbox(){

    }
}
