package org.team7.house.service;

import org.team7.house.dto.HouseDTO;
import org.team7.student.dto.StudentDTO;

import java.util.List;

public interface HouseService {
    List<HouseDTO> getAllHome();
    List<StudentDTO> getHome(int houseId);
}

