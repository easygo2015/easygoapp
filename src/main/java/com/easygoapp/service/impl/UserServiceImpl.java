package com.easygoapp.service.impl;

import com.easygoapp.domain.User;
import com.easygoapp.repository.UserRepository;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
       User savedUser = userRepository.saveAndFlush(user);
        return savedUser;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
