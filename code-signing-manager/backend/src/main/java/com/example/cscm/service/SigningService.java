package com.example.cscm.service;

import com.example.cscm.domain.SignedFile;
import com.example.cscm.dto.SignFileRequest;
import com.example.cscm.repo.SignedFileRepository;
import org.springframework.stereotype.Service;

@Service
public class SigningService {

    private final CertificateService certificateService;
    private final SignedFileRepository repo;

    public SigningService(CertificateService certificateService, SignedFileRepository repo) {
        this.certificateService = certificateService;
        this.repo = repo;
    }

    public SignedFile signFile(SignFileRequest req) {
        var cert = certificateService.findById(req.getCertificateId());

        SignedFile s = new SignedFile();
        s.setFileName(req.getFileName());
        s.setCertificateId(cert.getId());
        s.setCertificateName(cert.getCertificateName());

        return repo.save(s);
    }

    public java.util.List<SignedFile> getAll() {
        return repo.findAll();
    }
}
