package org.team7.house.mapper;

import org.team7.house.domain.HouseVO;
import org.team7.student.domain.StudentVO;

import java.util.List;

public interface HouseMapper {

    // 전체 기숙사 목록 조회
    List<HouseVO> getAllHome();

    // 특정 기숙사 소속 학생들 조회
    List<StudentVO> getHome(int houseId);

}
