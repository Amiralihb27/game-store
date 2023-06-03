package ir.ac.kntu;

import java.util.ArrayList;

public class Seller extends  Employes{
    private ArrayList<GamingDevice> gamingDevice;


    public Seller(ArrayList<GamingDevice> gamingDevice) {
        this.gamingDevice = gamingDevice;
    }


    public void add(GamingDevice device){
        this.gamingDevice.add(device);
    }






}
