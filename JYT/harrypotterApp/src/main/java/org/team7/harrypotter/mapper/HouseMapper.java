package org.team7.harrypotter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.team7.harrypotter.dto.HouseDTO;

import java.util.List;

@Mapper
public interface HouseMapper {

    List<HouseDTO> selectAllHouses();

    HouseDTO selectHouseById(Integer houseId);

}