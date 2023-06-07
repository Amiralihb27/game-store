package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;

public class DeviceChanges {

    public void showOptions(ArrayList<GameStuff> games, Store store, Employes employe, AllEmployes allEmployes) {
        while (true) {
            System.out.println("Which part do you wana go?");
            System.out.println("1_Add Device");
            System.out.println("2_Edit Device");
            System.out.println("3_Delet device");
            System.out.println("4_See Report Of DeviceCrasshes");
            System.out.println("5_get back");
            GameChanges gameChanges = new GameChanges();
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                addDevice(store, employe);
            } else if (input == 2 && hasDevice(games)) {
                gameChanges.change(games);
            } else if (input == 3 && hasDevice(games)) {
                gameChanges.deletGame(games, store);
            } else if (input == 4) {
                seeTheReportOfDeviceCrashes(games);
            } else if (input == 5) {
                break;
            } else {
                System.out.println("Try again!");
            }
        }

    }

    public boolean hasDevice(ArrayList<GameStuff> gameStuffs) {
        if (gameStuffs.size() > 0) {
            return true;
        } else {
            System.out.println("You didnt create any games");
            return false;
        }
    }

    public void addDevice(Store store, Employes employe) {
        System.out.println("What kind of devie you wana add?");
        System.out.println("1_Controller");
        System.out.println("2_Monitor");
        System.out.println("3_get back");
        while (true) {
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                Controler device = new Controler();
                addController(device, store, employe);
                break;
            } else if (input == 2) {
                Monitor monitor = new Monitor();
                addMonitor(monitor, store, employe);
                break;
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input!");
            }
        }
    }

    public void addController(GamingDevice gamingDevice, Store store, Employes employe) {
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
                addINformation(gamingDevice, store, employe);

                break;
            } else {
                System.out.println("wrong input.try again!*****************");
            }

        }


    }

    public void addMonitor(GamingDevice gamingDevice, Store store, Employes employee) {
        while (true) {
            System.out.println("Enter the frame per seconds  of the monitor");
            System.out.println("You can get back by entering -1");
            int fPS = ScannerWrapper.getInt();
            if (fPS == -1) {
                break;
            }
            System.out.println("Enter the size of the monitor:");
            int size = ScannerWrapper.getInt();
            System.out.println("enter the responstime of the monitor:");
            int responsTime = ScannerWrapper.getInt();
            //gamingDevice =
            gamingDevice = new Monitor(fPS, size, responsTime);
            addINformation(gamingDevice, store, employee);
            break;

        }

    }

    public void addINformation(GamingDevice gamingDevice, Store store, Employes employes) {
        System.out.println("enter the name of this device");
        String classNme = gamingDevice.getClass().getSimpleName();
        String name = ScannerWrapper.getString();
        if (classNme.equals("Controler")) {
            gamingDevice.setName(name + " controller");
        } else if (classNme.equals("Monitor")) {
            gamingDevice.setName(name + " monitor");
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
            System.out.println("Added***");
            Seller seller = (Seller) employes;
            seller.add(gamingDevice);
        }
    }

    public void seeTheReportOfDeviceCrashes(ArrayList<GameStuff> gameStuffs) {
        GameList gameList = new GameList();
        ArrayList<GameStuff> gamingDevices = gameList.extractDevices(gameStuffs);
        gameList.showList(gamingDevices);
        while (true) {
            System.out.println("Enter the related number to see the report if it has report.you can get back" +
                    " by entering '-1' .");
            int input = ScannerWrapper.getInt();
            if (input == -1) {
                break;
            }
            if (input >= 1 && input <= gamingDevices.size()) {
                GamingDevice device = (GamingDevice) gamingDevices.get(input - 1);
                System.out.println(device.getReportCrash());
                break;
            }
        }
    }

}
