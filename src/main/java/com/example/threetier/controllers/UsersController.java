package com.example.threetier.controllers;

import com.example.threetier.model.User;
import com.example.threetier.services.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

  private final UserService userService;

  public UsersController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/users/{id}")
  public User getUserDetails(@PathVariable Long id){
     return userService.getAPIUserDetail(id);
  }

  @GetMapping("/users")
  public List<User> getAllUsers(){
    return userService.getAllAPIUsers();
  }

  @PostMapping("/users/{id}")
  public User addUser(@PathVariable Long id){
    return userService.addUser(id);
  }

  @GetMapping("/users/fromdb/{id}")
  public User getUserFromDB(@PathVariable Long id){
    return userService.getUserFromDB(id);
  }

}
