package com.travellodge.reservation.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@FeignClient(name = "user-service")
public interface UserClient {

  @GetMapping("/user")
  String findUser();
}
