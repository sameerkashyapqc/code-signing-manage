package com.example.cscm.web;

import com.example.cscm.domain.SignedFile;
import com.example.cscm.dto.SignFileRequest;
import com.example.cscm.service.SigningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sign")
@CrossOrigin("*")
public class SigningController {

    private final SigningService service;

    public SigningController(SigningService service) {
        this.service = service;
    }

    @PostMapping
    public SignedFile sign(@RequestBody SignFileRequest req) {
        return service.signFile(req);
    }

    @GetMapping
    public List<SignedFile> all() {
        return service.getAll();
    }
}
