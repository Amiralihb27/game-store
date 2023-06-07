package ir.ac.kntu;

public class SignUp {
    public  void signUp(AllUsers allUsers) {
        boolean status = true;
        while (status) {
            System.out.println("You can get back by entering exit.");
            System.out.println("Enter username:");
            String input = ScannerWrapper.getString();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            if (allUsers.findByName(input) != -1) {
                System.out.println("this username has been taken");
                continue;
            }
            System.out.println("Enter password:");
            String passInput;
            passInput = ScannerWrapper.getString();
            if (allUsers.qualified(passInput)) {
                System.out.println("Enter phone number:");
                String phonenumber = ScannerWrapper.getString();
                if (allUsers.findByPhone(phonenumber) != -1) {
                    System.out.println("this phone number has been taken");
                    continue;
                }
                System.out.println("Enter email:");
                String email = ScannerWrapper.getString();
                if (allUsers.findByEmail(email) != -1) {
                    System.out.println("this email has been taken");
                    continue;
                }
                User newUser = new User(input, passInput, phonenumber, email);
                //users.add(newUser);
                PII pII = new PII(passInput, input, phonenumber, email);
                //AllInformations.addPII(pII);
                allUsers.addUser(newUser);
                System.out.println("welcome " + input);
                break;
            } else {
                System.out.println("pass word should contain at least 8 characters" +
                        "including at least 1 number,upercase and lowercase letter");
            }
        }
    }
}
