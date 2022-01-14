package qk.user_login.repository;

import qk.user_login.model.Login;
import qk.user_login.model.User;


public interface ILoginRepository {
    public User checkLogin(Login login);
}
