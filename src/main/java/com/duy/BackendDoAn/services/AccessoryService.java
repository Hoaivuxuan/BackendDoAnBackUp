package com.duy.BackendDoAn.services;

import com.duy.BackendDoAn.dtos.AccessoryDTO;
import com.duy.BackendDoAn.models.Accessory;
import com.duy.BackendDoAn.repositories.AccessoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccessoryService {
    public final AccessoryRepository accessoryRepository;
    public Accessory addAccessory(AccessoryDTO accessoryDTO) {
        Accessory newAccessory = Accessory.builder()
                .name(accessoryDTO.getName())
                .price(accessoryDTO.getPrice())
                .type(accessoryDTO.getType())
                .build();
        return accessoryRepository.save(newAccessory);
    }

    public List<Accessory> getAllAccessories(String type) {return accessoryRepository.findByType(type);}
}
