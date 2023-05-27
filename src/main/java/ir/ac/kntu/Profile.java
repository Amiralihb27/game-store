package ir.ac.kntu;

import java.util.Scanner;

public class Profile extends PII {

    private double walletCash = 0;

    public double getWalletCash() {
        return walletCash;
    }

    public void setWalletCash(double walletCash) {
        this.walletCash = walletCash;
    }

    public Profile(String username, String password, String phonenumber, String email) {
        super.setUserName(username);
        super.setPhoneNumber(phonenumber);
        super.setPassWord(password);
        super.setEmail(email);
    }


    public void show() {
        super.print();
        System.out.println("wallet: " + walletCash);
    }

    public void edit( User user) {
        String userInput;
        String passInput;
        //sc.nextLine();
        //AllInformations.deletePII(user.getProfile());

        while (true) {
            System.out.println("Enter new username");
            userInput = ScannerWrapper.getString();
            System.out.println("Enter new password");
            passInput = ScannerWrapper.getString();
            // AllInformations tempInput = new AllInformations();
            if (AllUsers.findByName(userInput) != -1 && !user.getProfile().getUserName().equals(userInput)) {
                System.out.println("This username has already been taken.Try again! ");
            } else if (!AllUsers.qualified(passInput)) {
                System.out.print("not only your password must contain at least 1 capital and small letter. ");
                System.out.println("but also it sould be more than 8 characters.Try again! ");
            } else {
                super.setUserName(userInput);
                super.setPassWord(passInput);
                emailAndPhone( user);
                PII newPII = new PII(super.getPassWord(), super.getUserName(),
                        super.getPhoneNumber(), super.getPhoneNumber());
                //AllInformations.addPII(newPII);
                System.out.println("Do you wana add cash to your walet?");
                willPay();
                break;
            }
        }
    }

    public void emailAndPhone( User user) {
        while (true) {
            System.out.println("enter new email:");
            String email = ScannerWrapper.getString();
            System.out.println("enter new phon-number");
            String phoneNum = ScannerWrapper.getString();
            if (AllUsers.findByEmail(email) != -1 && !user.getProfile().getEmail().equals(email)) {
                System.out.println("This email has been taken!Try again.");
            } else if (AllUsers.findByPhone(phoneNum) != -1 && !user.getProfile().getPhoneNumber().equals(phoneNum)) {
                System.out.println("This phone number has been taken!Try again.");
            } else {
                super.setEmail(email);
                super.setPhoneNumber(phoneNum);
                break;
            }
        }

    }


    public void willPay() {
        while (true) {
            System.out.println("1_Yes");
            System.out.println("2_No");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                addCash();
                break;
            } else if (input == 2) {
                break;
            } else {
                System.out.println("Wrong input!try again.");
            }
        }

    }

    public void addCash() {
        System.out.println("Enter the amount of money.");
        double cash = ScannerWrapper.getDouble();
        this.walletCash += cash;
    }
}
