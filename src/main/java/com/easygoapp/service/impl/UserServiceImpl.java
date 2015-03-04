package com.easygoapp.service.impl;

import com.easygoapp.domain.User;
import com.easygoapp.repository.UserRepository;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */

@Service
public class UserServiceImpl extends AbstractCrudServiceImpl<User, Long> implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        super.setRepository(userRepository);
    }

    @Autowired
    BCryptPasswordEncoder encoder;

    public User save(User user){
        encoder.encode(user.getPassword());
        //TODO complete this method
        return  null;
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

}
