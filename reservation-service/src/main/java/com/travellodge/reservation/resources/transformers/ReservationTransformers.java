package com.travellodge.reservation.resources.transformers;

import com.travellodge.payment.resources.vo.HotelPaymentVO;
import com.travellodge.reservation.models.Hotel;
import com.travellodge.reservation.models.Reservation;
import com.travellodge.reservation.resources.vo.HotelVO;
import com.travellodge.reservation.resources.vo.ReservationVO;
import com.travellodge.reservation.services.clients.models.HotelPayment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Component
public class ReservationTransformers {

  /**
   * Build {@link List} of {@link HotelVO}
   *
   * @param hotels {@link List} of {@link Hotel}
   * @return @link List} of {@link HotelVO}
   */
  public List<HotelVO> buildHotelVOs(final List<Hotel> hotels) {
    return hotels.stream().map(this::buildHotel).collect(Collectors.toList());
  }

  /**
   * Build {@link HotelVO}
   *
   * @param hotel {@link Hotel}
   * @return {@link HotelVO}
   */
  public HotelVO buildHotel(final Hotel hotel) {
    return HotelVO.builder()
            .id(hotel.getId())
            .city(hotel.getCity())
            .availableRooms(hotel.getNoOfRooms()) //TODO need calculate available rooms based on reservations
            .roomPrice(hotel.getPrice())
            .build();
  }

  /**
   * Build {@link Reservation}
   *
   * @param vo {@link ReservationVO}
   * @return build @link ReservationVO}
   */
  public Reservation buildReservation(final ReservationVO vo) {
    return Reservation.builder()
            .userId(vo.getUserId())
            .hotelId(vo.getHotelId())
            .from(vo.getFrom())
            .to(vo.getTo())
            .noOfRooms(vo.getNoOfRooms())
            .build();
  }

  /**
   * Build {@link HotelPaymentVO}
   *
   * @param payment {@link HotelPayment}
   * @return {@link HotelPaymentVO}
   */
  public HotelPaymentVO buildHotelPaymentVO(final HotelPayment payment) {
    return HotelPaymentVO.builder()
            .id(payment.getId())
            .amount(payment.getAmount())
            .status(payment.getStatus())
            .type(payment.getType())
            .build();
  }
}
