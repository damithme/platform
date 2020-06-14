package com.travellodge.payment.models;

import com.travellodge.common.models.PaymentType;
import com.travellodge.common.models.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("payment")
public class Payment {

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

  private String userId;

  private String hotelId;

  private String extraId;

  private PaymentType type;

  private PaymentStatus status;

  private BigDecimal amount;
}
