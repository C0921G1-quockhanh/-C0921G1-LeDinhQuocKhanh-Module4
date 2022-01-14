package qk.user_login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.user_login.model.Login;
import qk.user_login.model.User;
import qk.user_login.repository.ILoginRepository;


@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginRepository iLoginRepository;

    @Override
    public User checkLogin(Login login) {
        return iLoginRepository.checkLogin(login);
    }
}
