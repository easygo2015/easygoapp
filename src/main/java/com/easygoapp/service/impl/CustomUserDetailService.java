package com.easygoapp.service.impl;

import com.easygoapp.domain.User;
import com.easygoapp.domain.UserRole;
import com.easygoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kir Kolesnikov on 04.03.2015.
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        //our domain entity User
        User usertoAuthorise = userService.getByLogin(login);
        List<GrantedAuthority> authorities = buildUserAuthority(usertoAuthorise.getUserRole());
        return new org.springframework.security.core.userdetails.User(usertoAuthorise.getLogin(),
                usertoAuthorise.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {

        List<SimpleGrantedAuthority> listAuth = new ArrayList<>();
        // Build user's authorities
        for (UserRole userRole : userRoles) {
            listAuth.add(new SimpleGrantedAuthority(userRole.getRole()));
        }
        return new ArrayList<GrantedAuthority>(listAuth);
    }
}
