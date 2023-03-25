package com.example.threetier.services.impl;

import com.example.threetier.model.User;
import com.example.threetier.repository.UserRepository;
import com.example.threetier.services.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final RestTemplate restTemplate;

  public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate ) {
    this.userRepository = userRepository;
    this.restTemplate = restTemplate;
  }


  @Override
  public User getUserDetails(Long userId) {
    return null;
  }

  @Override
  public List<User> getAllUsers() {
    return null;
  }

  @Override
  public List<User> getAllAPIUsers() {
    User[] users = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/users/",User[].class).getBody();
    return Arrays.asList(users);
  }

  @Override
  public User getAPIUserDetail(Long userId) {
    User userDetail =  restTemplate.getForObject("https://jsonplaceholder.typicode.com/users/1",User.class);
    return userDetail;
  }

  @Override
  public User updateUserEmailDetails(Long userId) {

    User existingUser =  userRepository.findById(userId).get();
    if(Objects.isNull(existingUser))
      throw new RuntimeException("User doesn't exist in db");

    List<User> allUsers = getAllAPIUsers();
    String existingEmail = allUsers.stream().filter(u-> u.getName().equals(existingUser.getName())).findFirst().get().getEmail();
    existingUser.setEmail(existingEmail);
    return userRepository.save(existingUser);
  }

  @Override
  public User addUser(Long userId) {

    List<User> allUsers = getAllAPIUsers();
    User apiUser = allUsers.stream().filter(u-> u.getId().equals(userId)).findFirst().get();
    return userRepository.save(apiUser);
  }

  @Override
  public User getUserFromDB(Long userId) {
    return userRepository.findById(userId).get();
  }


}
