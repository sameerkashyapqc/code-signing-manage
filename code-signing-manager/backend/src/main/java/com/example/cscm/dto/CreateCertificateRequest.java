package com.example.cscm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateCertificateRequest {

    @NotBlank
    private String certificateName;

    @NotBlank
    private String issuerName;

    @NotNull
    private LocalDate validFrom;

    @NotNull
    private LocalDate validTo;

    // Getters + Setters
}
