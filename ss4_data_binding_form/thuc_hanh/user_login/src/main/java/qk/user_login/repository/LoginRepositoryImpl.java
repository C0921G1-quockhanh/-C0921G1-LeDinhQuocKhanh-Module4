package qk.user_login.repository;

import org.springframework.stereotype.Repository;
import qk.user_login.model.Login;
import qk.user_login.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRepositoryImpl implements ILoginRepository {

    private static List<User> users;

    static {
        users = new ArrayList<>();

        users.add(new User("john","123456","John","john@codegym.vn",10));
        users.add(new User("bill","123456","Bill","bill@codegym.vn",15));
        users.add(new User("mike","123456","Mike","mike@codegym.vn",16));
    }


    @Override
    public User checkLogin(Login login) {
        User checkedUser = null;

        for (User user: users) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                checkedUser = user;
            }
        }

        return checkedUser;
    }
}
