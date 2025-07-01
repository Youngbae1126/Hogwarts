package org.team7.harrypotter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team7.harrypotter.dto.HouseDTO;
import org.team7.harrypotter.service.HouseService;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService houseService;

    // 전체 기숙사 조회
    @GetMapping
    public ResponseEntity<List<HouseDTO>> getAllHouses() {
        return ResponseEntity.ok(houseService.getAllHouses());
    }

    // 특정 기숙사 조회
    @GetMapping("/{houseId}")
    public ResponseEntity<HouseDTO> getHouse(@PathVariable Integer houseId) {
        return ResponseEntity.ok(houseService.getHouse(houseId));
    }
    
}