package com.travellodge.user.repos;

import com.travellodge.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Damith Ganegoda on 2020-06-14.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
