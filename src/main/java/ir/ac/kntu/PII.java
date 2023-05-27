package ir.ac.kntu;

public class PII {
    //Personally identifiable information
    private String passWord;

    private String userName;

    private String phoneNumber;

    private String email;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PII() {

    }

    public PII(String passWord, String userName, String phoneNumber, String email) {

        setEmail(email);
        setPassWord(passWord);
        setPhoneNumber(phoneNumber);
        setUserName(userName);
    }

    public String toString(){
        return "username: "+this.userName
                +"/ password: "+this.passWord
                +"/ email: "+this.email
                +"/phon-number:"+this.phoneNumber;
    }

    public void print(){
        System.out.println(this);
    }
}
