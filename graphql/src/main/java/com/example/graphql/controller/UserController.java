package com.example.graphql.controller;


import java.util.List;

import com.example.graphql.model.User;
import com.example.graphql.model.UserRequest;
import com.example.graphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/all")
  List<User> getAllUserss() {
    return userService.getAllUsers();
  }

  @QueryMapping
  List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @QueryMapping
  User getUserById(@Argument Long id) {
    return userService.getUserById(id);
  }

  @MutationMapping
  User createUser(@Argument UserRequest userRequest) {
    return userService.createUser(userRequest);
  }

  @MutationMapping
  User updateUser(@Argument UserRequest userRequest) {
    return userService.updateUser(userRequest);
  }

  @MutationMapping
  Boolean deleteUser(@Argument Long id) {
    userService.deleteUser(id);
    return true;
  }
}
