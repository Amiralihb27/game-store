package ir.ac.kntu;

public class FriendsMenu {


    public  void showOptions(User user,Store store,AllUsers allUsers) {

        Friends friends = new Friends();
        int input;
        while (true) {
            System.out.println("which part do you wana see? ");
            System.out.println("1_Show friend List");
            System.out.println("2_Search between friends");
            System.out.println("3_send request");
            System.out.println("4_gift");
            System.out.println("5_see request");
            System.out.println("6_get back");
            input = ScannerWrapper.getInt();
            if (input == 1) {
                friends.usersFriends(user,allUsers,store);
            } else if (input == 2) {
                friends.findByName(user,allUsers,store);
            } else if (input == 3) {
                friends.sendRequest(user,allUsers);

            } else if (input == 4) {
                friends.gift(user,store,allUsers);
            } else if (input == 5) {
                if (user.getRequests() != null) {
                    user.getRequests().showRequest(user,allUsers);
                } else {
                    System.out.println("This user has no requests.");
                }
            } else if (input == 6) {

                break;
            } else {
                System.out.println("Wrong input!Try again.");
            }

        }
    }
}
