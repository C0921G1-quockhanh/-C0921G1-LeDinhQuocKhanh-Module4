package qk.practice_spring_authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import qk.practice_spring_authorization.model.MyUserDetail;
import qk.practice_spring_authorization.model.User;
import qk.practice_spring_authorization.repository.IUserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserServiceDetailImpl implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.iUserRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User name: " + username + " not found!");

        return new MyUserDetail(user);
    }
}
