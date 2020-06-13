package com.travellodge.user.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("user")
public class User {

  @Id
  private String id;

  @CreatedDate
  private LocalDateTime created;

  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private LocalDateTime modified;

  @LastModifiedBy
  private String modifiedBy;

  private String username;

  private String password;

  private String email;

  private String firstName;

  private String lastName;

  private String mobile;
}
