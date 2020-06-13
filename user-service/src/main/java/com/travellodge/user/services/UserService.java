package com.travellodge.user.services;

import com.travellodge.user.models.User;
import com.travellodge.user.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Slf4j
@Service
public class UserService {


  @Autowired
  private UserRepository userRepository;

  public UserService() {
  }

  /**
   * Create new {@link User}
   * @param user {@link User}
   * @return saved {@link User}
   */
  public User createUser(final User user) {
    log.info("Creating new user. Username {}.", user.getUsername());
    user.setCreatedBy("admin");
    final User savedUser = userRepository.save(user);
    log.info("Created new user. ID {}, Username {}", savedUser.getId(), savedUser.getUsername());
    return savedUser;
  }
}
