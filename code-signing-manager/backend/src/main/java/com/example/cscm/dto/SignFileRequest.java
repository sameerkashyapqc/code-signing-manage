package com.example.cscm.dto;

import jakarta.validation.constraints.NotBlank;

public class SignFileRequest {

    @NotBlank
    private String fileName;

    @NotBlank
    private String certificateId;

    // Getters + Setters
}

