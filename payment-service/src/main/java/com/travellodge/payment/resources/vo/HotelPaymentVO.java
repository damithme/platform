package com.travellodge.payment.resources.vo;

import com.travellodge.common.models.PaymentStatus;
import com.travellodge.common.models.PaymentType;
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
public class HotelPaymentVO {

  private String id;
  private String userId;
  private String hotelId;
  private BigDecimal amount;
  private PaymentType type;
  private PaymentStatus status;
}
