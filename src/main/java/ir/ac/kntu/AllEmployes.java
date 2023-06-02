package ir.ac.kntu;

import java.util.ArrayList;

public class AllEmployes {

    private ArrayList<Employes> allEmployes;

    public AllEmployes(ArrayList<Employes> employes) {
        this.allEmployes = employes;
    }

    public AllEmployes() {
        allEmployes = new ArrayList<>();
    }

    public ArrayList<Employes> getAllEmployes() {
        return new ArrayList<Employes>(allEmployes);
    }

    public void addEmploye(Employes employes) {
        this.allEmployes.add(employes);
    }

    public int doesExist(String userName, String passWord) {
        for (int i = 0; i < this.allEmployes.size(); i++) {
            if (allEmployes.get(i).getProfile().getUserName().equals(userName) &&
                    allEmployes.get(i).getProfile().getPassWord().equals(passWord)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Developer> extractDeveloper() {
        ArrayList<Developer> developers = new ArrayList<>();
        for (int i = 0; i < this.allEmployes.size(); i++) {
            if (allEmployes.get(i).getClass().getSimpleName().equals("Developer")) {
                Developer temp = (Developer) allEmployes.get(i);
                developers.add(temp);
            }
        }
        return developers;
    }
}
