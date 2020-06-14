package com.travellodge.reservation.services;

import com.travellodge.common.models.PaymentStatus;
import com.travellodge.common.models.PaymentType;
import com.travellodge.reservation.models.Reservation;
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

  /**
   * Make reservation
   *
   * @param reservation {@link Reservation}
   * @param amount total amount
   * @return {@link HotelPayment}
   */
  public HotelPayment reservation(final Reservation reservation, final BigDecimal amount) {
    final String userId = reservation.getUserId();
    final String hotelId = reservation.getHotelId();
    log.info("Creating reservation. User Id: {}, Hotel Id: {}, Amount {}.", userId, hotelId, amount);
    final HotelPayment payment = HotelPayment.builder()
            .amount(amount)
            .hotelId(hotelId)
            .userId(userId)
            .type(PaymentType.HOTEL_RESERVATION)
            .build();
    final HotelPayment paymentResponse = paymentClient.hotelPayment(payment);
    if (paymentResponse != null && payment.getStatus() == PaymentStatus.SUCCESS) {
      log.info("Payment success. Hotel Id: {}, User Id: {}, Payment Id: {}", hotelId, userId,
              paymentResponse.getId());
      final Reservation savedReservation = reservationRepository.save(Reservation.builder()
              .hotelId(hotelId)
              .userId(userId)
              .from(reservation.getFrom())
              .to(reservation.getTo())
              .build());
      log.info("Saved reservation. Reservation Id: {}", savedReservation.getId());

    }
    return paymentResponse;
  }




  private HotelPayment processPayment(final HotelPayment payment) {
    final HotelPayment paymentResponse = paymentClient.hotelPayment(payment);
    return null;
  }


}
