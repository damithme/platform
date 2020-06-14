package com.travellodge.payment.resources.transformers;

import com.travellodge.common.models.PaymentStatus;
import com.travellodge.common.models.PaymentType;
import com.travellodge.payment.models.Payment;
import com.travellodge.payment.resources.vo.HotelPaymentVO;
import org.springframework.stereotype.Component;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Component
public class PaymentTransformer {

  public Payment buildHotelPayment(final HotelPaymentVO paymentVO) {
    return Payment.builder()
            .hotelId(paymentVO.getHotelId())
            .userId(paymentVO.getUserId())
            .amount(paymentVO.getAmount())
            .type(PaymentType.HOTEL_RESERVATION)
            .status(PaymentStatus.DRAFT)
            .build();
  }

  public HotelPaymentVO buildHotelPaymentVO(final Payment payment) {
    return HotelPaymentVO.builder()
            .id(payment.getId())
            .hotelId(payment.getHotelId())
            .userId(payment.getUserId())
            .amount(payment.getAmount())
            .type(payment.getType())
            .status(payment.getStatus())
            .build();
  }

  public Payment buildExtraPayment() {
    throw new UnsupportedOperationException("Extra payment not supported yet.");
  }
}
