package com.travellodge.reservation.resources;

import com.travellodge.payment.resources.vo.HotelPaymentVO;
import com.travellodge.reservation.exception.HotelNotAvailableException;
import com.travellodge.reservation.models.Hotel;
import com.travellodge.reservation.resources.transformers.ReservationTransformers;
import com.travellodge.reservation.resources.vo.HotelVO;
import com.travellodge.reservation.resources.vo.ReservationVO;
import com.travellodge.reservation.services.HotelService;
import com.travellodge.reservation.services.ReservationService;
import com.travellodge.reservation.services.clients.UserClient;
import com.travellodge.reservation.services.clients.models.HotelPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Damith Ganegoda on 2020-06-12.
 */
@RestController
@RequestMapping("/reservations")
public class ReservationResource {

  @Autowired
  private HotelService hotelService;

  @Autowired
  private ReservationService reservationService;

  @Autowired
  private ReservationTransformers reservationTransformers;

  @GetMapping("/hotels/query")
  public List<HotelVO> searchHotels(@RequestParam("city") final String city, @RequestParam("from") final LocalDate from,
                                    @RequestParam("to") final LocalDate to) {
    final List<Hotel> hotels = hotelService.findAllHotelsByQuery(city, from, to);
    return reservationTransformers.buildHotelVOs(hotels);
  }

  @PostMapping
  public HotelPaymentVO reservation(@RequestBody final ReservationVO reservationVO) {

    final Hotel hotel = hotelService.findHotelAvailability(reservationVO.getHotelId(), reservationVO.getFrom(),
            reservationVO.getTo(), reservationVO.getNoOfRooms());
    if (hotel != null) {
      //reservation
      final HotelPayment payment = reservationService.reservation(
              reservationTransformers.buildReservation(reservationVO), hotel.getPrice());
      return reservationTransformers.buildHotelPaymentVO(payment);
    } else {
      throw new HotelNotAvailableException(reservationVO.getHotelId(), reservationVO.getFrom(), reservationVO.getTo());
    }
  }
}
