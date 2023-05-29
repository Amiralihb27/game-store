package ir.ac.kntu;

public class GamingDevice {

    private int numberOfComponents;


    private String name;

    private double price;

    private String breifExplanation;

    public GamingDevice(int numberOfComponents, double price, String breifExplanation) {
        this.numberOfComponents = numberOfComponents;

        name = this.getClass().toString();

        this.price = price;
        breifExplanation = breifExplanation;
    }

    //public GamingDevice(int numberOfComponents,String name,double p)

    public String getBreifExplanation() {
        return breifExplanation;
    }

    public void setBreifExplanation(String breifExplanation) {
        this.breifExplanation = breifExplanation;
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
        return name;
    }

    public void setName(String name) {
        name = name;
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
