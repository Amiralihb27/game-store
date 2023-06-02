package ir.ac.kntu;

public class Employes {

    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Employes(Profile profile){
        this.profile=profile;
    }

    public Employes(){

    }

}
