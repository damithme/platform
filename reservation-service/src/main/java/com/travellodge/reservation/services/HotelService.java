package com.travellodge.reservation.services;

import com.travellodge.reservation.exception.HotelNotAvailableException;
import com.travellodge.reservation.models.Hotel;
import com.travellodge.reservation.repos.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Slf4j
@Service
public class HotelService {

  @Autowired
  private HotelRepository hotelRepository;

  /**
   * Search hotels by search query
   *
   * @param city city name
   * @param from from date
   * @param to to date
   * @return {@link List} of all available {@link Hotel}
   */
  public List<Hotel> findAllHotelsByQuery(final String city, final LocalDate from, final LocalDate to) {

    //TODO need to implement logic to search based on 'from' and 'to'
    if (StringUtils.isEmpty(city)) {
      return hotelRepository.findAll();
    } else {
      return hotelRepository.findAllByCity(city).orElse(Collections.emptyList());
    }
  }

  /**
   * Check given hotel rooms availability based on from & to dates.
   *
   * @param id Hotel Id
   * @param from from {@link LocalDate}
   * @param to to {@link LocalDate}
   * @param noOfRooms no of requested rooms
   * @return
   */
  public Hotel findHotelAvailability(final String id, final LocalDate from, final LocalDate to, final int noOfRooms) {
    log.info("Check hotel room availability. Hotel id: {}, from: {}, to: {}, no of rooms: {}", id, from, to, noOfRooms);
    //TODO need to check reservation for room availability
    return hotelRepository.findById(id).orElseThrow(() -> new HotelNotAvailableException(id, from, to));
  }


}
