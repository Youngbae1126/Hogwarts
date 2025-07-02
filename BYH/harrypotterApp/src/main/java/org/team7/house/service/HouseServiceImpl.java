package org.team7.house.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.team7.house.dto.HouseDTO;
import org.team7.house.mapper.HouseMapper;
import org.team7.student.domain.StudentVO;
import org.team7.student.dto.StudentDTO;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService{
    final private HouseMapper houseMapper;

    @Override
    public List<HouseDTO> getAllHome() {
        return houseMapper.getAllHome().stream()
                .map(HouseDTO::of)
                .toList();
    }

    @Override
    public List<StudentDTO> getHome(int houseId) {
        List<StudentVO> studentVoByHome = houseMapper.getHome(houseId);
        return studentVoByHome.stream()
                .map(StudentDTO::of)    // StudentDTO.of(Student VO vo)
                .toList();
    }
}
