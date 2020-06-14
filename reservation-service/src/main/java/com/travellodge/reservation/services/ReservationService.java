package com.travellodge.reservation.services;

import com.travellodge.common.models.PaymentType;
import com.travellodge.reservation.repos.HotelRepository;
import com.travellodge.reservation.repos.ReservationRepository;
import com.travellodge.reservation.services.clients.PaymentClient;
import com.travellodge.reservation.services.clients.models.HotelPayment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Slf4j
@Service
public class ReservationService {

  @Autowired
  private PaymentClient paymentClient;

  @Autowired
  private ReservationRepository reservationRepository;

  public void reservation() {
    final HotelPayment payment = HotelPayment.builder()
            .amount(new BigDecimal(100))
            .hotelId("323")
            .userId("32")
            .type(PaymentType.HOTEL_RESERVATION)
            .build();
    final HotelPayment paymentResponse = paymentClient.hotelPayment(payment);
  }


}
