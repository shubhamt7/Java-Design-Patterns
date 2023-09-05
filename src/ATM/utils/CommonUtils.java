package ATM.utils;

import ATM.User;

import java.util.ArrayList;
import java.util.List;

public class CommonUtils {
    public static List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<User>();
        allUsers.add(new User(12, 32, 1234, 30000));
        allUsers.add(new User(13, 35, 1354, 20000));
        allUsers.add(new User(14, 13, 1564, 10000));
        allUsers.add(new User(15, 64, 1764, 54000));
        return allUsers;
    }
}
