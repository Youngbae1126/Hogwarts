package org.team7.harrypotter.service;

import org.team7.harrypotter.dto.HouseDTO;

import java.util.List;

public interface HouseService {

    List<HouseDTO> getAllHouses();

    HouseDTO getHouse(Integer houseId);
}