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

    /**
     * Adds a user to the system.
     *
     * @param  user  the user to be added
     */
    void addUser(User user);

    /**
     * Updates a user.
     *
     * @param  user  the user object to be updated
     */
    void updateUser(User user);

    /**
     * Removes a user from the system.
     *
     * @param  id  of the user to be removed
     */
    void removeUser(Long id);


}
