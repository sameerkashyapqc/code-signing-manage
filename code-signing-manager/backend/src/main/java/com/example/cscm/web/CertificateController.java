package com.example.cscm.web;

import com.example.cscm.domain.Certificate;
import com.example.cscm.dto.CreateCertificateRequest;
import com.example.cscm.service.CertificateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin("*")
public class CertificateController {

    private final CertificateService service;

    public CertificateController(CertificateService service) {
        this.service = service;
    }

    @PostMapping
    public Certificate create(@RequestBody CreateCertificateRequest req) {
        return service.createCertificate(req);
    }

    @GetMapping
    public List<Certificate> all() {
        return service.getAllCertificates();
    }
}
