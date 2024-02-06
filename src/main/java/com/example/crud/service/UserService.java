package com.example.crud.service;

import com.example.crud.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * Retrieves a list of users.
     *
     * @return  a list of User objects representing the users
     */
    List<User> getUsers();

    /**
     * Retrieves a user by their ID.
     *
     * @param  id  the ID of the user to retrieve
     * @return     an optional containing the user with the specified ID, or an empty optional if no user is found
     */
    Optional<User> getUserById(Long id);

}
