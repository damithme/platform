package com.travellodge.reservation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("reservation")
public class Reservation {

  @Id
  private String id;

  @CreatedDate
  private LocalDateTime created;

  @CreatedBy
  private String createdBy;

  @LastModifiedDate
  private LocalDateTime modified;

  @LastModifiedBy
  private String modifiedBy;

  private String hotelId;

  private String userId;

  private String paymentId;

  private LocalDate from;

  private LocalDate to;

  private int noOfRooms;
}
