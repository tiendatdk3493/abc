package com.tma.gbst.service;

import com.tma.gbst.model.Role;
import com.tma.gbst.model.User;
import com.tma.gbst.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Secured("ROLE_ADMIN")
    public User save (User user) {
        return userRepository.save(user);
    }

    @Secured("ROLE_ADMIN")
    public void delete(int userId ) {
        userRepository.delete(userRepository.findOne(userId));
    }

    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }
}
