package com.travellodge.payment.repos;

import com.travellodge.payment.models.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
