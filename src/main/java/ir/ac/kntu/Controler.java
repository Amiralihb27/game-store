package ir.ac.kntu;

import java.util.ArrayList;

public class Controler extends GamingDevice {

    private Type type;
    private ArrayList<GamingDevice> pariredDevice = new ArrayList<>();


    public Controler(Type type, ArrayList<GamingDevice> pariredDevice) {
        this.type = type;
        this.pariredDevice = pariredDevice;
    }

    public Controler(int numberOfComponents, double price, Type type, ArrayList<GamingDevice> pariredDevice) {
        super(numberOfComponents, price);
        this.type = type;
        this.pariredDevice = pariredDevice;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<GamingDevice> getPariredDevice() {
        return pariredDevice;
    }

    public void setPariredDevice(ArrayList<GamingDevice> pariredDevice) {
        this.pariredDevice = pariredDevice;
    }

    @Override
    public void sell() {
        super.sell();
    }

    @Override
    public String toString() {
        return "Controler{" +
                "type=" + type +
                ", pariredDevice=" + pariredDevice +
                '}';
    }
}
