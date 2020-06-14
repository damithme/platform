package com.travellodge.user.services;

import com.travellodge.user.exception.UserAlreadyInException;
import com.travellodge.user.exception.UserNotFoundException;
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
   *
   * @param user {@link User}
   * @return saved {@link User}
   */
  public User createUser(final User user) {
    final String username = user.getUsername();
    log.info("Creating new user. Username: {}.", username);
    user.setCreatedBy("admin");

    //check username already exist
    final User alreadyExistUser = getUserByUsername(username);

    if (alreadyExistUser != null) {
      log.warn("Username already exist. Username: {}", username);
      throw new UserAlreadyInException(String.format("Username already exist. Username: %s", username));
    }

    final User savedUser = userRepository.save(user);
    log.info("Created new user. ID {}, Username {}", savedUser.getId(), savedUser.getUsername());
    return savedUser;
  }

  /**
   * Find {@link User} by id
   *
   * @param id User id
   * @return if found, return {@link User}. If not throws {@link UserNotFoundException}
   */
  public User getUser(final String id) {
    log.info("Getting user. User ID: {}.", id);
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  /**
   * Find {@link User} by username
   *
   * @param username Username
   * @return if found, return {@link User}. If not throws {@link UserNotFoundException}
   */
  public User getUserByUsername(final String username) {
    log.info("Getting user. Username: {}.", username);
    return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
  }
}
