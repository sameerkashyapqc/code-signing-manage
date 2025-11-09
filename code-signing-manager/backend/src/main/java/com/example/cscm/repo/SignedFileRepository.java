package com.example.cscm.repo;

import com.example.cscm.domain.SignedFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SignedFileRepository extends MongoRepository<SignedFile, String> {
}
