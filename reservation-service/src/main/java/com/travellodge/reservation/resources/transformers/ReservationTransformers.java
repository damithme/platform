package com.travellodge.reservation.resources.transformers;

import com.travellodge.reservation.models.Hotel;
import com.travellodge.reservation.resources.vo.HotelVO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Component
public class ReservationTransformers {

  public List<HotelVO> buildHotelVOs(final List<Hotel> hotels) {
    return hotels.stream().map(this::buildHotel).collect(Collectors.toList());
  }

  public HotelVO buildHotel(final Hotel hotel) {
    return HotelVO.builder()
            .id(hotel.getId())
            .city(hotel.getCity())
            .availableRooms(hotel.getNoOfRooms()) //TODO need calculate available rooms based on reservations
            .roomPrice(hotel.getPrice())
            .build();
  }
}
