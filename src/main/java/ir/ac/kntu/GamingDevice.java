package ir.ac.kntu;

public class GamingDevice extends GameStuff {

    private int numberOfComponents;


    public GamingDevice(int numberOfComponents, double price, String breifExplanation,String name) {
        this.numberOfComponents = numberOfComponents;

        super.setName(name);

        super.setPrice(price);

        super.setExplenation(breifExplanation);
    }

    //public GamingDevice(int numberOfComponents,String name,double p)


    public GamingDevice() {

    }


    public int getNumberOfComponents() {
        return numberOfComponents;
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

    @Override
    public String toString() {
        return "GamingDevice{" +super.toString()+
                "numberOfComponents=" + numberOfComponents +
                '}';
    }
}
