package com.example.threetier.services;

import com.example.threetier.model.User;
import java.util.List;

public interface UserService {

  User getUserDetails(Long userId);

  List<User> getAllUsers();

  List<User> getAllAPIUsers();

  User getAPIUserDetail(Long userId);

  User updateUserEmailDetails(Long userId);

  User addUser(Long userId);

  User getUserFromDB(Long userId);

}
