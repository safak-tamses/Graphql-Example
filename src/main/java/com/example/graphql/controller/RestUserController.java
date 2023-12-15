package com.example.graphql.controller;

import com.example.graphql.model.User;
import com.example.graphql.model.UserRequest;
import com.example.graphql.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class RestUserController {

    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAllUsers")
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("getUserById/{id}")
    User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("createUser")
    User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @PostMapping("updateUser")
    User updateUser(@RequestBody UserRequest userRequest) {
        return userService.updateUser(userRequest);
    }

    @DeleteMapping("deleteUser")
    Boolean deleteUser(@RequestHeader("id") Long id) {
        userService.deleteUser(id);
        return true;
    }


}
