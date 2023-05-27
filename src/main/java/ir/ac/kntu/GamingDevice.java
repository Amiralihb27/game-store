package ir.ac.kntu;

public class GamingDevice {

    private int numberOfComponents;
    private String Name;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }

    }

    public GamingDevice() {

    }

    public GamingDevice(int numberOfComponents, double price) {
        this.setNumberOfComponents(numberOfComponents);
        this.setPrice(price);
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumberOfComponents(int numberOfComponents) {
        if (numberOfComponents < 0) {
            this.numberOfComponents = 0;
        } else {
            this.numberOfComponents = numberOfComponents;
        }

    }

    public void sell() {

        this.numberOfComponents--;
    }
}
