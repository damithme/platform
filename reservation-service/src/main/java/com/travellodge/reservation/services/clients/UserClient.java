package com.travellodge.reservation.services.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@FeignClient(name = "user-service")
public interface UserClient {

  @GetMapping("/user")
  String findUser();
}
