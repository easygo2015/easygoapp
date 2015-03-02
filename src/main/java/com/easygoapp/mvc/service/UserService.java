package com.easygoapp.mvc.service;

import com.easygoapp.mvc.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */

public interface UserService {
    User saveUser(User user);
    void delete(Long id);
    User getById(Long id);
    User getByLogin(String login);
}
