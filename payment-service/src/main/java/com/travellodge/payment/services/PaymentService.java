package com.travellodge.payment.services;

import com.travellodge.common.models.PaymentStatus;
import com.travellodge.payment.models.Payment;
import com.travellodge.payment.repos.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Slf4j
@Service
public class PaymentService {

  @Autowired
  private PaymentRepository paymentRepository;

  /**
   * Process Hotel & Extra services payments
   *
   * @param payment {@link Payment}
   * @return {@link Payment}
   */
  public Payment processPayment(final Payment payment) {
    final String userId = payment.getUserId();
    log.info("Initiating to process the payment. Hotel Id: {}, Payment Type: {}, Amount: {}, User Id: {}.",
            payment.getHotelId(), payment.getType(), payment.getAmount(), userId);
    payment.setStatus(PaymentStatus.DRAFT);
    final Payment draftPayment = paymentRepository.save(payment);
    log.info("Initializing the payment. Payment Id: {}.", draftPayment.getId());

    //TODO do validations
    draftPayment.setStatus(PaymentStatus.PENDING);
    final Payment pendingPayment = paymentRepository.save(draftPayment);
    log.info("Pending the payment. Payment Id: {}.", pendingPayment.getId());

    //TODO process with Banks
    pendingPayment.setStatus(PaymentStatus.SUCCESS);
    final Payment successPayment = paymentRepository.save(pendingPayment);
    log.info("Payment has been processed. Payment Id: {}, Hotel Id: {}, Payment Type: {}, Amount: {}, User Id: {}.",
            successPayment.getId(), payment.getHotelId(), payment.getType(), payment.getAmount(), userId);
    return successPayment;
  }
}
