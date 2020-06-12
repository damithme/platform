package com.travellodge.user.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

  @GetMapping
  public String get() {
    return "User";
  }
}