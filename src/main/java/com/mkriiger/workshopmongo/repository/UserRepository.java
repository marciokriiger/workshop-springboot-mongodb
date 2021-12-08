package com.mkriiger.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mkriiger.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
