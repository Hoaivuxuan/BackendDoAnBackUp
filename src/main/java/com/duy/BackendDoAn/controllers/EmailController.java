package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.dtos.EmailDTO;
import com.duy.BackendDoAn.services.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/email")
@RestController
public class EmailController {
    private final EmailService emailService;
    @PostMapping("")
    public ResponseEntity<String> sendEmail (@Valid @RequestBody EmailDTO emailDTO) {
        emailService.sendDefaultMessage(emailDTO);
        return ResponseEntity.ok("Message sent");
    }
}
