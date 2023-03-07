package com.example.web.services;

import com.example.web.models.User;
import com.example.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Iterator<User> getAllUsers() {
        return userRepository.findAll().iterator();
    }

    public List<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public int getCountByName(String name) {
        return userRepository.countByName(name);
    }

    public List<User> findByMultiCondition(String name, String email) {
        return userRepository.findByNameAndEmail(name, email);
    }

    public List<User> findUsersIgnoreCase(String name) {
        return userRepository.findByNameIgnoreCase(name);
    }

    public List<User> getUsersCustomQuery() {
        return userRepository.getUsersCustomQuery();
    }
}
