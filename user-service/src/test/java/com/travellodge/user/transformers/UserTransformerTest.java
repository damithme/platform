package com.travellodge.user.transformers;

import com.travellodge.user.models.User;
import com.travellodge.user.resources.transformers.UserTransformers;
import com.travellodge.user.resources.vo.UserVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@SpringBootTest
public class UserTransformerTest {

  @Autowired
  UserTransformers userTransformers;

  @Test
  public void testBuildUserVO() {
    User user = User.builder()
            .id("test_id")
            .username("test_username")
            .firstName("Jhon")
            .lastName("Smith")
            .email("jsmith@test.com")
            .mobile("4324")
            .build();
    final UserVO vo = userTransformers.buildUserVO(user);
    assertEquals(user.getId(), vo.getId());
    assertEquals(user.getEmail(), vo.getEmail());
  }
}
