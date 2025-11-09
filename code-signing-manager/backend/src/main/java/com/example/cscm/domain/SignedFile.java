package com.example.cscm.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document("signed_files")
public class SignedFile {
    @Id
    private String id;
    private String fileName;
    private String certificateId;
    private String certificateName;
    private String status = "SIGNED";
    private LocalDateTime signedAt = LocalDateTime.now();

    // Getters + Setters
}

