package com.travellodge.reservation.repos;

import com.travellodge.reservation.models.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {

}
