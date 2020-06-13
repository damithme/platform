package com.travellodge.user.resources;

import com.travellodge.user.models.User;
import com.travellodge.user.resources.transformers.UserTransformers;
import com.travellodge.user.resources.vo.UserVO;
import com.travellodge.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@RestController
@RequestMapping("/user")
public class UserResource {

  @Autowired
  private UserTransformers userTransformers;

  @Autowired
  private UserService userService;

  public UserResource() {

  }

  @GetMapping
  public String get() {
    return "User";
  }

  @PostMapping
  public UserVO createNewUser(@RequestBody final UserVO userVO) {
    final User newUser = userTransformers.buildUser(userVO);
    final User savedUser = userService.createUser(newUser);
    return userTransformers.buildUserVO(savedUser);
  }

}
