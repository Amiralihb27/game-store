package ir.ac.kntu;

public class ProfileChanges {


    public void employees(AllEmployes allEmployes, Employes employes){
        System.out.println("1_your profile");
        System.out.println("2_other employees profile");
        System.out.println("3_get back");
        while (true){
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                showOptions(allEmployes,employes);
            } else if (input == 2) {


            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input!try again.");
            }
        }
    }

    public int findEmployee(AllEmployes allEmployes){
        while (true){
            System.out.println(" enter username:");
        }
    }
    public void showOptions(AllEmployes allEmployes, Employes employes) {
        while (true) {
            System.out.println("1_Show the personal informations");
            System.out.println("2_Edit informations");
            System.out.println("3_get back");
            int input = ScannerWrapper.getInt();
            if (input == 1) {
                printInformation(employes);
            } else if (input == 2) {
                editProfile(allEmployes, employes);
            } else if (input == 3) {
                break;
            } else {
                System.out.println("Wrong input!try again.");
            }
        }
    }

    public void printInformation(Employes employee) {
        System.out.println(employee.getProfile().toString());
    }

    public void editProfile(AllEmployes allEmployes, Employes employes) {
        int index = allEmployes.doesExist(employes.getProfile().getUserName(), employes.getProfile().getPassWord());
        if (index != -1) {
            String userInput;
            String passInput;
            while (true) {
                System.out.println("You can ge back by entering 'exit'.");
                System.out.println("Enter new username:");
                userInput = ScannerWrapper.getString();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("Enter new password:");
                passInput = ScannerWrapper.getString();
                if (findByName(userInput, allEmployes) != -1 &&
                        !allEmployes.getAllEmployes().get(index).getProfile().getUserName().equals(userInput)) {
                    System.out.println("This username has already been taken.Try again! ");
                } else if (!qualified(passInput)) {
                    System.out.print("not only your password must contain at least 1 capital and small letter. ");
                    System.out.println("but also it sould be more than 8 characters.Try again! ");
                } else {
                    allEmployes.getAllEmployes().get(index).getProfile().setUserName(userInput);
                    allEmployes.getAllEmployes().get(index).getProfile().setPassWord(passInput);
                    emailAndPhone(employes, allEmployes);
                    break;
                }
            }
        }
    }

    public int findByName(String userName, AllEmployes allEmployes) {
        for (int i = 0; i < allEmployes.getAllEmployes().size(); i++) {
            if (allEmployes.getAllEmployes().get(i).getProfile().getUserName().equals(userName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean qualified(String passWord) {
        if (passWord.matches("(.*[0-9]+.*)") && passWord.matches("(.*[a-z]+.*)") &&
                passWord.matches("(.*[A-Z]+.*)") && passWord.length() >= 8) {
            return true;
        }
        return false;
    }

    public int findByEmail(String email, AllEmployes allEmployes) {
        for (int i = 0; i < allEmployes.getAllEmployes().size(); i++) {
            if (allEmployes.getAllEmployes().get(i).getProfile().getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public int findByPhone(String phoneNumber, AllEmployes allEmployes) {
        for (int i = 0; i < allEmployes.getAllEmployes().size(); i++) {
            if (allEmployes.getAllEmployes().get(i).getProfile().getPhoneNumber().equals(phoneNumber)) {
                return i;
            }
        }
        return -1;
    }

    public void emailAndPhone(Employes employee, AllEmployes allEmployes) {
        while (true) {
            System.out.println("enter new email:");
            String email = ScannerWrapper.getString();
            System.out.println("enter new phon-number");
            String phoneNum = ScannerWrapper.getString();
            if (findByEmail(email, allEmployes) != -1 && !employee.getProfile().getEmail().equals(email)) {
                System.out.println("This email has been taken!Try again.");
            } else if (findByPhone(phoneNum, allEmployes) != -1 &&
                    !employee.getProfile().getPhoneNumber().equals(phoneNum)) {
                System.out.println("This phone number has been taken!Try again.");
            } else {
                employee.getProfile().setEmail(email);
                employee.getProfile().setPhoneNumber(phoneNum);
                break;
            }
        }

    }


}
