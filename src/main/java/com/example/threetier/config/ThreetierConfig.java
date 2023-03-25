package com.example.threetier.config;

import com.example.threetier.repository.UserRepository;
import com.example.threetier.services.UserService;
import com.example.threetier.services.impl.UserServiceImpl;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ThreetierConfig {

  private final UserRepository userRepository;

  public ThreetierConfig(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  public UserService userService(){
    return new UserServiceImpl(userRepository,restTemplate());
  }



}
