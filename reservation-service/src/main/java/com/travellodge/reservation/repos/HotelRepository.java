package com.travellodge.reservation.repos;

import com.travellodge.reservation.models.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {

  Optional<List<Hotel>> findAllByCity(final String city);

  Optional<Hotel> findAllById(final String id);

}
