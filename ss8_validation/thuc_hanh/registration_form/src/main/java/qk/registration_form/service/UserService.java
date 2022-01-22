package qk.registration_form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qk.registration_form.Model.User;
import qk.registration_form.Repository.IUserRepository;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        this.iUserRepository.save(user);
    }

}
