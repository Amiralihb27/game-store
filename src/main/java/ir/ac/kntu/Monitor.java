package ir.ac.kntu;

public class Monitor extends GamingDevice {
    private int FPS;
    private int size;
    private int responseTime;

    public Monitor(int FPS, int size, int responseTime) {
        this.FPS = FPS;
        this.size = size;
        this.responseTime = responseTime;
    }

    public int getFPS() {
        return FPS;
    }

    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getResolution() {
        return responseTime;
    }

    public void setResolution(int responseTime) {
        this.responseTime = responseTime;
    }

    @Override
    public void sell(){

    }

    @Override
    public String toString() {
        return "Monitor{" +
                "FPS=" + FPS +
                ", size=" + size +" inches"+
                ", responseTime=" + responseTime +" s"+
                '}';
    }
}
