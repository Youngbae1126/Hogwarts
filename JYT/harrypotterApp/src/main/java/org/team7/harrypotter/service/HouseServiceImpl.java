package org.team7.harrypotter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.team7.harrypotter.dto.HouseDTO;
import org.team7.harrypotter.mapper.HouseMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseMapper houseMapper;

    @Override
    public List<HouseDTO> getAllHouses() {
        return houseMapper.selectAllHouses();
    }

    @Override
    public HouseDTO getHouse(Integer houseId) {
        return houseMapper.selectHouseById(houseId);
    }
}