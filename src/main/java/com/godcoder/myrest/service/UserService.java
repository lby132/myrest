package com.godcoder.myrest.service;

import com.godcoder.myrest.model.Role;
import com.godcoder.myrest.model.User;
import com.godcoder.myrest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        System.out.println("user = " + user.getPassword());
        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        System.out.println("encodedPassword = " + encodedPassword);
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        final Role role = new Role();
        role.setId(1L);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

}
