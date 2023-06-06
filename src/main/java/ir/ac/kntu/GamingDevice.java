package ir.ac.kntu;

import java.util.ArrayList;

public class GamingDevice extends GameStuff {

    private int numberOfComponents;

    private ArrayList<String>reportCrash=new ArrayList<>();


    public GamingDevice(int numberOfComponents, double price, String breifExplanation,String name) {
        this.numberOfComponents = numberOfComponents;

        super.setName(name);

        super.setPrice(price);

        super.setExplenation(breifExplanation);
    }

    //public GamingDevice(int numberOfComponents,String name,double p)


    public GamingDevice() {

    }


    public void addReport(String report){
        this.reportCrash.add(report);
    }

    public ArrayList<String> getReportCrash(){
        return new ArrayList<>(reportCrash);
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
                " in Store}";
    }
}
