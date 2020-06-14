package com.travellodge.payment.resources;

import com.travellodge.payment.models.Payment;
import com.travellodge.payment.resources.transformers.PaymentTransformer;
import com.travellodge.payment.resources.vo.HotelPaymentVO;
import com.travellodge.payment.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@RestController
@RequestMapping("/payments")
public class PaymentResource {


  @Autowired
  private PaymentTransformer paymentTransformer;

  @Autowired
  private PaymentService paymentService;

  @PostMapping("/hotel")
  public HotelPaymentVO hotelPayment(@RequestBody final HotelPaymentVO paymentVO) {
    final Payment draftPayment = paymentTransformer.buildHotelPayment(paymentVO);
    final Payment processedPayment = paymentService.processPayment(draftPayment);
    return paymentTransformer.buildHotelPaymentVO(processedPayment);
  }

}
