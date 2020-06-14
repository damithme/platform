package com.travellodge.user.services;

import com.travellodge.user.exception.UserNotFoundException;
import com.travellodge.user.models.User;
import com.travellodge.user.repos.UserRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@SpringBootTest
public class UserServiceTest {

  @Autowired
  UserService userService;

  @MockBean
  UserRepository mockUserRepository;

  @Test
  public void testGetUser() {
    final String userId = "test_id";
    User dummyUser = User.builder()
            .id(userId)
            .email("jsmith@gmail.com")
            .build();
    Mockito.when(mockUserRepository.findById(userId)).thenReturn(Optional.of(dummyUser));
    final User user = userService.getUser(userId);
    assertEquals(user.getId(), dummyUser.getId());
  }

  @Test(expected = UserNotFoundException.class)
  public void testGetUserNotFound() {
    final String userId = "test_id";
    User dummyUser = User.builder()
            .id(userId)
            .email("jsmith@gmail.com")
            .build();
    Mockito.when(mockUserRepository.findById(userId)).thenThrow(UserNotFoundException.class);
    final User user = userService.getUser(userId);
  }

}
