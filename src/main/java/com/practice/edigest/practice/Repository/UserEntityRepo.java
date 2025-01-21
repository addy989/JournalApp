package com.practice.edigest.practice.Repository;

import com.practice.edigest.practice.Entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends MongoRepository<UserEntity,String> {
    UserEntity findByUsername(String username);
}
