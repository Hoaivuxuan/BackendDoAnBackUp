package com.duy.BackendDoAn.controllers;

import com.duy.BackendDoAn.models.Accessory;
import com.duy.BackendDoAn.services.AccessoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/accessory")
@RestController
public class AccessoryController {
    private final AccessoryService accessoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllAccessoryByType(@RequestParam String type) {
        List<Accessory> accessories = accessoryService.getAllAccessories(type);
        return ResponseEntity.ok(accessories);
    }
}
