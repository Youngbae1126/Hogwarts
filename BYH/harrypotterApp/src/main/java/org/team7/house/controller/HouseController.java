package org.team7.house.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team7.exception.ApiResponse;
import org.team7.house.dto.HouseDTO;
import org.team7.house.service.HouseService;
import org.team7.student.dto.StudentDTO;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {
    final private HouseService houseService;

    // GET :: /api/houses
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<HouseDTO>>> getAllHome() {
        log.info("========================> 전체 기숙사 목록 조회");

        try{
            houseService.getAllHome();
            ApiResponse<List<HouseDTO>> response = ApiResponse.success("전체 기숙사 목록입니다.", houseService.getAllHome());
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            ApiResponse<List<HouseDTO>> response = ApiResponse.failure("전체 기숙사 목록을 불러오지 못했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // GET :: /api/houses/{houseId}
    @GetMapping("/{houseId}")
    public ResponseEntity<ApiResponse<List<StudentDTO>>> getHome(@PathVariable int houseId) {
        log.info("========================> 기숙사 아이디 {}로 소속 학생 조회", houseId);
        try{
            List<StudentDTO> studentsListByHome = houseService.getHome(houseId);
            ApiResponse<List<StudentDTO>> response = ApiResponse.success("기숙사에 해당하는 학생 정보를 찾았습니다.", studentsListByHome);
            return ResponseEntity.status(HttpStatus.OK).body(response);

        } catch (Exception e) {
            log.info("기숙사 {}에 해당하는 학생 정보를 찾지 못했습니다.", houseId);
            ApiResponse<List<StudentDTO>> response = ApiResponse.failure("기숙사 아이디 " + houseId + "에 해당하는 학생 정보를 찾지 못했습니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
