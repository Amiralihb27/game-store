package ir.ac.kntu;

public class GamingDevice {

    private int numberOfComponents;
    private String Name;
    private double price;

    private String BreifExplanation;

    public GamingDevice(int numberOfComponents, double price, String breifExplanation) {
        this.numberOfComponents = numberOfComponents;

        Name = this.getClass().toString();

        this.price = price;
        BreifExplanation = breifExplanation;
    }

    //public GamingDevice(int numberOfComponents,String name,double p)

    public String getBreifExplanation() {
        return BreifExplanation;
    }

    public void setBreifExplanation(String breifExplanation) {
        BreifExplanation = breifExplanation;
    }

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
