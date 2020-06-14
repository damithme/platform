package com.travellodge.user.exception;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException(final String id) {
    super(String.format("User not found. User id / username: %s.", id));
  }
}
