package com.example.cscm.service;

import com.example.cscm.domain.Certificate;
import com.example.cscm.dto.CreateCertificateRequest;
import com.example.cscm.repo.CertificateRepository;
import com.example.cscm.web.error.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    private final CertificateRepository repo;

    public CertificateService(CertificateRepository repo) {
        this.repo = repo;
    }

    public Certificate createCertificate(CreateCertificateRequest req) {
        if (!req.getValidTo().isAfter(req.getValidFrom())) {
            throw new BadRequestException("Valid TO must be after Valid FROM!");
        }

        Certificate c = new Certificate();
        c.setCertificateName(req.getCertificateName());
        c.setIssuerName(req.getIssuerName());
        c.setValidFrom(req.getValidFrom());
        c.setValidTo(req.getValidTo());

        return repo.save(c);
    }

    public List<Certificate> getAllCertificates() {
        return repo.findAll();
    }

    public Certificate findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Certificate not found!"));
    }
}
