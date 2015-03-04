package com.easygoapp.service;

import com.easygoapp.domain.User;
import com.easygoapp.service.impl.AbstractCrudServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by Станислав on 28.02.2015.
 */
@Service
public interface UserService extends AbstractCrudService<User, Long > {
    User getByLogin(String login);
    boolean checkLoginPassword(String login, String password);


}
