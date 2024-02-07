package com.example.crud.controller;

import com.example.crud.common.ApiResponse;
import com.example.crud.entity.User;
import com.example.crud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getUsers(
            @RequestParam (defaultValue = "0") int page,
            @RequestParam (defaultValue = "10") int size,
            @RequestParam (defaultValue = "id") String sortBy
    ) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(sortBy));
        final StopWatch stopWatch = super.startWatch("getUsers");
        try {
            return super.okResponse(userService.getUsers(pageable), "Users successfully retrieved");
        }catch (Exception e) {
            log.error("Error getting users", e);
            return super.koResponse(new ApiResponse<>(), e);
        }finally {
            log.info(stopWatch.shortSummary());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        this.userService.addUser(user);
        return ResponseEntity.ok("User successfully added");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
        return ResponseEntity.ok("User successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        this.userService.removeUser(id);
        return ResponseEntity.ok("User successfully deleted");
    }

}
