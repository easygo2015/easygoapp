package com.easygoapp.repository;

import com.easygoapp.mvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Станислав on 28.02.2015.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
