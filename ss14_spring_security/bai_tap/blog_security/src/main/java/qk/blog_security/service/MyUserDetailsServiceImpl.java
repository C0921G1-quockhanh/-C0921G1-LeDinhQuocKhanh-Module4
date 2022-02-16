package qk.blog_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import qk.blog_security.model.MyUserDetail;
import qk.blog_security.model.User;
import qk.blog_security.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("User name: " + username + " not found!");

        return new MyUserDetail(user);
    }
}
