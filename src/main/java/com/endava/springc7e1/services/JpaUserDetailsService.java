package com.endava.springc7e1.services;

import com.endava.springc7e1.entities.User;
import com.endava.springc7e1.repositories.UserRepository;
import com.endava.springc7e1.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u =  userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(":("));

        return new SecurityUser(u);
    }
}
