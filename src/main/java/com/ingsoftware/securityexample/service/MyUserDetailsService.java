package com.ingsoftware.securityexample.service;

import com.ingsoftware.securityexample.model.MyUserDetails;
import com.ingsoftware.securityexample.model.User;
import com.ingsoftware.securityexample.repository.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public MyUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> userOptional = repository.findByUsername(s);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("User with username " + s + " not found."));
        return userOptional.map(MyUserDetails::new).get();
    }

}
