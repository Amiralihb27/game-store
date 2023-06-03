package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;

public class DeviceChanges {

    public void showOptions(ArrayList<GameStuff> games, Store store, Employes employe, AllEmployes allEmployes) {
        while (true) {
            System.out.println("Which part do you wana go?");
            System.out.println("1_Add games");
            System.out.println("2_Edit game");
            System.out.println("3_Delet game");
            System.out.println("4_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                addDevice(store,employe);
            } else if (input == 2) {
                GameChanges.change(games);
            } else if (input == 3) {

                GameChanges.deletGame(games, store);
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }

    }

    public void addDevice(Store store,Employes employe) {
        System.out.println("What kind of devie you wana add?");
        System.out.println("1_Controller");
        System.out.println("2_Monitor");
        System.out.println("3_get back");
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                Controler device = new Controler();
                addController(device,store,employe);
                break;
            } else if (input == 2) {
                Monitor monitor = new Monitor();
                addMonitor(monitor,store,employe);
                break;
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public void addController(GamingDevice gamingDevice,Store store,Employes employe) {
        // System.out.println("Enter the type of the controller");
        while (true) {
            System.out.println("Enter the type of the controller");
            System.out.println("1_REMOTE");
            System.out.println("2_WIRED");
            System.out.println("3_get back");
            int input = ScannerWrapper.getInt();
            if (input == 3) {
                break;
            }
            if (input >= 1 && input <= Type.values().length
                    && gamingDevice.getClass().getSimpleName().equals("Controler")) {

                Controler controler = (Controler) gamingDevice;
                controler.setType(Type.values()[input - 1]);
                addINformation(gamingDevice,store,employe);

                break;
            } else {
                System.out.println("wrong input.try again!*****************");
            }

        }


    }

    public void addMonitor(GamingDevice gamingDevice, Store store, Employes employe){
        while (true) {
            System.out.println("Enter the type of the controller");
            System.out.println("1_REMOTE");
            System.out.println("2_WIRED");
            System.out.println("3_get back");
            int input = ScannerWrapper.getInt();
            if (input == 3) {
                break;
            }
            if (input >= 1 && input <= Type.values().length
                    && gamingDevice.getClass().getSimpleName().equals("Controler")) {

                Controler controler = (Controler) gamingDevice;
                controler.setType(Type.values()[input - 1]);
                addINformation(gamingDevice,store,employe);

                break;
            } else {
                System.out.println("wrong input.try again!*****************");
            }

        }

    }

    public void addINformation(GamingDevice gamingDevice, Store store, Employes employes) {
        System.out.println("enter the name of this device");
        String classNme=gamingDevice.getClass().getSimpleName();
        String name=ScannerWrapper.getString();
        if(classNme.equals("Controler")){
            gamingDevice.setName(classNme+" controller");
        } else if (classNme.equals("Monitor")) {
            gamingDevice.setName(classNme+" Monitor");
        }

        System.out.println("Enter the count of this device:");
        int count = ScannerWrapper.getInt();
        gamingDevice.setNumberOfComponents(count);
        System.out.println("Enter the price of this device:");
        double price = ScannerWrapper.getDouble();
        gamingDevice.setPrice(price);
        System.out.println("Enter a explanation for this device:");
        String explenation = ScannerWrapper.getString();
        gamingDevice.setExplenation(explenation);
        System.out.println("Enter one review about this device:");
        String review = ScannerWrapper.getString();
        gamingDevice.addReview(review);
        store.addDevice(gamingDevice);
        if (employes.getClass().getSimpleName().equals("Seller")) {
            Seller seller = (Seller) employes;
            seller.add(gamingDevice);
        }
    }


}
