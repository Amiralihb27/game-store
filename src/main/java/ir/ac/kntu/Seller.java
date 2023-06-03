package ir.ac.kntu;

import java.util.ArrayList;

public class Seller extends Employes {
    private ArrayList<GameStuff> gamingDevice;


    public Seller(ArrayList<GamingDevice> gamingDevice) {
        for (int i = 0; i < gamingDevice.size(); i++) {
            if (gamingDevice.get(i).getClass().getSimpleName().equals("Seller")) {
                this.gamingDevice.add(gamingDevice.get(i));
            }
        }

    }


    public void add(GamingDevice device) {
        this.gamingDevice.add(device);
    }


    public void deviceChanges(Store store, AllEmployes allEmployes) {
        DeviceChanges deviceChanges = new DeviceChanges();
        deviceChanges.showOptions(gamingDevice, store, this, allEmployes);
    }


}
