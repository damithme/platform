package com.travellodge.reservation.services.clients.models;

import com.travellodge.common.models.PaymentType;
import com.travellodge.common.models.PaymentStatus;
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
public class HotelPayment {

  private String id;
  private String userId;
  private String hotelId;
  private BigDecimal amount;
  private PaymentType type;
  private PaymentStatus status;
}
