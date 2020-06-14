package com.travellodge.reservation.resources.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationVO {
  private String id;
  private String hotelId;
  private String userId;
  private LocalDate from;
  private LocalDate to;
  private int noOfRooms;
}
