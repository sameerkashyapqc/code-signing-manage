package com.example.cscm.repo;

import com.example.cscm.domain.Certificate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CertificateRepository extends MongoRepository<Certificate, String> {
}
