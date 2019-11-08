package com.brooklyn.cuny.cisc4900.cisc4900.service;

import com.brooklyn.cuny.cisc4900.cisc4900.exceptions.User.UserAlreadyExistException;
import com.brooklyn.cuny.cisc4900.cisc4900.model.user.User;
import com.brooklyn.cuny.cisc4900.cisc4900.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User newUser) {
        try {
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            newUser.setUsername(newUser.getUsername());
            newUser.setStatus("active");
            //newUser.setRoles("ROLE_USER");
            //password and confirm password match
            //dont show or persis confirm password
            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UserAlreadyExistException("username:" + newUser.getUsername() + " already exist");
        }
    }
}
