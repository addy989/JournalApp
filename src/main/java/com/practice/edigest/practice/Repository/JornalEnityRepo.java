package com.practice.edigest.practice.Repository;

import com.practice.edigest.practice.Entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JornalEnityRepo extends MongoRepository<JournalEntity, String> {
}
