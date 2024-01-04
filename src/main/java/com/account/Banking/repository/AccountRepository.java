package com.account.Banking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.account.Banking.model.Account;
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

}
