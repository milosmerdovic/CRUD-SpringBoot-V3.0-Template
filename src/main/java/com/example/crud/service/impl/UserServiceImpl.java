package com.example.crud.service.impl;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getUsers(PageRequest pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void addUser(User user) {
        this.userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User userForUpdate = userRepository.findById(user.getId()).get();
        userForUpdate.setName(user.getName());
        userForUpdate.setEmail(user.getEmail());
        userRepository.save(userForUpdate);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);

    }
}
