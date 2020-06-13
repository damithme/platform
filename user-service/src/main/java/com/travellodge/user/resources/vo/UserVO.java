package com.travellodge.user.resources.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

  private String id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String mobile;
}
