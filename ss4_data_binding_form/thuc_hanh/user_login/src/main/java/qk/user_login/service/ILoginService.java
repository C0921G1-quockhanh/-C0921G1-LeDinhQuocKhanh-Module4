package qk.user_login.service;

import qk.user_login.model.Login;
import qk.user_login.model.User;


public interface ILoginService {
    public User checkLogin(Login login);
}
