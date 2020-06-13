package com.travellodge.user.resources.transformers;

import com.travellodge.user.models.User;
import com.travellodge.user.resources.vo.UserVO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Component
public class UserTransformers {

  /**
   * Build {@link UserVO} form {@link User}
   * @param user {@link User}
   * @return transformed {@link UserVO}
   */
  public UserVO buildUserVO(final User user) {
    return UserVO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .mobile(user.getMobile())
            .build();
  }

  /** Build {@link User} form {@link UserVO}
   * @param vo {@link User}
   * @return transformed {@link User}
   */
  public User buildUser(final UserVO vo) {
    return User.builder()
            .created(LocalDateTime.now())
            .createdBy("Admin")
            .username(vo.getUsername())
            .firstName(vo.getFirstName())
            .lastName(vo.getLastName())
            .email(vo.getEmail())
            .mobile(vo.getMobile())
            .build();
  }
}
