package com.travellodge.reservation.exception;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
public class HotelNotFoundException extends RuntimeException {

  public HotelNotFoundException(final String id) {
    super(String.format("Hotel not found. Hotel id: {}", id));
  }
}
