package com.easygoapp.mvc.dao;

import com.easygoapp.mvc.domain.Trip;
import com.easygoapp.mvc.domain.User;

/**
 * Created by SCJP on 27.02.2015.
 */
public interface UserDao {
    void saveNewUser(User user);
    User getUserbyLogin(String login);
    User getUserbyId(Long id);
}
