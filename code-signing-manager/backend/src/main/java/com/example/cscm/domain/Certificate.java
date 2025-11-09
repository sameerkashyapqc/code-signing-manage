package com.example.cscm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document("certificates")
public class Certificate {

    @Id
    private String id;
    private String certificateName;
    private String issuerName;
    private LocalDate validFrom;
    private LocalDate validTo;
    private String status = "ACTIVE";

    // Getters + Setters
}

