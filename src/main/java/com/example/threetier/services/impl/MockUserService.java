package com.example.threetier.services.impl;

import com.example.threetier.model.User;
import com.example.threetier.services.UserService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MockUserService implements UserService {


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
    return null;
  }

  @Override
  public User getAPIUserDetail(Long userId) {
    return null;
  }

  @Override
  public User updateUserEmailDetails(Long userId) {
    return null;
  }

  @Override
  public User addUser(Long userId) {
    return null;
  }

  @Override
  public User getUserFromDB(Long userId) {
    return null;
  }
}
