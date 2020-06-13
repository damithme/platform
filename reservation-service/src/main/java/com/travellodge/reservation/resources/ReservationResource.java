package com.travellodge.reservation.resources;

import com.travellodge.reservation.services.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@RestController
@RequestMapping("/reservation")
public class ReservationResource {

  @Autowired
  private UserClient userClient;

  @GetMapping
  public String get() {

    String user = userClient.findUser();
    return "Reservation" + user;
  }
}
