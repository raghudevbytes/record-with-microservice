package com.javatech.practicerecords;

import com.javatech.practicerecords.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{name: ?0}")
    User findByName(String name);
}
