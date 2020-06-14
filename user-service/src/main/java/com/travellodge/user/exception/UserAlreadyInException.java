package com.travellodge.user.exception;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
public class UserAlreadyInException extends RuntimeException {

  public UserAlreadyInException(final String username) {
    super(String.format("Username already exist. Username: %s.", username));
  }
}
