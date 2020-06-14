package com.travellodge.reservation.resources.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelVO {

  private String id;
  private String name;
  private String city;
  private int availableRooms;
  private BigDecimal roomPrice;
}
