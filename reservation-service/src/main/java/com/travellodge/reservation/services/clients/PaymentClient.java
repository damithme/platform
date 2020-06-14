package com.travellodge.reservation.services.clients;

import com.travellodge.reservation.services.clients.models.HotelPayment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@FeignClient(name = "payment-service")
public interface PaymentClient {

  @PostMapping("/payments/hotel")
  HotelPayment hotelPayment(@RequestBody final HotelPayment hotelPayment);
}
