package ir.ac.kntu;

public class Monitor extends GamingDevice {
    private int fPS;

    private int size;

    private int responseTime;

    public Monitor(int fPS, int size, int responseTime) {
        this.fPS = fPS;
        this.size = size;
        this.responseTime = responseTime;
    }

    public Monitor(){

    }

    public int getFPS() {
        return fPS;
    }

    public void setFPS(int fPS) {
        this.fPS = fPS;
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
    public void sell() {

    }

    @Override
    public String toString() {
        return "Monitor{" +
                "FPS=" + fPS +
                ", size=" + size + " inches" +
                ", responseTime=" + responseTime + " s" +
                '}'+super.toString();
    }
}
