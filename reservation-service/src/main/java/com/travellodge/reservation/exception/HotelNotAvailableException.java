package com.travellodge.reservation.exception;

import java.time.LocalDate;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
public class HotelNotAvailableException extends RuntimeException {

  public HotelNotAvailableException(final String id, final LocalDate from, final LocalDate to) {
    super(String.format("Hotel ID: %s not available for from %s to %s.", id, from, to));
  }
}
