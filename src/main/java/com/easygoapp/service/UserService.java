package com.easygoapp.service;

import com.easygoapp.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public interface UserService {
    User saveUser(User user);
    void delete(Long id);
    User getById(Long id);
    User getByLogin(String login);
}
